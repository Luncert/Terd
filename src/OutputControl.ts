import { CSI } from "./ASCII";
import InputBuffer from "./InputBuffer";
import chalk from 'chalk';
import fs from 'fs';
import path from "path";

const PackageInfo = require('../package.json') as any;

export default abstract class OutputControl {

  protected readonly inputBuffer = new InputBuffer(this.print.bind(this));

  constructor(
    private readonly printBanner?: boolean,
    private readonly printPrompt?: boolean) {
  }

  protected abstract cwd(): string;

  protected abstract print(s: number | string | Buffer): void;

  protected banner() {
    if (this.printBanner) {
      let lines = fs.readFileSync(path.resolve(__dirname, 'banner.txt')).toString().split('\r\n')
      .map((line) => chalk.greenBright(line))
      // lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
      lines[lines.length - 4] += chalk.redBright('v' + PackageInfo.version)
      lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
      lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
      this.print(lines.join('\r\n') + '\r\n');
    }
  }

  protected prompt(lastExecSucceed?: boolean) {
    if (this.printPrompt) {
      const str = chalk.cyan(this.cwd()) + (lastExecSucceed ? chalk.greenBright('>') : chalk.red('>'))
      this.print(str);
    }
  }

  protected backspace() {
    if (this.inputBuffer.pop() !== undefined) {
      this.print(`${CSI.CUB(1)}${CSI.DCH(1)}`);
    }
  }
}
