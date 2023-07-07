import { PtyCommandExecutor } from "./CommandExecutor";
import { parseCommand } from "./grammar";
import InputHistory from "./InputHistory";
import { ASCII } from "./ASCII";
import { Callback, Consumer, TerdOpt } from "./types";
import OutputControl from "./OutputControl";

export default class Terd extends OutputControl {

  protected readonly keyHandlers: Map<string, Callback> = new Map();
  protected readonly executor = new PtyCommandExecutor();
  protected readonly pressKeyBind = this.processKey.bind(this);
  protected readonly forwardKeyBind = this.executor.write.bind(this.executor);

  protected dataListener: Consumer<string> = () => {};
  protected exitListener: Callback;

  private prevInput: number;

  constructor(private readonly opt?: TerdOpt) {
    super(opt?.printBanner, opt?.printPrompt);
    this.registerKeyHandlers();
  }

  private registerKeyHandlers() {
    const registerKeyHandler = (pattern: string, handler: Callback) =>
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
    registerKeyHandler('\x04', () => this.close());
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
  public on(event: 'exit', listener: Callback): void;
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

  private processKey(keystroke: Buffer) {
    // console.log(keystroke)
    const handler = this.keyHandlers.get(keystroke.toString());
    if (handler) {
      handler();
    } else {
      this.inputBuffer.push(keystroke);
    }
    this.prevInput = keystroke[0];
  }

  protected commit() {
    const input = this.inputBuffer.toString();
    if (input) {
      this.inputBuffer.pack();
      this.histories.push(input);
      const cmd = parseCommand(input);
      this.executor.execute(cmd).then((code) => {
        this.prompt(code === 0);
      });
    }
  }

  protected print(s: number | string | Buffer) {
    if (typeof(s) === 'string') {
      this.dataListener(s);
      return;
    } else if (s instanceof Buffer) {
      this.dataListener(s.toString());
      return;
    }

    this.dataListener(String.fromCharCode(s));
  }

  protected cwd(): string {
    return this.executor.cwd;
  }
}
