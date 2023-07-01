import child_process from 'child_process';
import { Command } from './grammar';

export default class CommandExecutor {

  private processes: Map<number, child_process.ChildProcessWithoutNullStreams> = new Map();

  private _cwd: string;

  private _lastSucceed: boolean = true;

  private beforeExecuteListener: () => void;

  private afterExecuteListener: () => void;

  constructor(
    private readonly stdin: NodeJS.ReadStream,
    private readonly stdout: NodeJS.WriteStream,
    private readonly stderr: NodeJS.WriteStream) {
    this._cwd = process.cwd().replace(/\\/g, '/');
  }

  public get cwd() {
    return this._cwd;
  }

  public get lastSucceed() {
    return this._lastSucceed;
  }
  
  public beforeExecute(beforeExecuteListener: () => void) {
    this.beforeExecuteListener = beforeExecuteListener;
  }

  public afterExecute(afterExecuteListener: () => void) {
    this.afterExecuteListener = afterExecuteListener;
  }

  public execute(cmd: Command): Promise<number> {
    return new Promise((resolve, reject) => {
      this.beforeExecuteListener && this.beforeExecuteListener();

      const proc = child_process.spawn(cmd.executable, cmd.args, {
        cwd: this.cwd,
        stdio: 'pipe', // can't use stream directly, stream will be closed by proc
        shell: false
      });
      this.processes.set(proc.pid, proc);

      this.stdin.pipe(proc.stdin);
      proc.on('exit', (code, signal) => {
        this.afterExecuteListener && this.afterExecuteListener();
        this.processes.delete(proc.pid);
        resolve(code);
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