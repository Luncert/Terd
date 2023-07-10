import { CSI, TextStyles } from "./ASCII";
import InputBuffer from "./InputBuffer";
import chalk from 'chalk';
import fs from 'fs';
import path from "path";
import InputHistory from "./InputHistory";

const PackageInfo = require('../package.json') as any;

export default abstract class OutputControl {

  protected readonly inputBuffer = new InputBuffer(this.print.bind(this));
  protected readonly histories = new InputHistory();

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

  protected prompt(lastExecFailed?: boolean) {
    if (this.printPrompt) {
      const colored = lastExecFailed ? chalk.red : chalk.greenBright;
      const bgColored = lastExecFailed ? chalk.bgRed : chalk.bgGreenBright;
      if (lastExecFailed) {

      }
      const str = chalk.cyan(this.cwd()) + colored(' \u25A0 ')
      this.print(str);
    }
  }

  protected backspace() {
    if (this.inputBuffer.pop() !== undefined) {
      this.print(`${CSI.CUB(1)}${CSI.DCH(1)}`);
    }
  }

  protected delete() {
    if (this.inputBuffer.moveCursor(1)) {
      this.inputBuffer.pop();
    }
  }

  protected showPrevInput() {
    if (!this.inputBuffer.hasInput() || this.inputBuffer.toString() === this.histories.current) {
      const history = this.histories.previous;
      if (history !== undefined) {
        this.inputBuffer.replace(history);
      }
    }
  }

  protected showNextInput() {
    if (!this.inputBuffer.hasInput() || this.inputBuffer.toString() === this.histories.current) {
      const history = this.histories.next;
      this.inputBuffer.replace(history);
    }
  }

  protected clearInput() {
    this.inputBuffer.clear();
    this.histories.resetCursors();
  }
}
