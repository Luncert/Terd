import InputBuffer from "./InputBuffer";
import chalk from 'chalk';
import fs from 'fs';
import path from "path";
import InputHistory from "./InputHistory";

const PackageInfo = require('../package.json') as any;

export default abstract class OutputControl {

  protected readonly inputBuffer = new InputBuffer(this.print.bind(this));
  protected readonly histories = new InputHistory();
  private prevAutoComplete = '';

  constructor(
    private readonly printBanner?: boolean,
    private readonly printPrompt?: boolean) {
  }

  protected abstract pwd(): string;
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
      // https://www.w3.org/TR/xml-entity-names/025.html
      const colored = lastExecFailed ? chalk.red : chalk.greenBright;
      // const bgColored = lastExecFailed ? chalk.bgRed : chalk.bgGreenBright;
      const str = colored('\u25B6 ') + chalk.cyan(this.pwd()) + ' ';
      this.print(str);
    }
  }

  protected backspace() {
    this.inputBuffer.pop();
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

  protected autoComplete(): boolean {
    if (this.inputBuffer.getTextCursor() == 0) {
      return false;
    }


    const input = this.inputBuffer.getLastWord();
    const candidates = this.searchCommand(input);
    let hint = this.prevAutoComplete;
    for (const c of candidates) {
      if (c !== this.prevAutoComplete) {
        hint = c;
        break;
      }
    }

    hint = hint.replace(input, '');

    if (hint === this.inputBuffer.getHint()) {
      this.inputBuffer.push(Buffer.from(hint));
    } else {
      this.inputBuffer.setHint(hint);
    }

    return true;
  }

  protected abstract searchCommand(input: string): string[];
}
