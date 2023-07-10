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
		RULE_option = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"command", "executable", "arguments", "argument", "option"
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
		public List<TerminalNode> SPACES() { return getTokens(TerdParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(TerdParser.SPACES, i);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TerdParser.EOF, 0); }
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
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACES) {
				{
				setState(10);
				match(SPACES);
				}
			}

			setState(13);
			executable();
			setState(14);
			match(SPACES);
			setState(15);
			arguments();
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACES) {
				{
				setState(16);
				match(SPACES);
				}
			}

			setState(19);
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
			setState(21);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			argument();
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					match(SPACES);
					setState(25);
					argument();
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				{
				setState(31);
				option();
				}
				break;
			case PATTERN:
				{
				setState(32);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(36);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n)\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\5\2\16\n\2\3\2\3\2\3\2\3\2\5\2\24\n\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\5\3\5\5\5$\n\5"+
		"\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2\3\4\2\'\2\r\3\2\2\2\4\27\3\2"+
		"\2\2\6\31\3\2\2\2\b#\3\2\2\2\n%\3\2\2\2\f\16\7\t\2\2\r\f\3\2\2\2\r\16"+
		"\3\2\2\2\16\17\3\2\2\2\17\20\5\4\3\2\20\21\7\t\2\2\21\23\5\6\4\2\22\24"+
		"\7\t\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\7\2\2\3\26\3"+
		"\3\2\2\2\27\30\7\5\2\2\30\5\3\2\2\2\31\36\5\b\5\2\32\33\7\t\2\2\33\35"+
		"\5\b\5\2\34\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\7\3"+
		"\2\2\2 \36\3\2\2\2!$\5\n\6\2\"$\7\5\2\2#!\3\2\2\2#\"\3\2\2\2$\t\3\2\2"+
		"\2%&\t\2\2\2&\'\7\5\2\2\'\13\3\2\2\2\6\r\23\36#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}