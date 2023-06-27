import iconv from 'iconv-lite';
import { CSI } from "./ASCII";

type Action = 'pack' | 'clear' | 'push' | 'pop' | 'moveCursor' | 'replace';

export default class InputBuffer {
  private buf: number[] = [];
  private cursor = 0; // start from 1
  insertMode = false;

  constructor(private readonly echoListener: (echo: string) => void) {
  }

  hasInput() {
    return this.buf.length > 0;
  }

  replace(s: string | Buffer) {
    this.recordChange('replace', () => {
      this.buf = new Array(s.length);
      let mapper;
      if (typeof(s) === 'string') {
        mapper = (elem: any) => elem.charCodeAt(0);
      } else {
        mapper = (elem: any) => elem;
      }
      for (let i = 0; i < s.length; i++) {
        this.buf[i] = mapper(s[i]);
      }
      this.cursor = this.buf.length;
    });
  }

  toString(start?: number, end?: number) {
    return iconv.decode(Buffer.from(this.buf.slice(start, end)), 'gbk');
  }

  pack() {
    this.recordChange('pack', () => {
      this.cursor = 0;
      this.buf = [];
    });
  }

  clear() {
    this.recordChange('clear', () => {
      this.cursor = 0;
      this.buf = [];
    });
  }

  push(c: number) {
    this.recordChange('push', () => {
      if (this.insertMode && this.cursor < this.buf.length) {
        this.buf[this.cursor] = c;
      } else {
        this.buf.splice(this.cursor, 0, c);
      }
      this.cursor++;
    });
  }

  pop() {
    this.recordChange('pop', () => {
      if (this.buf.length === 0 || this.cursor == 0) {
        return false;
      }
      this.buf.splice(this.cursor - 1, 1);
      this.cursor--;
    });
  }

  moveCursor(delta: number): boolean {
    return this.recordChange('moveCursor', () => {
      const newPos = this.cursor + delta;
      if (newPos < 0 || newPos > this.buf.length) {
        return false;
      }
      this.cursor = newPos;
      return true;
    });
  }

  private recordChange(action: Action, call: () => any) {
    const cursorBefore = this.cursor;
    const bufLenBefore = this.buf.length;

    const r = call();

    let echo: string;
    switch (action) {
      case 'pack':
        echo = `${CSI.CUF(bufLenBefore - cursorBefore)}\n`;
        break;
      case 'clear':
        echo = `${CSI.CUB(cursorBefore)}${CSI.DCH(bufLenBefore)}`;
        break;
      case 'push':
        if (this.insertMode) {
          const text = String.fromCharCode(this.buf[cursorBefore]);
          echo = `${text}`;
        } else {
          const text = this.toString(cursorBefore, this.buf.length);
          echo = `${CSI.DCH(bufLenBefore - cursorBefore)}${text}${CSI.CUB(this.buf.length - this.cursor)}`
        }
        break;
      case 'pop':
        if (this.buf.length < bufLenBefore) {
          const text = this.toString(this.cursor, this.buf.length);
          echo = `${CSI.CUB(1)}${CSI.DCH(bufLenBefore - this.cursor)}${text}${CSI.CUB(text.length)}`
        }
        break;
      case 'moveCursor':
        if (r) {
          echo = this.cursor > cursorBefore ? CSI.CUF(this.cursor - cursorBefore) : CSI.CUB(cursorBefore - this.cursor);
        }
        break;
      case 'replace':
        const text = this.toString();
        echo = `${CSI.CUB(cursorBefore)}${CSI.DCH(bufLenBefore)}${text}`;
        break;
    }
    
    if (echo) {
      this.echoListener(echo);
    }

    return r;
  }
}