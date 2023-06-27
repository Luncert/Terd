
type OutputListener = (chunk: Buffer | string) => void;

type KeyHandler = () => void;

interface TerdOpt {
  printPrompt?: boolean;
  printBanner?: boolean;
}

interface BuiltinCommand {
  name(): string;
  usage(): string;
  process(ctx: CommandContext, namedArgs: Map<string, string>, namelessArgs: string[]): void;
}
