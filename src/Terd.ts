import process from 'process';
import child_process from 'child_process';
import iconv from 'iconv-lite';
import chalk from 'chalk';
import fs from 'fs';
import path from 'path';

const PackageInfo = require('../package.json');

type DataHandler = (data: Uint8Array | string) => void
type CloseListener = () => void

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

        this.proc = child_process.spawn('powershell', {
            argv0: '-Command -',
            shell: false,
        })
        this.proc.stdout.on('data', (data) => this.writeOutput(iconv.decode(data, 'gbk')))
        this.proc.on('close', () => onClose && onClose())

        process.on('SIGINT', () => this.kill())

        this.writeOutput(this.getPrompt())
    }

    public getPrompt(): string {
        let cwd = process.cwd().replace(/\\/g, '/')
        return chalk.cyan(cwd) + (this.lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
    }

    /**
     * submit script to Terd to process
     * @param script string
     */
    public process(script: Buffer) {
        this.proc.stdin.write(script)
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
        lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
        lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
        lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
        return lines.join('\r\n') + '\r\n'
    }

    write(buffer: Uint8Array | string, cb?: (err?: Error) => void): boolean {
        return process.stdout.write(buffer, cb)
    }
}
