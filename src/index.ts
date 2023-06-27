import TerdTerminal from "./TerdTerminal";

const terd = new TerdTerminal({ printBanner: true, printPrompt: true });
terd.on('data', (data) => process.stdout.write(data));
terd.on('error', (data) => process.stderr.write(data));
terd.run();