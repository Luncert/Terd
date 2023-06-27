import child_process from 'child_process';
import { Command } from './grammar';
import { Writable } from 'stream';

export default class CommandExecutor {

  private processes: Map<number, child_process.ChildProcessWithoutNullStreams> = new Map();

  private _cwd: string;

  private _lastSucceed: boolean = true;

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

  public execute(cmd: Command): Promise<number> {
    return new Promise((resolve, reject) => {
      const stdout = new Writable();
      const stderr = new Writable();
      stdout._write = (data) => this.onData(data);
      stderr._write = (data) => this.onError(data);
  
      const proc = child_process.spawn(cmd.executable, cmd.args, {
        cwd: this.cwd,
        windowsHide: true,
        stdio: [null, 'pipe', 'pipe'],
      });
      proc.stdout.pipe(stdout);
      proc.stderr.pipe(stderr);
  
      this.processes.set(proc.pid, proc);
      proc.on('exit', (code, signal) => {
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