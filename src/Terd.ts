import process from 'process';
import child_process from 'child_process';
import iconv from 'iconv-lite';
import chalk from 'chalk';

type DataHandler = (data: Uint8Array | string) => void
type CloseListener = () => void

const TERD_MARKER = '_TERD#MARKER_'
const ECHO_COMMAND = `echo ${TERD_MARKER}${ process.platform === 'win32' ? '${pwd}\r' : '$PWD'}\n`

export default class Terd {

  private cwd: string
  private lastSucceed: boolean = true
  private writeOutput: DataHandler
  private proc: child_process.ChildProcessWithoutNullStreams

  constructor(output: DataHandler, onClose ? : CloseListener) {
    if (!output) {
      throw new Error('output cannot be null.');
    }
    this.writeOutput = output

    this.cwd = process.cwd().replace(/\\/g, '/')
    this.proc = child_process.spawn('bash', {
      shell: true
    })
    this.proc.stderr.on('data', (data) => this.writeOutput(data))
    this.proc.stdout.on('data', this.processOutput.bind(this))
    this.proc.on('close', () => onClose && onClose())

    process.on('SIGINT', () => this.kill())

    this.writeOutput(Buffer.from(this.getPrompt()))
  }

  private getPrompt(): number[] {
    let str = chalk.cyan(this.cwd) + (this.lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
    return str.split('').map((c) => c.charCodeAt(0))
  }

  /**
   * submit input to Terd to process
   * @param input string
   */
  public write(input: Buffer | string) {
    this.proc.stdin.write(input)
    this.proc.stdin.write(ECHO_COMMAND)
  }

  // get cwd
  private processOutput(raw: Buffer) {
    let data = new Array < number > (...raw)
    let markStart = -1
    for (let i = 0; i < data.length; i++) {
      const c = data[i]
      if (markStart == -1) {
        if (c === TERD_MARKER.charCodeAt(0)) {
          markStart = i
        }
      } else {
        const cursor = i - markStart
        if (c !== TERD_MARKER.charCodeAt(cursor)) {
          if (cursor === TERD_MARKER.length) {
            // find cwd
            for (let j = i; j < data.length; j++) {
              // console.log(data[j])
              if (data[j] == 10) { // '\n'
                this.cwd = String.fromCharCode(...data.slice(i, j)).replace(/\\/g, '/') // j - 1 = '\r'
                let prompt = this.getPrompt()
                i += prompt.length
                data.splice(markStart, j + 2 - markStart, ...prompt) // 2 = '\r\n', which has already been included by promt
                // console.log('<', data.length, 0, j - markStart, String.fromCharCode(...data))
              }
            }
          }
          markStart = -1
        }
      }
    }
    this.writeOutput(iconv.decode(Buffer.from(data), 'gbk'))
  }

  public kill() {
    this.proc.kill()
  }
}