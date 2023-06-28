import CommandExecutor from "./CommandExecutor";
import { parseCommand } from "./grammar";
import chalk from 'chalk';
import fs from 'fs';
import path from "path";
import InputBuffer from "./InputBuffer";
import InputHistory from "./InputHistory";

const PackageInfo = require('../package.json') as any;

export default class Terd {

  protected readonly inputBuffer = new InputBuffer(this.onData.bind(this));

  protected readonly histories = new InputHistory();

  protected readonly executor = new CommandExecutor(
    this.onData.bind(this),
    this.onError.bind(this));

  private dataListeners: OutputListener[] = [];

  private errorListeners: OutputListener[] = [];

  constructor(private readonly opt?: TerdOpt) {
  }

  public write(input: string) {
    for (const c of input) {
      const code = c.charCodeAt(0);
      switch (code) {
        case 13: // \r
        case 10: // \n
          this.commit();
          break;
        default:
          this.inputBuffer.push(code);
      }
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
}
