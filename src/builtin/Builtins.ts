import path from "path";
import { Command } from "../grammar";
import  { CommandAction, CommandDef, argument, option } from "./CommandBuilder";
import CommandContext from "./CommandContext";
import { InvalidUsageError } from "./Errors";
import fs from 'fs';
import NTreeNode from "../lib/NTree";

class CommandNode extends NTreeNode<number> {

  cmd: CommandDef;

  public match(key: number): boolean {
    return this.key == key;
  }
}

const builtins = new Map<string, CommandDef>();
const cmdSearchTree = new CommandNode(null);

function add(name: string, description: string, ...options: any[]) {
  return ({
    action: (a: CommandAction) => {
      const def = new CommandDef(name, description, options, a);
      builtins.set(name, def);

      let n = cmdSearchTree;
      for (let i = 0; i < name.length; i++) {
        const c = name.charCodeAt(i);
        let child = <CommandNode> n.matchChild(c);
        if (child == null) {
          for (let j = i; j < name.length; j++) {
            child = new CommandNode(name.charCodeAt(j));
            n.addChild(child);
            n = child;
          }
          n.cmd = def;
          break;
        }
        n = child;
      }
    },
  })
}

add('cd', 'Change current directory to the one specified by Argument parameter.', argument('path'))
  .action((ctx, cmd) => {
    if (cmd.args.length != 1) {
      throw new InvalidUsageError();
    }
    const newPwd = path.resolve(ctx.pwd, cmd.args[0]);
    if (fs.lstatSync(newPwd).isDirectory()) {
      ctx.pwd = newPwd;
      return 0;
    }
    ctx.println(`cannot access ${newPwd}`);
    return -1;
  });
add('echo', 'Writes character strings to standard output.')
  .action((ctx, cmd) => {
    ctx.println(cmd.argsString);
    return 0;
  });
add('pwd', 'Print pwd.')
  .action((ctx, cmd) => {
    ctx.println(ctx.pwd);
    return 0;
  })
// console.log(cmdSearchTree.toString());

export function searchCommand(input: string): string[] {
  function constructCmd(prev: string, n: CommandNode, result: string[]) {
    prev += String.fromCharCode(n.getKey());
    if (n.getChildrenNum() == 0) {
      result.push(prev);
    } else {
      for (const child of n.getChildren()) {
        constructCmd(prev, child as CommandNode, result);
      }
    }
    return result;
  }

  let n = cmdSearchTree;
  for (let i = 0; i < input.length; i++) {
    let child = <CommandNode> n.matchChild(input.charCodeAt(i));
    if (child == null) {
      return [];
    }
    n = child;
  }

  const result: string[] = [];
  for (const child of n.getChildren()) {
    constructCmd(input, child as CommandNode, result);
  }
  return result;
}

export default function executeBuiltinCommand(ctx: CommandContext, cmd: Command): Promise<number> {
  return new Promise((resolve, reject) => {
    const cmdDef = builtins.get(cmd.exec);
    if (!cmdDef) {
      reject(-2); // ENOENT
      return;
    }
    try {
      const exitCode = cmdDef.action(ctx, cmd);
      if (exitCode == 0) {
        resolve(exitCode);
      } else {
        reject(exitCode);
      }
    } catch (e) {
      if (e instanceof InvalidUsageError) {
        ctx.println('Invalid usage of command. Usages:')
        ctx.println(cmdDef.usage);
      } else {
        const err = e as any;
        if (err.message) {
          ctx.println(err.message);
        } else {
          ctx.println(err);
        }
      }
      reject(-1);
    }
  });
}
