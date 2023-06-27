// Generated from src/grammar/Terd.g4 by ANTLR 4.9.0-SNAPSHOT


import { ATN } from "antlr4ts/atn/ATN";
import { ATNDeserializer } from "antlr4ts/atn/ATNDeserializer";
import { FailedPredicateException } from "antlr4ts/FailedPredicateException";
import { NotNull } from "antlr4ts/Decorators";
import { NoViableAltException } from "antlr4ts/NoViableAltException";
import { Override } from "antlr4ts/Decorators";
import { Parser } from "antlr4ts/Parser";
import { ParserRuleContext } from "antlr4ts/ParserRuleContext";
import { ParserATNSimulator } from "antlr4ts/atn/ParserATNSimulator";
import { ParseTreeListener } from "antlr4ts/tree/ParseTreeListener";
import { ParseTreeVisitor } from "antlr4ts/tree/ParseTreeVisitor";
import { RecognitionException } from "antlr4ts/RecognitionException";
import { RuleContext } from "antlr4ts/RuleContext";
//import { RuleVersion } from "antlr4ts/RuleVersion";
import { TerminalNode } from "antlr4ts/tree/TerminalNode";
import { Token } from "antlr4ts/Token";
import { TokenStream } from "antlr4ts/TokenStream";
import { Vocabulary } from "antlr4ts/Vocabulary";
import { VocabularyImpl } from "antlr4ts/VocabularyImpl";

import * as Utils from "antlr4ts/misc/Utils";

import { TerdListener } from "./TerdListener";
import { TerdVisitor } from "./TerdVisitor";


export class TerdParser extends Parser {
	public static readonly T__0 = 1;
	public static readonly T__1 = 2;
	public static readonly PATTERN = 3;
	public static readonly STRING = 4;
	public static readonly QUOTED_STRING = 5;
	public static readonly DQUOTED_STRING = 6;
	public static readonly SPACES = 7;
	public static readonly WS = 8;
	public static readonly RULE_command = 0;
	public static readonly RULE_executable = 1;
	public static readonly RULE_arguments = 2;
	public static readonly RULE_argument = 3;
	public static readonly RULE_option = 4;
	public static readonly RULE_optionWithArgument = 5;
	// tslint:disable:no-trailing-whitespace
	public static readonly ruleNames: string[] = [
		"command", "executable", "arguments", "argument", "option", "optionWithArgument",
	];

	private static readonly _LITERAL_NAMES: Array<string | undefined> = [
		undefined, "'-'", "'--'",
	];
	private static readonly _SYMBOLIC_NAMES: Array<string | undefined> = [
		undefined, undefined, undefined, "PATTERN", "STRING", "QUOTED_STRING", 
		"DQUOTED_STRING", "SPACES", "WS",
	];
	public static readonly VOCABULARY: Vocabulary = new VocabularyImpl(TerdParser._LITERAL_NAMES, TerdParser._SYMBOLIC_NAMES, []);

	// @Override
	// @NotNull
	public get vocabulary(): Vocabulary {
		return TerdParser.VOCABULARY;
	}
	// tslint:enable:no-trailing-whitespace

	// @Override
	public get grammarFileName(): string { return "Terd.g4"; }

	// @Override
	public get ruleNames(): string[] { return TerdParser.ruleNames; }

	// @Override
	public get serializedATN(): string { return TerdParser._serializedATN; }

	protected createFailedPredicateException(predicate?: string, message?: string): FailedPredicateException {
		return new FailedPredicateException(this, predicate, message);
	}

