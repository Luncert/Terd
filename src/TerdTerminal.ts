import Terd from "./Terd";

export default class TerdTerminal extends Terd {
  
  private prevCh = 0;
  private readonly processKeyBind = this.processKey.bind(this);

  public run() {
    this.banner();
    this.prompt();
    process.stdin.setRawMode(true);
    process.stdin.on('data', this.processKeyBind);
    process.stdin.on('close', () => {
      this.onData('\r\n');
      super.exit();
    })
  }

  private processKey(keystroke: Buffer) {
    const c = keystroke[0];
    switch (c) {
      case 3: // ctrl c
        if (this.hasInput()) {
          this.clearBuffer();
          this.onData('\r\n');
          this.prompt();
        } else if (this.prevCh == 3) {
          this.exit();
        } else {
          this.prevCh = c;
          this.onData('\n(To exit, press Ctrl+C again or Ctrl+D)');
        }
        return;
      case 4: // ctrl d
        this.exit();
      default:
        this.print(c); // echo
        this.process(String.fromCharCode(c), c);
    }
    this.prevCh = c;
  }

  private print(c: number) {
    if (c == 13) {
      this.onData('\n');
    } else {
      this.onData(String.fromCharCode(c));
    }
  }

  protected exit() {
    process.stdin.off('data', this.processKeyBind);
    process.stdin.destroy();
  }
}