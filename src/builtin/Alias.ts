import CommandContext from "../CommandContext";
import BuiltinCommandError, { InvalidUsageError } from "./Errors";

export class AliasCommand implements BuiltinCommand {

  name(): string {
    return 'alias';
  }

  usage(): string {
    return `alias [name[=value] ...]`
  }

  process(ctx: CommandContext, namedArgs: Map<string, string>, namelessArgs: string[]) {
    if (namedArgs.size > 0) {
      throw new InvalidUsageError();
    }

    for (const p of namelessArgs) {
      const [k, v] = this.parsePair(p);
      if (k) {
        ctx.env.createAlias(k, v);
      } else {
        throw new InvalidUsageError();
      }
    }
  }

  private parsePair(p: string) {
    const m = Array.from(p.matchAll(/^(?<k>[^=]+)(=(?<v>[^=]+))?$/g));
    if (m.length > 0) {
      return [m[0].groups.k, m[0].groups.v];
    }
    return [];
  }
}