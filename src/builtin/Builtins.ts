import path from "path";
import { Command } from "../grammar";
import  { CommandAction, CommandDef, argument, option } from "./CommandBuilder";
import CommandContext from "./CommandContext";
import { InvalidUsageError } from "./Errors";
import fs, { lstatSync } from 'fs';

const builtins = new Map<string, CommandDef>();

function add(name: string, description: string, ...options: any[]) {
  return ({
    action: (a: CommandAction) => builtins.set(name, new CommandDef(name, description, options, a)),
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
