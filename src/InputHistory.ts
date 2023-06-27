
// 3 | 2 | 1 | 0 | 1 | 2
// 4 | 3 | 2 | 1 | 2 | 3
export default class InputHistory {

  private set = new Set<string>();
  private histories: string[] = [];
  private _current: string | undefined;
  private pCursor = 0;
  private nCursor = 1;

  public resetCursors() {
    this.pCursor = this.histories.length;
    this.nCursor = this.histories.length + 1;
  }

  public push(s: string) {
    if (!s) {
      return;
    }
    if (this.set.has(s)) {
      const i = this.histories.indexOf(s);
      this.histories.splice(i, 1);
      this.histories.push(s);
      this.resetCursors();
      return;
    }
    this.set.add(s);
    this.histories.push(s);
    this.resetCursors();
  }

  public get current(): string | undefined {
    return this._current;
  }

  public get previous(): string | undefined {
    if (this.pCursor > 0) {
      this.nCursor--;
      this._current = this.histories[--this.pCursor];
      return this._current;
    }
  }

  public get next(): string {
    if (this.nCursor < this.histories.length) {
      this.pCursor++;
      this._current = this.histories[this.nCursor++];
    } else {
      if (this.pCursor < this.histories.length) {
        this.pCursor++;
        this.nCursor++;
      }
      this._current = '';
    }
    return this._current;
  }

  public clear() {
    this.histories = [];
    this.pCursor = 0;
    this.nCursor = 1;
  }
}