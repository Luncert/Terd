import { IDisposable } from "node-pty";
import { Command } from "./grammar";
import { CommandContext } from "./grammar/TerdParser";

export interface ICommandExecutor {

  get cwd(): string;

  before(event: 'execute', listener: any): IDisposable;

  on(event: 'data', listener: any): IDisposable;

  after(event: 'execute', listener: any): IDisposable;

  execute(cmd: Command): Promise<number>;

  close(force?: boolean): void;
}

export type BeforeExecuteListener = () => void;

export type AfterExecuteListener = (e: { exitCode: number, signal?: number }) => void;

export type Consumer<T> = (e: T) => void;

export type OutputListener = (chunk: Buffer | string) => void;

export interface TerdOpt {
  printPrompt?: boolean;
  printBanner?: boolean;
}

export interface BuiltinCommand {
  name(): string;
  usage(): string;
  process(ctx: CommandContext, namedArgs: Map<string, string>, namelessArgs: string[]): void;
}

export type Callback<R> = () => R | void;
