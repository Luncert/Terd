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
            console.log(data)
        })
        process.on('SIGINT', () => {
            this.write('\r\nExit')
            process.exit()
        })
        this.write('Terd>')
    }

    write(buffer: Uint8Array | string, cb?: (err?: Error) => void): boolean {
        return process.stdout.write(buffer)
    }
}
