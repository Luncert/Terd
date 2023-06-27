import { CharStreams, CommonTokenStream } from "antlr4ts";
import { TerdLexer } from "./TerdLexer";
import { ArgumentsContext, ExecutableContext, TerdParser } from "./TerdParser";
import { TerdListener } from "./TerdListener";
import { ParseTreeWalker } from 'antlr4ts/tree/ParseTreeWalker';
import { printTokens } from "../util";

export interface Command {
  executable: string;
  args: string[];
  rest?: string;
}

class TerdListerenerImpl implements TerdListener {

  command: Command;

  enterExecutable(ctx: ExecutableContext) {
    this.command = {
      executable: ctx.text,
      args: []
    };
  }

  enterArguments(ctx: ArgumentsContext) {
    this.command.args.push(ctx.text);
  }
}

export function parseCommand(source: string): Command {
  const charStream = CharStreams.fromString(source.replace('\\\n', ''));
  const lexer = new TerdLexer(charStream);
  const tokenStream = new CommonTokenStream(lexer);
  const parser = new TerdParser(tokenStream);
  const listener = new TerdListerenerImpl();
  ParseTreeWalker.DEFAULT.walk((listener as TerdListener), parser.command());
  return listener.command;
}
