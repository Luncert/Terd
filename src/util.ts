import { CharStreams, CommonToken, RuleContext, Token } from "antlr4ts";
import { Tree } from "antlr4ts/tree/Tree";

export function printTokens(tokens: Token[]) {
  for (const t of tokens) {
    console.log(t.type, ':', t.text);
  }
}

export function printParseTree(tree: Tree, ruleNames: string[]) {
  let indent = 0
  function process(t: Tree) {
    if (t.childCount === 0) {
      const token = t.payload as CommonToken;
      return `[${token.type}] '${token.text}'`
    }
    indent++;
    const rule = t.payload as RuleContext;
    let s = ruleNames[rule.ruleIndex] + `[${t.childCount}]` + ':\n' + ('  '.repeat(indent));
    for (let i = 0; i < t.childCount; i++) {
      s += process(t.getChild(i));
      if (i < t.childCount - 1) {
        s += '\n' + ('  '.repeat(indent));
      }
    }
    indent--;
    return s;
  }
  console.log(process(tree));
}

export function removePrefix(c: string, s: string): string {
  for (let i = 0; i < s.length; i++) {
    if (s !== c) {
      return s.substring(i + 1);
    }
  }
  return s;
}
