import child_process from 'child_process';
import { Command } from './grammar';

export default class CommandExecutor {

  private processes: Map<number, child_process.ChildProcessWithoutNullStreams> = new Map();

  private _cwd: string;

  private _lastSucceed: boolean = true;

  private beforeExecuteListener: () => void;

  private afterExecuteListener: () => void;

  constructor(private readonly onData: OutputListener,
    private readonly onError: OutputListener) {
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

  public forward(data: Buffer) {
    for (const [pid, proc] of this.processes) {
      console.log(proc, data)
      proc.stdin.write(data);
    }
  }

  public execute(cmd: Command): Promise<number> {
    return new Promise((resolve, reject) => {
      this.beforeExecuteListener && this.beforeExecuteListener();

      const proc = child_process.spawn(cmd.executable, cmd.args, {
        cwd: this.cwd,
        stdio: 'pipe',
        shell: '/bin/zsh'
      });

      proc.stdout.on('data', (data) => this.onData(data));
      proc.stderr.on('data', (data) => this.onError(data));
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