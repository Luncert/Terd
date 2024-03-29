// Generated from /Users/I507145/Workspace/LKS/Terd/src/grammar/Terd.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TerdLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, PATTERN=3, STRING=4, QUOTED_STRING=5, DQUOTED_STRING=6, 
		SPACES=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "PATTERN", "STRING", "QUOTED_STRING", "DQUOTED_STRING", 
			"SPACES", "WORD", "QUOTED_STRING_CH", "DQUOTED_STRING_CH", "WS"
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


	public TerdLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Terd.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nN\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\7\4\"\n\4\f\4\16\4%\13\4\3"+
		"\5\3\5\5\5)\n\5\3\6\3\6\7\6-\n\6\f\6\16\6\60\13\6\3\6\3\6\3\7\3\7\7\7"+
		"\66\n\7\f\7\16\79\13\7\3\7\3\7\3\b\6\b>\n\b\r\b\16\b?\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\6\fI\n\f\r\f\16\fJ\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\2\23\2\25\2\27\n\3\2\7\4\2\13\13\"\"\6\2\"\"$$))//\3\2))\3"+
		"\2$$\5\2\13\13\17\17\"\"\2Q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2"+
		"\5\33\3\2\2\2\7\36\3\2\2\2\t(\3\2\2\2\13*\3\2\2\2\r\63\3\2\2\2\17=\3\2"+
		"\2\2\21A\3\2\2\2\23C\3\2\2\2\25E\3\2\2\2\27H\3\2\2\2\31\32\7/\2\2\32\4"+
		"\3\2\2\2\33\34\7/\2\2\34\35\7/\2\2\35\6\3\2\2\2\36#\5\21\t\2\37\"\7/\2"+
		"\2 \"\5\21\t\2!\37\3\2\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\b"+
		"\3\2\2\2%#\3\2\2\2&)\5\13\6\2\')\5\r\7\2(&\3\2\2\2(\'\3\2\2\2)\n\3\2\2"+
		"\2*.\7)\2\2+-\5\23\n\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3"+
		"\2\2\2\60.\3\2\2\2\61\62\7)\2\2\62\f\3\2\2\2\63\67\7$\2\2\64\66\5\25\13"+
		"\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3"+
		"\2\2\2:;\7$\2\2;\16\3\2\2\2<>\t\2\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@"+
		"\3\2\2\2@\20\3\2\2\2AB\n\3\2\2B\22\3\2\2\2CD\n\4\2\2D\24\3\2\2\2EF\n\5"+
		"\2\2F\26\3\2\2\2GI\t\6\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3"+
		"\2\2\2LM\b\f\2\2M\30\3\2\2\2\n\2!#(.\67?J\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}