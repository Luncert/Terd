// Generated from src/grammar/Terd.g4 by ANTLR 4.9.0-SNAPSHOT


import { ATN } from "antlr4ts/atn/ATN";
import { ATNDeserializer } from "antlr4ts/atn/ATNDeserializer";
import { CharStream } from "antlr4ts/CharStream";
import { Lexer } from "antlr4ts/Lexer";
import { LexerATNSimulator } from "antlr4ts/atn/LexerATNSimulator";
import { NotNull } from "antlr4ts/Decorators";
import { Override } from "antlr4ts/Decorators";
import { RuleContext } from "antlr4ts/RuleContext";
import { Vocabulary } from "antlr4ts/Vocabulary";
import { VocabularyImpl } from "antlr4ts/VocabularyImpl";

import * as Utils from "antlr4ts/misc/Utils";


export class TerdLexer extends Lexer {
	public static readonly T__0 = 1;
	public static readonly T__1 = 2;
	public static readonly PATTERN = 3;
	public static readonly STRING = 4;
	public static readonly QUOTED_STRING = 5;
	public static readonly DQUOTED_STRING = 6;
	public static readonly SPACES = 7;
	public static readonly WS = 8;

	// tslint:disable:no-trailing-whitespace
	public static readonly channelNames: string[] = [
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN",
	];

	// tslint:disable:no-trailing-whitespace
	public static readonly modeNames: string[] = [
		"DEFAULT_MODE",
	];

	public static readonly ruleNames: string[] = [
		"T__0", "T__1", "PATTERN", "STRING", "QUOTED_STRING", "DQUOTED_STRING", 
		"SPACES", "WORD", "QUOTED_STRING_CH", "DQUOTED_STRING_CH", "WS",
	];

	private static readonly _LITERAL_NAMES: Array<string | undefined> = [
		undefined, "'-'", "'--'",
	];
	private static readonly _SYMBOLIC_NAMES: Array<string | undefined> = [
		undefined, undefined, undefined, "PATTERN", "STRING", "QUOTED_STRING", 
		"DQUOTED_STRING", "SPACES", "WS",
	];
	public static readonly VOCABULARY: Vocabulary = new VocabularyImpl(TerdLexer._LITERAL_NAMES, TerdLexer._SYMBOLIC_NAMES, []);

	// @Override
	// @NotNull
	public get vocabulary(): Vocabulary {
		return TerdLexer.VOCABULARY;
	}
	// tslint:enable:no-trailing-whitespace


	constructor(input: CharStream) {
		super(input);
		this._interp = new LexerATNSimulator(TerdLexer._ATN, this);
	}

	// @Override
	public get grammarFileName(): string { return "Terd.g4"; }

	// @Override
	public get ruleNames(): string[] { return TerdLexer.ruleNames; }

	// @Override
	public get serializedATN(): string { return TerdLexer._serializedATN; }

	// @Override
	public get channelNames(): string[] { return TerdLexer.channelNames; }

	// @Override
	public get modeNames(): string[] { return TerdLexer.modeNames; }

