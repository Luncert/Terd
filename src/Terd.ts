import process from 'process';
import chalk from 'chalk';
import fs from 'fs';
import path from 'path';

const PackageInfo = require('../package.json');

type DataHandler = (data: Uint8Array) => void

class Terd {

    private cwd: string

    /**
     * bind DataHandler to consume terminal outputs
     * @param handler DataHandler
     */
    onData(handler: DataHandler) {

    }

    /**
     * submit script to Terd to process
     * @param script string
     */
    process(script: string) {

    }
}

export class UserInterface {

    constructor() {
        process.stdin.setEncoding('utf8')
    }

    start() {
        process.stdin.on('data', (data) => {
            this.write(this.getPrompt())
        })
        
        process.on('SIGINT', () => {
            this.write('\x1b[0m\r\n')
            process.exit()
        })

        this.write(this.loadBanner())
        this.write('\r\n')
        this.write(this.getPrompt(true))
    }

    loadBanner() {
        let lines = fs.readFileSync(path.resolve(__dirname, 'banner.txt')).toString().split('\r\n')
            .map((line) => chalk.greenBright(line))
        lines[lines.length - 4] += chalk.redBright(PackageInfo.version)
        lines[lines.length - 3] += chalk.blueBright('by ' + PackageInfo.author)
        lines[lines.length - 2] += chalk.whiteBright(chalk.underline(PackageInfo.homepage))
        return lines.join('\r\n')
    }

    getPrompt(lastSucceed?: boolean) {
        let cwd = process.cwd()
        let i = cwd.indexOf(':')
        let disk = cwd.substring(0, i + 1)
        let workPath = cwd.substring(i +  1).replace(/\\/g, '/')
        return chalk.bgBlueBright(disk) + chalk.cyan(workPath) +
            (lastSucceed ? chalk.greenBright('>') : chalk.red('>'))
    }

    write(buffer: Uint8Array | string, cb?: (err?: Error) => void): boolean {
        return process.stdout.write(buffer)
    }
}
