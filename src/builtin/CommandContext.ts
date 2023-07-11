import Env from "../Env";
import { Output, Printer } from "../types";

export default class CommandContext implements Output {

  public pwd: string;
  public readonly env: Env;

  constructor(private printer: Printer) {
  }

  write(s: string): void {
    this.printer(s);
  }

  writeln(s: string): void {
    this.printer(s);
    this.printer('\n');
  }
}
