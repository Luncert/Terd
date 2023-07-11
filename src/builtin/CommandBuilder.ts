import { Command } from "../grammar";
import CommandContext from "./CommandContext";

interface OptionDef {
  key: string;
  short: string;
  long: string;
  description: string;
}

interface ArgumentDef {
  name: string;
}

function optionUsage(opt: OptionDef | ArgumentDef) {
  if ('name' in opt) {
    return `[${opt.name}]`;
  }

  let s = '';
  if (opt.short) {
    s += '-' + opt.short + ' ';
  }
  if (opt.long) {
    s += '--' + opt.long + ' ';
  }
  if (opt.description) {
    s += opt.description;
  }
  return s;
}

type CommandArg = OptionDef | ArgumentDef;
export type CommandAction = (ctx: CommandContext, cmd: Command) => number;

export class CommandDef {
  constructor(
    readonly name: string,
    readonly description: string,
    readonly options: CommandArg[],
    readonly action: CommandAction) {

  }

  get usage(): string {
    if (this.options.length > 1) {
      return `${this.name} \u2501 ${this.description}\n`
        + this.options.map(opt => `  ${optionUsage}`).join('\n');
    } else if (this.options.length > 0) {
      return `${this.name} ${this.options.map(optionUsage)} \u2501 ${this.description}`
    } else {
      return `${this.name} \u2501 ${this.description}`;
    }
  }
}

export function argument(name: string): ArgumentDef {
  return { name };
}

export function option(key: string, short: string, long?: string, description?: string) {
  return { key, short, long, description };
}
