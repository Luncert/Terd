import CommandExecutor from "./CommandExecutor";
import iconv from 'iconv-lite';
import { parseCommand } from "./grammar";
import chalk from 'chalk';
import fs from 'fs';
import path from "path";

const PackageInfo = require('../package.json') as any;

export default class Terd {

  private inputBuffer: number[] = [];

  private executor = new CommandExecutor(
    this.onData.bind(this),
    this.onError.bind(this));

  private dataListeners: OutputListener[] = [];

  private errorListeners: OutputListener[] = [];

  constructor(private readonly opt?: TerdOpt) {
  }

  public write(input: string) {
    for (const c of input) {
      this.process(c, c.charCodeAt(0));
    }
  }

  public on(event: 'data' | 'error', listener: OutputListener) {
    if (event === 'data') {
      this.dataListeners.push(listener);
    } else {
      this.errorListeners.push(listener);
    }
  }

  public close(force?: boolean) {
    this.executor.close(force);
  }

  protected onData(chunk: Buffer | string) {
    this.dataListeners.forEach(listener => listener(chunk));
  }

  protected onError(chunk: Buffer | string) {
    this.errorListeners.forEach(listener => listener(chunk));
  }

  protected banner() {
    if (this.opt?.printBanner) {
      let lines = fs.readFileSync(path.resolve(__dirname, 'banner.txt')).toString().split('\r\n')
      .map((line) => chalk.greenBright(line))
      // lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
      lines[lines.length - 4] += chalk.redBright('v' + PackageInfo.version)
      lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
      lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
      this.onData(lines.join('\r\n') + '\r\n');
    }
  }

  protected prompt() {
    if (this.opt?.printPrompt) {
      const str = chalk.cyan(this.executor.cwd) + (this.executor.lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
      this.onData(str);
    }
  }

  protected exit() {
    this.close();
    process.exit(0);
  }

  protected hasInput() {
    return this.inputBuffer.length > 0;
  }

  protected clearBuffer() {
    this.inputBuffer = [];
  }

  protected process(ch: string, code: number) {
    // console.log(ch, code);
    switch (code) {
      case 13: // \r
      case 10: // \n
        if (this.hasInput()) {
          const cmd = this.parseInput();
          this.executor.execute(cmd).then(() => {
            this.prompt();
          });
        } else {
          this.prompt();
        }
        break;
      default:
        this.inputBuffer.push(code);
    }
  }

  private parseInput() {
    const input = iconv.decode(Buffer.from(this.inputBuffer), 'gbk');
    const cmd = parseCommand(input);
    this.inputBuffer = [];
    return cmd;
  }
}
