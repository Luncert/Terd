import iconv from 'iconv-lite';
import { CSI } from "./ASCII";
import { Printer } from './types';
import chalk from 'chalk';

type Action = 'pack' | 'clear';

function isWhitespace(c: number): boolean {
  return c == 9 // '\t'
    || c == 32 // ' '
  ;
}

function rerender() {
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    target.rerendering = true;
  };
}

function bufferToString(buf: number[], start: number = 0, end: number = buf.length) {
  return iconv.decode(Buffer.from(buf.slice(start, end)), 'utf8')
}

export default class InputBuffer {
  private buf: number[] = [];
  private hint: number[] = [];
  private text: number[] = [];
  private textChanges: { pos: number; deleted: number; added: number[]; }
  private textCursor = 0;
  // start from 1
  private cursor = 0;
  private removeHint = false;
  insertMode = false;

  constructor(private readonly printer: Printer) {
    this.intercept();
  }

  private intercept() {
    Object.getOwnPropertyNames(Object.getPrototypeOf(this))
      .map(name => [name, this[name]])
      .forEach(([name, func]) => {
        if (func['rerendering']) {
          this[name] = (...args: any[]) => {
            func.apply(this, args)
            this.render(name);
          };
        }
      });
  }

  toString(start: number = 0, end?: number) {
    return bufferToString(this.buf, start, end);
  }

  getTextCursor() {
    return this.textCursor;
  }

  getLastWord() {
    if (isWhitespace(this.buf[this.buf.length - 1])) {
      return '';
    }

    let i = this.buf.length - 1;
    for (; i >= 0 && !isWhitespace(this.buf[i]); i--) {
    }

    return this.toString(i + 1);
  }

  hasInput() {
    return this.buf.length > 0;
  }

  getHint() {
    return bufferToString(this.hint);
  }

  @rerender()
  setHint(s: string) {
    this.hint = [];
    for (let i = 0; i < s.length; i++) {
      this.hint.push(s.charCodeAt(i));
    }
  }

  @rerender()
  replace(s: string | Buffer) {
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
    this.replaceText(this.buf);
  }

  @rerender()
  pack() {
    if (this.hint.length > 0) {
      this.spliceText(0, ...this.hint);
    }
    this.cursor = 0;
    this.buf = [];
  }

  @rerender()
  clear() {
    this.cursor = 0;
    this.buf = [];
    this.replaceText(this.buf);
  }

  @rerender()
  push(c: number | Buffer) {
    const insert = this.insertMode && this.cursor < this.buf.length;
    if (c instanceof Buffer) {
      this.pushBuffer(c, insert);
    } else {
      this.pushCode(c, insert);
    }
  }

  private pushCode(c: number, insert: boolean) {
    if (insert) {
      this.spliceText(1, c);
      this.buf[this.cursor] = c;
    } else {
      this.spliceText(0, c);
      this.buf.splice(this.cursor, 0, c);
      this.cursor++;
    }
  }

  private pushBuffer(c: Buffer, insert: boolean) {
    if (insert) {
      this.spliceText(c.length, ...c);
      this.buf.splice(this.cursor, c.length, ...c);
      this.cursor = this.cursor + c.length - this.buf.length;
    } else {
      this.spliceText(0, ...c);
      this.buf.splice(this.cursor, 0, ...c);
      this.cursor += c.length;
    }
  }

  @rerender()
  pop() {
    if (this.buf.length === 0 || this.cursor === 0) {
      return false;
    }

    this.cursor--;
    this.spliceText(1);
    this.buf.splice(this.cursor, 1)[0];
  }

  @rerender()
  moveCursor(delta: number): boolean {
    if (delta == 0) {
      return true;
    }

    const newPos = this.cursor + delta;
    if (newPos < 0 || newPos > this.buf.length) {
      return false;
    }

    this.cursor = newPos;
    return true;
  }

  private render(action: Action) {
    const expectedTextCursor = this.calcCursorMove(this.buf, 0, this.cursor);

    if (this.textChanges) {
      const { pos, deleted, added } = this.textChanges;

      let cursorMove = pos - this.textCursor;
      this.moveTextCursor(cursorMove);
      this.textCursor = pos;

      if (deleted) {
        const colsAfterCursor = this.text.length - pos;
        this.printer(CSI.DCH(colsAfterCursor));
        if (deleted < colsAfterCursor) {
          this.printer(bufferToString(this.text, pos + deleted));
          this.textCursor += colsAfterCursor - deleted;
        }
      }

      this.text.splice(pos, deleted, ...added);

      if (added.length > 0) {
        if (pos < this.text.length) {
          this.printer(bufferToString(this.text, pos));
          this.textCursor += this.text.length - pos;
        } else {
          this.printer(bufferToString(this.text, pos, pos + added.length));
          this.textCursor += added.length;
        }
      }

      this.textChanges = undefined;
    }


    if (this.removeHint) {
      this.moveTextCursor(this.text.length - this.textCursor);
      this.printer(CSI.DCH(this.hint.length));
      this.textCursor = this.text.length;
      this.hint = [];
      this.removeHint = false;
    } else if (this.hint.length > 0) {
      this.moveTextCursor(this.text.length - this.textCursor);
      this.printer(chalk.gray(bufferToString(this.hint)));
      this.textCursor = this.text.length + this.hint.length;
      this.removeHint = true;
    }

    const cursorMove = expectedTextCursor - this.textCursor;
    if (cursorMove > 0) {
      this.printer(CSI.CUF(cursorMove));
    } else if (cursorMove < 0) {
      this.printer(CSI.CUB(-cursorMove));
    }

    this.textCursor = expectedTextCursor;

    if (action === 'pack') {
      this.printer('\n');
      this.text = [];
      this.textCursor = 0;
    } else if (action === 'clear') {
      this.text = [];
      this.textCursor = 0;
    }
  }

  private moveTextCursor(move: number) {
    if (move > 0) {
      this.printer(CSI.CUF(move));
    } else {
      this.printer(CSI.CUB(-move));
    }
  }

  private spliceText(deleteCount: number, ...items: number[]) {
    let textCursor = this.text.length;
    if (this.cursor < this.buf.length) {
      textCursor = this.calcCursorMove(this.buf, 0, this.cursor);
    }

    let textDeleteCount = 0;
    for (let i = 0; i < deleteCount; i++) {
      if (this.buf[i + this.cursor] == 9) {
        textDeleteCount += 4;
      } else {
        textDeleteCount += 1;
      }
    }

    const toAdd: number[] = [];
    items.forEach(code => {
      if (code === 9) {
        toAdd.push(32, 32, 32, 32);
      } else {
        toAdd.push(code);
      }
    });

    this.textChanges = {
      pos: textCursor,
      deleted: textDeleteCount,
      added: toAdd,
    };
  }

  private replaceText(buf: number[]) {
    this.textChanges = {
      pos: 0,
      deleted: this.text.length,
      added: buf,
    };
  }

  private calcCursorMove(buf: number[], start: number = 0, end: number = buf.length) {
    let total = 0;
    while (start < end) {
      if (buf[start] == 9) {
        total += 4;
      } else {
        total += 1;
      }
      start++;
    }
    return total;
  }
}
