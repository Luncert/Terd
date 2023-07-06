import Terd from "./Terd";

export default class TerdInterface extends Terd {

  protected readonly isRaw = this.input.isRaw;

  constructor(protected readonly input: NodeJS.ReadStream = process.stdin,
    protected readonly output: NodeJS.WriteStream = process.stdout) {
    super({ printPrompt: true });

    this.executor.on('data', (s) => this.print(s));
    this.executor.before('execute', () => {
      this.input.off('data', this.pressKeyBind);
      this.input.setRawMode(this.isRaw);
      this.input.on('data', this.forwardKeyBind);
    });
    this.executor.after('execute', (e) => {
      this.input.off('data', this.forwardKeyBind);
      this.input.setRawMode(true);
      this.input.on('data', this.pressKeyBind);
    });

    this.input.setRawMode(true);
    this.input.on('data', this.pressKeyBind);

    this.on('data', data => this.output.write(data));
  }

  public run() {
    this.banner();
    this.prompt();
  }

  public close() {
    super.close();
    this.input.setRawMode(this.isRaw);
    this.input.off('data', this.forwardKeyBind);
    this.input.off('data', this.pressKeyBind);
    this.input.destroy();
    this.print('\r\n');
    process.exit(0);
  }
}