	constructor(input: TokenStream) {
		super(input);
		this._interp = new ParserATNSimulator(TerdParser._ATN, this);
	}
	// @RuleVersion(0)
	public command(): CommandContext {
		let _localctx: CommandContext = new CommandContext(this._ctx, this.state);
		this.enterRule(_localctx, 0, TerdParser.RULE_command);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 12;
			this.executable();
			this.state = 15;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			if (_la === TerdParser.SPACES) {
				{
				this.state = 13;
				this.match(TerdParser.SPACES);
				this.state = 14;
				this.arguments();
				}
			}

			this.state = 17;
			this.match(TerdParser.EOF);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public executable(): ExecutableContext {
		let _localctx: ExecutableContext = new ExecutableContext(this._ctx, this.state);
		this.enterRule(_localctx, 2, TerdParser.RULE_executable);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 19;
			this.match(TerdParser.PATTERN);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public arguments(): ArgumentsContext {
		let _localctx: ArgumentsContext = new ArgumentsContext(this._ctx, this.state);
		this.enterRule(_localctx, 4, TerdParser.RULE_arguments);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 21;
			this.argument();
			this.state = 26;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la === TerdParser.SPACES) {
				{
				{
				this.state = 22;
				this.match(TerdParser.SPACES);
				this.state = 23;
				this.argument();
				}
				}
				this.state = 28;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public argument(): ArgumentContext {
		let _localctx: ArgumentContext = new ArgumentContext(this._ctx, this.state);
		this.enterRule(_localctx, 6, TerdParser.RULE_argument);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 32;
			this._errHandler.sync(this);
			switch (this._input.LA(1)) {
			case TerdParser.T__0:
				{
				this.state = 29;
				this.option();
				}
				break;
			case TerdParser.T__1:
				{
				this.state = 30;
				this.optionWithArgument();
				}
				break;
			case TerdParser.PATTERN:
				{
				this.state = 31;
				this.match(TerdParser.PATTERN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public option(): OptionContext {
		let _localctx: OptionContext = new OptionContext(this._ctx, this.state);
		this.enterRule(_localctx, 8, TerdParser.RULE_option);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 34;
			this.match(TerdParser.T__0);
			this.state = 35;
			this.match(TerdParser.PATTERN);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public optionWithArgument(): OptionWithArgumentContext {
		let _localctx: OptionWithArgumentContext = new OptionWithArgumentContext(this._ctx, this.state);
		this.enterRule(_localctx, 10, TerdParser.RULE_optionWithArgument);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 37;
			this.match(TerdParser.T__1);
			this.state = 38;
			this.match(TerdParser.PATTERN);
			this.state = 39;
			this.match(TerdParser.SPACES);
			this.state = 40;
			this.match(TerdParser.PATTERN);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}

	public static readonly _serializedATN: string =
		"\x03\uC91D\uCABA\u058D\uAFBA\u4F53\u0607\uEA8B\uC241\x03\n-\x04\x02\t" +
		"\x02\x04\x03\t\x03\x04\x04\t\x04\x04\x05\t\x05\x04\x06\t\x06\x04\x07\t" +
		"\x07\x03\x02\x03\x02\x03\x02\x05\x02\x12\n\x02\x03\x02\x03\x02\x03\x03" +
		"\x03\x03\x03\x04\x03\x04\x03\x04\x07\x04\x1B\n\x04\f\x04\x0E\x04\x1E\v" +
		"\x04\x03\x05\x03\x05\x03\x05\x05\x05#\n\x05\x03\x06\x03\x06\x03\x06\x03" +
		"\x07\x03\x07\x03\x07\x03\x07\x03\x07\x03\x07\x02\x02\x02\b\x02\x02\x04" +
		"\x02\x06\x02\b\x02\n\x02\f\x02\x02\x02\x02*\x02\x0E\x03\x02\x02\x02\x04" +
		"\x15\x03\x02\x02\x02\x06\x17\x03\x02\x02\x02\b\"\x03\x02\x02\x02\n$\x03" +
		"\x02\x02\x02\f\'\x03\x02\x02\x02\x0E\x11\x05\x04\x03\x02\x0F\x10\x07\t" +
		"\x02\x02\x10\x12\x05\x06\x04\x02\x11\x0F\x03\x02\x02\x02\x11\x12\x03\x02" +
		"\x02\x02\x12\x13\x03\x02\x02\x02\x13\x14\x07\x02\x02\x03\x14\x03\x03\x02" +
		"\x02\x02\x15\x16\x07\x05\x02\x02\x16\x05\x03\x02\x02\x02\x17\x1C\x05\b" +
		"\x05\x02\x18\x19\x07\t\x02\x02\x19\x1B\x05\b\x05\x02\x1A\x18\x03\x02\x02" +
		"\x02\x1B\x1E\x03\x02\x02\x02\x1C\x1A\x03\x02\x02\x02\x1C\x1D\x03\x02\x02" +
		"\x02\x1D\x07\x03\x02\x02\x02\x1E\x1C\x03\x02\x02\x02\x1F#\x05\n\x06\x02" +
		" #\x05\f\x07\x02!#\x07\x05\x02\x02\"\x1F\x03\x02\x02\x02\" \x03\x02\x02" +
		"\x02\"!\x03\x02\x02\x02#\t\x03\x02\x02\x02$%\x07\x03\x02\x02%&\x07\x05" +
		"\x02\x02&\v\x03\x02\x02\x02\'(\x07\x04\x02\x02()\x07\x05\x02\x02)*\x07" +
		"\t\x02\x02*+\x07\x05\x02\x02+\r\x03\x02\x02\x02\x05\x11\x1C\"";
	public static __ATN: ATN;
	public static get _ATN(): ATN {
		if (!TerdParser.__ATN) {
			TerdParser.__ATN = new ATNDeserializer().deserialize(Utils.toCharArray(TerdParser._serializedATN));
		}

		return TerdParser.__ATN;
	}

}

export class CommandContext extends ParserRuleContext {
	public executable(): ExecutableContext {
		return this.getRuleContext(0, ExecutableContext);
	}
	public EOF(): TerminalNode { return this.getToken(TerdParser.EOF, 0); }
	public SPACES(): TerminalNode | undefined { return this.tryGetToken(TerdParser.SPACES, 0); }
	public arguments(): ArgumentsContext | undefined {
		return this.tryGetRuleContext(0, ArgumentsContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return TerdParser.RULE_command; }
	// @Override
	public enterRule(listener: TerdListener): void {
		if (listener.enterCommand) {
			listener.enterCommand(this);
		}
	}
	// @Override
	public exitRule(listener: TerdListener): void {
		if (listener.exitCommand) {
			listener.exitCommand(this);
		}
	}
	// @Override
	public accept<Result>(visitor: TerdVisitor<Result>): Result {
		if (visitor.visitCommand) {
			return visitor.visitCommand(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ExecutableContext extends ParserRuleContext {
	public PATTERN(): TerminalNode { return this.getToken(TerdParser.PATTERN, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return TerdParser.RULE_executable; }
	// @Override
	public enterRule(listener: TerdListener): void {
		if (listener.enterExecutable) {
			listener.enterExecutable(this);
		}
	}
	// @Override
	public exitRule(listener: TerdListener): void {
		if (listener.exitExecutable) {
			listener.exitExecutable(this);
		}
	}
	// @Override
	public accept<Result>(visitor: TerdVisitor<Result>): Result {
		if (visitor.visitExecutable) {
			return visitor.visitExecutable(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ArgumentsContext extends ParserRuleContext {
	public argument(): ArgumentContext[];
	public argument(i: number): ArgumentContext;
	public argument(i?: number): ArgumentContext | ArgumentContext[] {
		if (i === undefined) {
			return this.getRuleContexts(ArgumentContext);
		} else {
			return this.getRuleContext(i, ArgumentContext);
		}
	}
	public SPACES(): TerminalNode[];
	public SPACES(i: number): TerminalNode;
	public SPACES(i?: number): TerminalNode | TerminalNode[] {
		if (i === undefined) {
			return this.getTokens(TerdParser.SPACES);
		} else {
			return this.getToken(TerdParser.SPACES, i);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return TerdParser.RULE_arguments; }
	// @Override
	public enterRule(listener: TerdListener): void {
		if (listener.enterArguments) {
			listener.enterArguments(this);
		}
	}
	// @Override
	public exitRule(listener: TerdListener): void {
		if (listener.exitArguments) {
			listener.exitArguments(this);
		}
	}
	// @Override
	public accept<Result>(visitor: TerdVisitor<Result>): Result {
		if (visitor.visitArguments) {
			return visitor.visitArguments(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ArgumentContext extends ParserRuleContext {
	public option(): OptionContext | undefined {
		return this.tryGetRuleContext(0, OptionContext);
	}
	public optionWithArgument(): OptionWithArgumentContext | undefined {
		return this.tryGetRuleContext(0, OptionWithArgumentContext);
	}
	public PATTERN(): TerminalNode | undefined { return this.tryGetToken(TerdParser.PATTERN, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return TerdParser.RULE_argument; }
	// @Override
	public enterRule(listener: TerdListener): void {
		if (listener.enterArgument) {
			listener.enterArgument(this);
		}
	}
	// @Override
	public exitRule(listener: TerdListener): void {
		if (listener.exitArgument) {
			listener.exitArgument(this);
		}
	}
	// @Override
	public accept<Result>(visitor: TerdVisitor<Result>): Result {
		if (visitor.visitArgument) {
			return visitor.visitArgument(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class OptionContext extends ParserRuleContext {
	public PATTERN(): TerminalNode { return this.getToken(TerdParser.PATTERN, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return TerdParser.RULE_option; }
	// @Override
	public enterRule(listener: TerdListener): void {
		if (listener.enterOption) {
			listener.enterOption(this);
		}
	}
	// @Override
	public exitRule(listener: TerdListener): void {
		if (listener.exitOption) {
			listener.exitOption(this);
		}
	}
	// @Override
	public accept<Result>(visitor: TerdVisitor<Result>): Result {
		if (visitor.visitOption) {
			return visitor.visitOption(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class OptionWithArgumentContext extends ParserRuleContext {
	public PATTERN(): TerminalNode[];
	public PATTERN(i: number): TerminalNode;
	public PATTERN(i?: number): TerminalNode | TerminalNode[] {
		if (i === undefined) {
			return this.getTokens(TerdParser.PATTERN);
		} else {
			return this.getToken(TerdParser.PATTERN, i);
		}
	}
	public SPACES(): TerminalNode { return this.getToken(TerdParser.SPACES, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return TerdParser.RULE_optionWithArgument; }
	// @Override
	public enterRule(listener: TerdListener): void {
		if (listener.enterOptionWithArgument) {
			listener.enterOptionWithArgument(this);
		}
	}
	// @Override
	public exitRule(listener: TerdListener): void {
		if (listener.exitOptionWithArgument) {
			listener.exitOptionWithArgument(this);
		}
	}
	// @Override
	public accept<Result>(visitor: TerdVisitor<Result>): Result {
		if (visitor.visitOptionWithArgument) {
			return visitor.visitOptionWithArgument(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


