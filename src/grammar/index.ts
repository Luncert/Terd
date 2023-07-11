import { CharStreams, CommonTokenStream } from "antlr4ts";
import { TerdLexer } from "./TerdLexer";
import { ArgumentContext, ArgumentsContext, CommandContext, ExecutableContext, OptionContext, TerdParser } from "./TerdParser";
import { TerdListener } from "./TerdListener";
import { ParseTreeWalker } from 'antlr4ts/tree/ParseTreeWalker';
import { printTokens, removePrefix } from "../util";

export class Command {

  constructor(
    readonly raw: string,
    readonly exec: string,
    readonly argsString: string,
    readonly args: string[],
  ) {
  }

  getOptions() {
    return new Options(this.args);
  }
}

export class Options {

  private options = new Map<string, string | boolean>();

  constructor(args: string[]) {
    // let i = 0;
    // let name;
    // while (i < args.length) {
    //   if (args[i].startsWith('-')) {
    //     if (name) {
    //       this.options.set(name, true);
    //     }
    //     name = removePrefix('-', args[i]);
    //   } else if (name) {

    //   }
    //   i++;
    // }

  }

  get<T>(key: string): T {
    return this.options.get(key) as T;
  }
}

class TerdListerenerImpl implements TerdListener {

  private _exec: string = '';
  private _argsString: string = '';
  private _args: string[] = [];

  public get exec() {
    return this._exec;
  }

  public get argsString() {
    return this._argsString;
  }

  public get args() {
    return this._args;
  }

  enterExecutable(ctx: ExecutableContext) {
    this._exec = ctx.text;
  }

  enterArguments(ctx: ArgumentsContext) {
    this._argsString = ctx.text;
  }

  enterArgument(ctx: ArgumentContext) {
    this._args.push(ctx.text);
  }
}

export function parseCommand(source: string): Command {
  const charStream = CharStreams.fromString(source.replace('\\\n', ''));
  const lexer = new TerdLexer(charStream);
  const tokenStream = new CommonTokenStream(lexer);
  const parser = new TerdParser(tokenStream);
  const listener = new TerdListerenerImpl();
  ParseTreeWalker.DEFAULT.walk((listener as TerdListener), parser.command());
  return new Command(source, listener.exec, listener.argsString, listener.args);
}
