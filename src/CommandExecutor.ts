import child_process from 'child_process';
import os from 'os';
import { Command } from './grammar';
import { AfterExecuteListener, BeforeExecuteListener, Consumer, ICommandExecutor } from './types';
import { IDisposable, IPty, spawn } from 'node-pty';
import { resolve } from 'path';
import CommandContext from './builtin/CommandContext';

abstract class BasicCommandExecutor implements ICommandExecutor {

  protected beforeExecuteListener: BeforeExecuteListener | undefined;
  protected dataListener: Consumer<string> | undefined;
  protected afterExecuteListener: AfterExecuteListener | undefined;

  constructor(protected readonly commandContext: CommandContext) {

  }

  abstract get executing(): boolean;

  before(event: 'execute', listener: BeforeExecuteListener): IDisposable {
    this.beforeExecuteListener = listener;
    return { dispose: () => this.beforeExecuteListener = undefined };
  }

  on(event: 'data', listener: Consumer<string>): IDisposable {
    this.dataListener = listener;
    return { dispose: () => this.dataListener = undefined };
  }

  after(event: 'execute', listener: AfterExecuteListener): IDisposable {
    this.afterExecuteListener = listener;
    return { dispose: () => this.afterExecuteListener = undefined };
  }

  abstract write(s: string): void;
  abstract execute(cmd: Command): Promise<number>;
  abstract close(force?: boolean | undefined): void;
}

export class ChildProcessCommandExecutor extends BasicCommandExecutor {

  get executing(): boolean {
    throw new Error('Method not implemented.');
  }

  private processes: Map<number, child_process.ChildProcessWithoutNullStreams>
    = new Map();

  constructor(
    private readonly stdin: NodeJS.ReadStream,
    private readonly stdout: NodeJS.WriteStream,
    private readonly stderr: NodeJS.WriteStream,
    commandContext: CommandContext) {
    super(commandContext);
  }

  write(s: string): void {
    throw new Error('Method not implemented.');
  }

  execute(cmd: Command): Promise<number> {
    return new Promise((resolve, reject) => {
      this.beforeExecuteListener && this.beforeExecuteListener();

      const proc = child_process.spawn(cmd.exec, cmd.args, {
        cwd: this.commandContext.pwd,
        stdio: 'pipe', // can't use stream directly, stream will be closed by proc
        shell: false
      });
      this.processes.set(proc.pid || 0, proc);

      this.stdin.pipe(proc.stdin);
      proc.on('exit', (code, signal: any) => {
        this.afterExecuteListener && this.afterExecuteListener({exitCode: code || 0, signal});
        this.processes.delete(proc.pid || 0);
        resolve(code || 0);
      });
    });
  }

  public async close(force?: boolean) {
    if (!force) {
      for (const [pid, proc] of this.processes) {
        const t = setInterval(() => {
          if (!proc.connected) {
            clearInterval(t);
          }
        }, 100)
      }
    }
    this.processes.forEach(p => p.kill());
    this.processes.clear();
  }
}

export class PtyCommandExecutor extends BasicCommandExecutor {

  private layout = {cols: process.stdout.columns, rows: process.stdout.rows};
  private procs: IPty[] = [];

  get executing(): boolean {
    return this.procs.length > 0;
  }

  write(s: string): void {
    if (this.procs.length > 0) {
      this.procs[this.procs.length - 1].write(s);
    }
  }

  execute(cmd: Command): Promise<number> {
    return new Promise((resolve) => {
      this.beforeExecuteListener && this.beforeExecuteListener();

      const proc = spawn(cmd.exec, cmd.args, {
        name: cmd.raw,
        cols: this.layout.cols,
        rows: this.layout.rows,
        cwd: this.commandContext.pwd,
        env: process.env
      });

      if (this.dataListener) {
        proc.onData(this.dataListener);
      }

      proc.onExit((e) => {
        this.deleteProcInfo(proc.pid);
        this.afterExecuteListener && this.afterExecuteListener(e);
        resolve(e.exitCode);
      });

      this.procs.push(proc);
    });
  }

  killExecution() {
    if (this.procs.length > 0) {
      this.procs[this.procs.length - 1].kill('SIGINT');
    }
  }

  private deleteProcInfo(pid: number) {
    for (let i = 0; i < this.procs.length; i++) {
      if (this.procs[i].pid === pid) {
        this.procs.splice(i, 1);
        break;
      }
    }
  }

  resize(cols: number, rows: number) {
    this.layout.cols = cols;
    this.layout.rows = rows;
    this.procs.forEach(proc => proc.resize(cols, rows));
  }

  close(force?: boolean): void {
    if (!force) {
      const t = setInterval(() => {
        if (this.procs.length == 0) {
          clearInterval(t);
        }
      }, 100)
    }
    this.procs.forEach(p => p.kill());
    this.procs = [];
  }
}
