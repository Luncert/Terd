import { IDisposable } from "node-pty";
import { Command } from "./grammar";
import CommandContext from "./builtin/CommandContext";

export interface ICommandExecutor {

  before(event: 'execute', listener: any): IDisposable;

  on(event: 'data', listener: any): IDisposable;

  after(event: 'execute', listener: any): IDisposable;

  execute(cmd: Command): Promise<number>;

  close(force?: boolean): void;
}

export type BeforeExecuteListener = () => void;

export type AfterExecuteListener = (e: { exitCode: number, signal?: number }) => void;

export type Consumer<T> = (e: T) => void;

export interface Output {

  write(s: string): void;

  writeln(s: string): void;
}

export type OutputListener = (chunk: Buffer | string) => void;

export interface TerdOpt {
  printPrompt?: boolean;
  printBanner?: boolean;
  disableExit?: boolean;
}

export interface BuiltinCommand {
  name(): string;
  usage(): string;
  process(ctx: CommandContext, args: string[]): void;
}

export type Callback<R> = () => R | void;

export type Printer = (s: number | string | Buffer) => void;
