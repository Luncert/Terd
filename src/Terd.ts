import process from 'process';

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
            this.write(data)
            this.write(this.prompt)
        })
        process.on('SIGINT', () => {
            this.write('\x1b[0m\r\n')
            process.exit()
        })
        this.write(this.prompt)
    }

    get prompt() {
        let cwd = process.cwd()
        let i = cwd.indexOf(':')
        let disk = cwd.substring(0, i)
        let workPath = cwd.substring(i +  1).replace(/\\/g, '/')
        return '\x1b[42m' +  disk + ' \x1b[44m' + workPath + '\x1b[40m\x1b[37m '
    }

    write(buffer: Uint8Array | string, cb?: (err?: Error) => void): boolean {
        return process.stdout.write(buffer)
    }
}
