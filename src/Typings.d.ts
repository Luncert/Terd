
type OutputListener = (chunk: Buffer | string) => void;

interface TerdOpt {
  printPrompt?: boolean;
  printBanner?: boolean;
}