	public static readonly _serializedATN: string =
		"\x03\uC91D\uCABA\u058D\uAFBA\u4F53\u0607\uEA8B\uC241\x02\nN\b\x01\x04" +
		"\x02\t\x02\x04\x03\t\x03\x04\x04\t\x04\x04\x05\t\x05\x04\x06\t\x06\x04" +
		"\x07\t\x07\x04\b\t\b\x04\t\t\t\x04\n\t\n\x04\v\t\v\x04\f\t\f\x03\x02\x03" +
		"\x02\x03\x03\x03\x03\x03\x03\x03\x04\x03\x04\x03\x04\x07\x04\"\n\x04\f" +
		"\x04\x0E\x04%\v\x04\x03\x05\x03\x05\x05\x05)\n\x05\x03\x06\x03\x06\x07" +
		"\x06-\n\x06\f\x06\x0E\x060\v\x06\x03\x06\x03\x06\x03\x07\x03\x07\x07\x07" +
		"6\n\x07\f\x07\x0E\x079\v\x07\x03\x07\x03\x07\x03\b\x06\b>\n\b\r\b\x0E" +
		"\b?\x03\t\x03\t\x03\n\x03\n\x03\v\x03\v\x03\f\x06\fI\n\f\r\f\x0E\fJ\x03" +
		"\f\x03\f\x02\x02\x02\r\x03\x02\x03\x05\x02\x04\x07\x02\x05\t\x02\x06\v" +
		"\x02\x07\r\x02\b\x0F\x02\t\x11\x02\x02\x13\x02\x02\x15\x02\x02\x17\x02" +
		"\n\x03\x02\x07\x04\x02\v\v\"\"\x06\x02\"\"$$))//\x03\x02))\x03\x02$$\x05" +
		"\x02\v\v\x0F\x0F\"\"\x02Q\x02\x03\x03\x02\x02\x02\x02\x05\x03\x02\x02" +
		"\x02\x02\x07\x03\x02\x02\x02\x02\t\x03\x02\x02\x02\x02\v\x03\x02\x02\x02" +
		"\x02\r\x03\x02\x02\x02\x02\x0F\x03\x02\x02\x02\x02\x17\x03\x02\x02\x02" +
		"\x03\x19\x03\x02\x02\x02\x05\x1B\x03\x02\x02\x02\x07\x1E\x03\x02\x02\x02" +
		"\t(\x03\x02\x02\x02\v*\x03\x02\x02\x02\r3\x03\x02\x02\x02\x0F=\x03\x02" +
		"\x02\x02\x11A\x03\x02\x02\x02\x13C\x03\x02\x02\x02\x15E\x03\x02\x02\x02" +
		"\x17H\x03\x02\x02\x02\x19\x1A\x07/\x02\x02\x1A\x04\x03\x02\x02\x02\x1B" +
		"\x1C\x07/\x02\x02\x1C\x1D\x07/\x02\x02\x1D\x06\x03\x02\x02\x02\x1E#\x05" +
		"\x11\t\x02\x1F\"\x07/\x02\x02 \"\x05\x11\t\x02!\x1F\x03\x02\x02\x02! " +
		"\x03\x02\x02\x02\"%\x03\x02\x02\x02#!\x03\x02\x02\x02#$\x03\x02\x02\x02" +
		"$\b\x03\x02\x02\x02%#\x03\x02\x02\x02&)\x05\v\x06\x02\')\x05\r\x07\x02" +
		"(&\x03\x02\x02\x02(\'\x03\x02\x02\x02)\n\x03\x02\x02\x02*.\x07)\x02\x02" +
		"+-\x05\x13\n\x02,+\x03\x02\x02\x02-0\x03\x02\x02\x02.,\x03\x02\x02\x02" +
		"./\x03\x02\x02\x02/1\x03\x02\x02\x020.\x03\x02\x02\x0212\x07)\x02\x02" +
		"2\f\x03\x02\x02\x0237\x07$\x02\x0246\x05\x15\v\x0254\x03\x02\x02\x026" +
		"9\x03\x02\x02\x0275\x03\x02\x02\x0278\x03\x02\x02\x028:\x03\x02\x02\x02" +
		"97\x03\x02\x02\x02:;\x07$\x02\x02;\x0E\x03\x02\x02\x02<>\t\x02\x02\x02" +
		"=<\x03\x02\x02\x02>?\x03\x02\x02\x02?=\x03\x02\x02\x02?@\x03\x02\x02\x02" +
		"@\x10\x03\x02\x02\x02AB\n\x03\x02\x02B\x12\x03\x02\x02\x02CD\n\x04\x02" +
		"\x02D\x14\x03\x02\x02\x02EF\n\x05\x02\x02F\x16\x03\x02\x02\x02GI\t\x06" +
		"\x02\x02HG\x03\x02\x02\x02IJ\x03\x02\x02\x02JH\x03\x02\x02\x02JK\x03\x02" +
		"\x02\x02KL\x03\x02\x02\x02LM\b\f\x02\x02M\x18\x03\x02\x02\x02\n\x02!#" +
		"(.7?J\x03\b\x02\x02";
	public static __ATN: ATN;
	public static get _ATN(): ATN {
		if (!TerdLexer.__ATN) {
			TerdLexer.__ATN = new ATNDeserializer().deserialize(Utils.toCharArray(TerdLexer._serializedATN));
		}

		return TerdLexer.__ATN;
	}

}

