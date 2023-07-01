import CommandExecutor from "./CommandExecutor";
import { parseCommand } from "./grammar";
import chalk from 'chalk';
import fs from 'fs';
import path from "path";
import InputBuffer from "./InputBuffer";
import InputHistory from "./InputHistory";
import { ASCII, CSI } from "./ASCII";

const PackageInfo = require('../package.json') as any;

export default class Terd {

  protected readonly inputBuffer = new InputBuffer(this.print.bind(this));
  protected readonly histories = new InputHistory();
  protected readonly keyHandlers: Map<string, KeyHandler> = new Map();
  private pressKeyBind = this.processKey.bind(this);
  private prevInput: number;

  protected readonly executor = new CommandExecutor(
    this.stdin,
    this.stdout,
    this.stderr);

  constructor(private readonly opt?: TerdOpt,
    private readonly stdin: NodeJS.ReadStream = process.stdin,
    private readonly stdout: NodeJS.WriteStream = process.stdout,
    private readonly stderr: NodeJS.WriteStream = process.stderr) {
    this.registerKeyHandlers();
  }

  public run() {
    this.banner();
    this.prompt();

    const isRaw = this.stdin.isRaw;
    this.executor.beforeExecute(() => {
      this.stdin.off('data', this.pressKeyBind);
      this.stdin.pause();
      this.stdin.setRawMode(isRaw);
    });
    this.executor.afterExecute(() => {
      this.stdin.resume();
      this.stdin.on('data', this.pressKeyBind);
      this.stdin.setRawMode(true);
    });

    this.stdin.setRawMode(true);
    this.stdin.on('data', this.pressKeyBind);
    this.stdin.on('close', () => {
      this.print('\r\n');
    });
  }

  public close(force?: boolean) {
    this.executor.close(force);
    this.stdin.off('data', this.pressKeyBind);
  }

  protected exit() {
    this.close();
    // this.stdin.destroy();
    // process.exit(0);
  }

  private processKey(keystroke: Buffer) {
    const handler = this.keyHandlers.get(keystroke.toString());
    if (handler) {
      handler();
    } else {
      this.inputBuffer.push(keystroke);
    }
    this.prevInput = keystroke[0];
  }

  protected banner() {
    if (this.opt?.printBanner) {
      let lines = fs.readFileSync(path.resolve(__dirname, 'banner.txt')).toString().split('\r\n')
      .map((line) => chalk.greenBright(line))
      // lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
      lines[lines.length - 4] += chalk.redBright('v' + PackageInfo.version)
      lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
      lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
      this.print(lines.join('\r\n') + '\r\n');
    }
  }

  protected prompt() {
    if (this.opt?.printPrompt) {
      const str = chalk.cyan(this.executor.cwd) + (this.executor.lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
      this.print(str);
    }
  }

  protected commit() {
    const input = this.inputBuffer.toString();
    if (input) {
      this.inputBuffer.pack();
      this.histories.push(input);
      const cmd = parseCommand(input);
      this.executor.execute(cmd).then((code) => {
        this.prompt();
      });
    }
  }

  private registerKeyHandlers() {
    const newlineHandler = () => {
      if (this.prevInput === 3) {
        this.print('\n');
        this.prompt();
      } else {
        this.commit();
      }
    };
    this.registerKeyHandler('\r', newlineHandler);
    this.registerKeyHandler('\n', newlineHandler);
    this.registerKeyHandler('\x03', () => {
      if (this.inputBuffer.hasInput()) {
        this.inputBuffer.clear();
        this.histories.resetCursors();
      } else if (this.prevInput == 3) {
        this.exit();
      } else {
        this.print('\n(To exit, press Ctrl+C again or Ctrl+D)');
      }
    }); // ctrl c
    this.registerKeyHandler('\x04', () => this.exit()); // ctrl d
    this.registerKeyHandler('\x7F', () => this.backspace());
    this.registerKeyHandler(ASCII.Up, () => {
      if (!this.inputBuffer.hasInput() || this.inputBuffer.toString() === this.histories.current) {
        const history = this.histories.previous;
        if (history !== undefined) {
          this.inputBuffer.replace(history);
        }
      }
    });
    this.registerKeyHandler(ASCII.Down, () => {
      if (!this.inputBuffer.hasInput() || this.inputBuffer.toString() === this.histories.current) {
        const history = this.histories.next;
        this.inputBuffer.replace(history);
      }
    });
    this.registerKeyHandler(ASCII.Backward, () => this.inputBuffer.moveCursor(-1));
    this.registerKeyHandler(ASCII.Forward, () => this.inputBuffer.moveCursor(1));
  }

  private registerKeyHandler(seq: string, handler: KeyHandler) {
    this.keyHandlers.set(seq, handler);
  }

  private print(s: number | string | Buffer) {
    if (typeof(s) === 'string') {
      this.stdout.write(s);
      return;
    } else if (s instanceof Buffer) {
      this.stdout.write(s);
      return;
    }

    this.stdout.write(String.fromCharCode(s));
  }

  protected printError(chunk: Buffer | string) {
    this.stderr.write(chunk);
  }

  private backspace() {
    if (this.inputBuffer.pop() !== undefined) {
      this.print(`${CSI.CUB(1)}${CSI.DCH(1)}`);
    }
  }
}
