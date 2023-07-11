import Env from "../Env";
import { Output } from "../types";

export default class CommandContext implements Output {

  public pwd: string;
  public readonly env: Env;

  print(s: string): void {
    process.stdout.write(s);
  }

  println(s: string): void {
    process.stdout.write(s);
    process.stdout.write('\n');
  }
}
