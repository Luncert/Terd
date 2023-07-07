import Terd from "./Terd";

export default class TerdInterface extends Terd {

  protected readonly isRaw = this.input.isRaw;
  protected readonly pressKeyBind = super.processKey.bind(this);

  constructor(protected readonly input: NodeJS.ReadStream = process.stdin,
    protected readonly output: NodeJS.WriteStream = process.stdout) {
    super({ printPrompt: true });

    this.executor.on('data', (s) => this.print(s));

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
    this.input.off('data', this.pressKeyBind);
    this.input.destroy();
    this.print('\r\n');
    process.exit(0);
  }
}
