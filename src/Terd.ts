import process from 'process';
import child_process from 'child_process';
import iconv from 'iconv-lite';
import chalk from 'chalk';
import fs from 'fs';
import path from 'path';

const PackageInfo = require('../package.json');

type DataHandler = (data: Uint8Array | string) => void
type CloseListener = () => void

const TERD_MARKER = 'TERD#MARKER'

class Terd {

    private cwd: string
    private lastSucceed: boolean = true
    private writeOutput: DataHandler
    private proc: child_process.ChildProcessWithoutNullStreams

    constructor(output: DataHandler, onClose?: CloseListener) {
        if (!output) {
            throw new Error('output cannot be null.');
        }
        this.writeOutput = output

        this.cwd = process.cwd().replace(/\\/g, '/')
        this.proc = child_process.spawn('powershell -NoLogo -Command -', { shell: true })
        this.proc.stdout.on('data', this.processOutput.bind(this))
        this.proc.on('close', () => onClose && onClose())

        process.on('SIGINT', () => this.kill())

        this.writeOutput(Buffer.from(this.getPrompt()))
    }

    public getPrompt(): number[] {
        let str = chalk.cyan(this.cwd) + (this.lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
        return str.split('').map((c) => c.charCodeAt(0))
    }

    /**
     * submit script to Terd to process
     * @param script string
     */
    public process(script: Buffer) {
        this.proc.stdin.write(script)
        this.proc.stdin.write(';echo ' + TERD_MARKER + '${pwd};\r\n')
    }

    private processOutput(raw: Buffer) {
        let data = new Array<number>(...raw)
        let markStart = -1
        for (let i = 0; i < data.length; i++) {
            let c = data[i]
            if (c == TERD_MARKER.charCodeAt(0)) {
                markStart = i
            } else if (markStart > -1) {
                let cursor = i - markStart
                if (cursor == TERD_MARKER.length) {
                    for (let j = i; j < data.length; j++) {
                        if (data[j] == 13) { // '\n'
                            this.cwd = String.fromCharCode(...data.slice(i, j)).replace(/\\/g, '/') // j - 1 = '\r'
                            let prompt = this.getPrompt()
                            i += prompt.length
                            data.splice(markStart, j + 2 - markStart, ...prompt) // 2 = '\r\n', which has already been included by promt
                            // console.log('<', data.length, 0, j - markStart, String.fromCharCode(...data))
                        }
                    }
                    markStart = -1
                } else if (c != TERD_MARKER.charCodeAt(cursor)) {
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

export class UserInterface {

    private terd: Terd

    start() {
        // output banner
        this.write(this.loadBanner())

        this.terd = new Terd(this.write.bind(this),
            () => {
                this.write('\r\n')
                process.exit()
            })
        process.stdin.setEncoding('utf8')
        process.stdout.setEncoding('utf8')

        // watch input
        process.stdin.on('data', (data) => this.terd.process(data))
    }

    loadBanner() {
        let lines = fs.readFileSync(path.resolve(__dirname, 'banner.txt')).toString().split('\r\n')
            .map((line) => chalk.greenBright(line))
        // lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
        lines[lines.length - 4] += chalk.redBright('v' + PackageInfo.version)
        lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
        lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
        return lines.join('\r\n') + '\r\n'
    }

    write(buffer: Uint8Array | string, cb?: (err?: Error) => void): boolean {
        return process.stdout.write(buffer, cb)
    }
}
