import Terd from "./Terd";
import { ASCII, CSI } from "./ASCII";

export default class TerdTerminal extends Terd {
  
  private prevInput: number;
  private readonly processKeyBind = this.processKey.bind(this);
  private readonly keyHandlers: Map<string, KeyHandler> = new Map();

  constructor(opt?: TerdOpt) {
    super(opt);
    this.on('data', (data) => process.stdout.write(data));
    this.on('error', (data) => process.stderr.write(data));
    this.registerKeyHandlers();
  }

  public run() {
    this.banner();
    this.prompt();

    this.executor.beforeExecute(() => {
      process.stdin.off('data', this.processKeyBind);
      process.stdin.setRawMode(false);
    });
    this.executor.afterExecute(() => {
      process.stdin.setRawMode(true);
      process.stdin.on('data', this.processKeyBind);
    });

    process.stdin.setRawMode(true);
    process.stdin.on('data', this.processKeyBind);
    process.stdin.on('close', () => {
      this.onData('\r\n');
      super.exit();
    });
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

  private registerKeyHandlers() {
    const newlineHandler = () => {
      if (this.prevInput === 3) {
        this.onData('\n');
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
        this.onData('\n(To exit, press Ctrl+C again or Ctrl+D)');
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

  protected exit() {
    process.stdin.off('data', this.processKeyBind);
    process.stdin.destroy();
  }

  private print(s: number | string | Buffer) {
    if (typeof(s) === 'string') {
      this.onData(s);
      return;
    } else if (s instanceof Buffer) {
      for (const c of s) {
        this.onData(String.fromCharCode(c));
      }
      return;
    }

    this.onData(String.fromCharCode(s));
  }

  private backspace() {
    if (this.inputBuffer.pop() !== undefined) {
      this.print(`${CSI.CUB(1)}${CSI.DCH(1)}`);
    }
  }
}