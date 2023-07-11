import { PtyCommandExecutor } from "./CommandExecutor";
import { parseCommand } from "./grammar";
import { ASCII } from "./ASCII";
import { Callback, Consumer, TerdOpt } from "./types";
import OutputControl from "./OutputControl";
import CommandContext from "./builtin/CommandContext";
import executeBuiltinCommand, { searchCommand } from "./builtin/Builtins";

export default class Terd extends OutputControl {

  protected commandContext = new CommandContext();
  protected readonly keyHandlers: Map<string, Callback<boolean>> = new Map();
  protected readonly executor = new PtyCommandExecutor(this.commandContext);

  protected dataListener: Consumer<string> = () => {};
  protected exitListener: Callback<void>;

  private prevInput: number;
  private lastOutput: number;
  private printer = this.print.bind(this);

  constructor(private readonly opt?: TerdOpt) {
    super(opt?.printBanner, opt?.printPrompt);
    this.commandContext.pwd = process.cwd().replace(/\\/g, '/');
    this.registerKeyHandlers();
    this.executor.before('execute', () => {
    });
    this.executor.on('data', (s) => this.print(s));
    this.executor.after('execute', (e) => {
      if (this.lastOutput !== 10) {
        this.print('\n');
      }
    });
  }

  private registerKeyHandlers() {
    const registerKeyHandler = (pattern: string, handler: Callback<boolean>) =>
      this.keyHandlers.set(pattern, handler);
    const newlineHandler = () => {
      if (this.prevInput === 3) {
        this.print('\n');
        this.prompt();
      } else {
        this.commit();
      }
    };
    registerKeyHandler('\r', newlineHandler);
    registerKeyHandler('\n', newlineHandler);
    // ctrl c
    registerKeyHandler('\x03', () => {
      if (this.inputBuffer.hasInput()) {
        this.clearInput();
      } else if (this.prevInput == 3) {
        this.close();
      } else {
        this.print('\n(To exit, press Ctrl+C again or Ctrl+D)');
      }
    });
    // ctrl d
    registerKeyHandler('\x04', () => {
      this.close();
    });
    registerKeyHandler('\x09', () => {
      if (!this.autoComplete()) {
        this.inputBuffer.push(9);
      }
    });
    registerKeyHandler('\x7F', () => this.backspace());
    registerKeyHandler(ASCII.Delete, () => this.delete());
    registerKeyHandler(ASCII.Up, () => this.showPrevInput());
    registerKeyHandler(ASCII.Down, () => this.showNextInput());
    registerKeyHandler(ASCII.Backward, () => this.inputBuffer.moveCursor(-1));
    registerKeyHandler(ASCII.Forward, () => this.inputBuffer.moveCursor(1));
  }

  public write(input: string) {
    this.processKey(Buffer.from(input));
  }

  public on(event: 'data', listener: Consumer<string>): void;
  public on(event: 'exit', listener: Callback<void>): void;
  public on(event: string, listener: any) {
    if (!listener) {
      throw new Error('event listener is ' + listener);
    }
    switch (event) {
      case 'data':
        this.dataListener = listener;
        break;
      case 'exit':
        this.exitListener = listener;
        break;
      default:
        throw new Error('invalid event ' + event);
    }
  }

  public close() {
    this.executor.close(true);
  }

  protected processKey(keystroke: Buffer) {
    if (this.executor.executing) {
      this.executor.write(keystroke.toString());
    } else {
      const handler = this.keyHandlers.get(keystroke.toString());
      if (handler) {
        handler();
      } else {
        this.inputBuffer.push(keystroke);
      }
      this.prevInput = keystroke[0];
    }
  }

  protected commit() {
    const input = this.inputBuffer.toString();
    if (input) {
      this.inputBuffer.pack();
      this.histories.push(input);
      const cmd = parseCommand(input);
      executeBuiltinCommand(this.commandContext, cmd)
        .then(() => this.prompt(false))
        .catch(code => {
          if (code == -2) {
            // didn't hit builtin command
            this.executor.execute(cmd).then((code) => this.prompt(code !== 0));
          } else {
            this.prompt(true);
          }
        })
    }
  }

  protected print(s: number | string | Buffer) {
    if (typeof(s) === 'string') {
      this.lastOutput = s.charCodeAt(s.length - 1);
      this.dataListener(s);
      return;
    } else if (s instanceof Buffer) {
      this.lastOutput = s[s.length - 1];
      this.dataListener(s.toString());
      return;
    }

    this.lastOutput = s;
    this.dataListener(String.fromCharCode(s));
  }

  protected pwd(): string {
    return this.commandContext.pwd;
  }

  protected searchCommand(input: string): string[] {
    return searchCommand(input);
  }
}
