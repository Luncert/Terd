
export default class ForwardWritable implements NodeJS.WritableStream {

  readonly writable: boolean = true;

  constructor(private readonly forward: (data: Buffer) => void) {
  }

  write(buffer: string | Uint8Array, cb?: (err?: Error) => void): boolean;
  write(str: string, encoding?: string, cb?: (err?: Error) => void): boolean;
  write(str: unknown, encoding?: unknown, cb?: unknown): boolean {
    if (str instanceof Uint8Array) {
      this.forward(Buffer.from(str));
    } else {
      this.forward(Buffer.from(str as string));
    }
    return true;
  }

  end(cb?: () => void): void;
  end(data: string | Uint8Array, cb?: () => void): void;
  end(str: string, encoding?: string, cb?: () => void): void;
  end(str?: unknown, encoding?: unknown, cb?: unknown): void {
    // TBD
  }
  
  addListener(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  on(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  once(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  removeListener(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  off(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  removeAllListeners(event?: string | symbol): this {
    throw new Error("Method not implemented.");
  }
  setMaxListeners(n: number): this {
    throw new Error("Method not implemented.");
  }
  getMaxListeners(): number {
    throw new Error("Method not implemented.");
  }
  listeners(event: string | symbol): Function[] {
    throw new Error("Method not implemented.");
  }
  rawListeners(event: string | symbol): Function[] {
    throw new Error("Method not implemented.");
  }
  emit(event: string | symbol, ...args: any[]): boolean {
    throw new Error("Method not implemented.");
  }
  listenerCount(type: string | symbol): number {
    throw new Error("Method not implemented.");
  }
  prependListener(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  prependOnceListener(event: string | symbol, listener: (...args: any[]) => void): this {
    throw new Error("Method not implemented.");
  }
  eventNames(): (string | symbol)[] {
    throw new Error("Method not implemented.");
  }

}