import process from 'process';
import chalk from 'chalk';
import fs from 'fs';
import path from 'path';

const PackageInfo = require('../package.json');

type DataHandler = (data: Uint8Array | string) => void

class Terd {

    private cwd: string
    private lastSucceed: boolean = true
    private writeOutput: DataHandler

    public getPrompt(): string {
        let cwd = process.cwd().replace(/\\/g, '/')
        return chalk.cyan(cwd) + (this.lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
    }

    /**
     * bind DataHandler to consume terminal outputs
     * @param handler DataHandler
     */
    public onData(handler: DataHandler) {
        this.writeOutput = handler
    }

    public init() {
        this.writeOutput(this.getPrompt())
    }

    /**
     * submit script to Terd to process
     * @param script string
     */
    public process(script: Buffer) {
        this.lastSucceed = !this.lastSucceed
        this.writeOutput(this.getPrompt())
    }
}

export class UserInterface {

    private terd: Terd

    constructor() {
        this.terd = new Terd()
        process.stdin.setEncoding('utf8')
    }

    start() {
        // output banner
        this.write(this.loadBanner())

        // watch output
        this.terd.onData(this.write.bind(this))

        // watch input
        process.stdin.on('data', (data) => this.terd.process(data))
        
        // capture SIGINT
        process.on('SIGINT', () => {
            this.write('\r\n')
            process.exit()
        })

        this.terd.init()
    }

    loadBanner() {
        let lines = fs.readFileSync(path.resolve(__dirname, 'banner.txt')).toString().split('\r\n')
            .map((line) => chalk.greenBright(line))
        lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
        lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
        lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
        return lines.join('\r\n') + '\r\n'
    }

    write(buffer: Uint8Array | string, cb?: (err?: Error) => void): boolean {
        return process.stdout.write(buffer, cb)
    }
}
