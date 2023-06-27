// Generated from /Users/I507145/Workspace/LKS/Terd/src/grammar/Terd.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TerdParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, PATTERN=3, STRING=4, QUOTED_STRING=5, DQUOTED_STRING=6, 
		SPACES=7, WS=8;
	public static final int
		RULE_command = 0, RULE_executable = 1, RULE_arguments = 2, RULE_argument = 3, 
		RULE_option = 4, RULE_optionWithArgument = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"command", "executable", "arguments", "argument", "option", "optionWithArgument"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "PATTERN", "STRING", "QUOTED_STRING", "DQUOTED_STRING", 
			"SPACES", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Terd.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TerdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CommandContext extends ParserRuleContext {
		public ExecutableContext executable() {
			return getRuleContext(ExecutableContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TerdParser.EOF, 0); }
		public TerminalNode SPACES() { return getToken(TerdParser.SPACES, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			executable();
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACES) {
				{
				setState(13);
				match(SPACES);
				setState(14);
				arguments();
				}
			}

			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExecutableContext extends ParserRuleContext {
		public TerminalNode PATTERN() { return getToken(TerdParser.PATTERN, 0); }
		public ExecutableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_executable; }
	}

	public final ExecutableContext executable() throws RecognitionException {
		ExecutableContext _localctx = new ExecutableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_executable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(PATTERN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> SPACES() { return getTokens(TerdParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(TerdParser.SPACES, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			argument();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACES) {
				{
				{
				setState(22);
				match(SPACES);
				setState(23);
				argument();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public OptionContext option() {
			return getRuleContext(OptionContext.class,0);
		}
		public OptionWithArgumentContext optionWithArgument() {
			return getRuleContext(OptionWithArgumentContext.class,0);
		}
		public TerminalNode PATTERN() { return getToken(TerdParser.PATTERN, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(29);
				option();
				}
				break;
			case T__1:
				{
				setState(30);
				optionWithArgument();
				}
				break;
			case PATTERN:
				{
				setState(31);
				match(PATTERN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public TerminalNode PATTERN() { return getToken(TerdParser.PATTERN, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(35);
			match(PATTERN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionWithArgumentContext extends ParserRuleContext {
		public List<TerminalNode> PATTERN() { return getTokens(TerdParser.PATTERN); }
		public TerminalNode PATTERN(int i) {
			return getToken(TerdParser.PATTERN, i);
		}
		public TerminalNode SPACES() { return getToken(TerdParser.SPACES, 0); }
		public OptionWithArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionWithArgument; }
	}

	public final OptionWithArgumentContext optionWithArgument() throws RecognitionException {
		OptionWithArgumentContext _localctx = new OptionWithArgumentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_optionWithArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__1);
			setState(38);
			match(PATTERN);
			setState(39);
			match(SPACES);
			setState(40);
			match(PATTERN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\5\2\22\n\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\7\4\33\n\4\f\4\16\4\36\13\4\3\5\3\5\3\5\5\5#\n\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2\2*\2\16\3\2\2\2"+
		"\4\25\3\2\2\2\6\27\3\2\2\2\b\"\3\2\2\2\n$\3\2\2\2\f\'\3\2\2\2\16\21\5"+
		"\4\3\2\17\20\7\t\2\2\20\22\5\6\4\2\21\17\3\2\2\2\21\22\3\2\2\2\22\23\3"+
		"\2\2\2\23\24\7\2\2\3\24\3\3\2\2\2\25\26\7\5\2\2\26\5\3\2\2\2\27\34\5\b"+
		"\5\2\30\31\7\t\2\2\31\33\5\b\5\2\32\30\3\2\2\2\33\36\3\2\2\2\34\32\3\2"+
		"\2\2\34\35\3\2\2\2\35\7\3\2\2\2\36\34\3\2\2\2\37#\5\n\6\2 #\5\f\7\2!#"+
		"\7\5\2\2\"\37\3\2\2\2\" \3\2\2\2\"!\3\2\2\2#\t\3\2\2\2$%\7\3\2\2%&\7\5"+
		"\2\2&\13\3\2\2\2\'(\7\4\2\2()\7\5\2\2)*\7\t\2\2*+\7\5\2\2+\r\3\2\2\2\5"+
		"\21\34\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}