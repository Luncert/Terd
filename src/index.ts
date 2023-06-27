import TerdTerminal from "./TerdTerminal";

const terd = new TerdTerminal({ printBanner: true, printPrompt: true });
terd.on('data', (data) => process.stdout.write(data));
terd.run();