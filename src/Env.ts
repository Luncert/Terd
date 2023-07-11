
export default class Env {

  private envs: Map<string, string> = new Map();
  private alias: Map<string, Set<string>> = new Map();

  public createAlias(name: string, ref: string) {
    if (this.alias.has(name)) {
      this.alias.get(name).add(ref);
    } else {
      this.alias.set(name, new Set(ref));
    }
  }
}