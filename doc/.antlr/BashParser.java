// Generated from /Users/I507145/Workspace/LKS/Terd/doc/Bash.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BashParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, WORD=42, NUMBER=43, NEWLINES=44, WS=45;
	public static final int
		RULE_command = 0, RULE_shellCommand = 1, RULE_forCommand = 2, RULE_selectCommand = 3, 
		RULE_caseCommand = 4, RULE_functionDef = 5, RULE_subShell = 6, RULE_ifCommand = 7, 
		RULE_groupCommand = 8, RULE_elifClause = 9, RULE_caseClause = 10, RULE_patternList = 11, 
		RULE_caseClauseSequence = 12, RULE_pattern = 13, RULE_list = 14, RULE_compoundList = 15, 
		RULE_list0 = 16, RULE_list1 = 17, RULE_listTerminator = 18, RULE_simpleList = 19, 
		RULE_simpleList1 = 20, RULE_pipelineCommand = 21, RULE_pipeline = 22, 
		RULE_timeOpt = 23, RULE_timeSpec = 24, RULE_simpleCommand = 25, RULE_redirectionList = 26, 
		RULE_simpleCommandElement = 27, RULE_redirection = 28, RULE_assignmentWord = 29, 
		RULE_wordList = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"command", "shellCommand", "forCommand", "selectCommand", "caseCommand", 
			"functionDef", "subShell", "ifCommand", "groupCommand", "elifClause", 
			"caseClause", "patternList", "caseClauseSequence", "pattern", "list", 
			"compoundList", "list0", "list1", "listTerminator", "simpleList", "simpleList1", 
			"pipelineCommand", "pipeline", "timeOpt", "timeSpec", "simpleCommand", 
			"redirectionList", "simpleCommandElement", "redirection", "assignmentWord", 
			"wordList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'do'", "'done'", "'until'", "'for'", "'{'", "'}'", 
			"';'", "'in'", "'select'", "'case'", "'esac'", "'('", "')'", "'function'", 
			"'if'", "'then'", "'fi'", "'else'", "'elif'", "';;'", "'|'", "'\n'", 
			"'&'", "'&&'", "'||'", "'!'", "'-p'", "'time'", "'>'", "'<'", "'>>'", 
			"'<<'", "'<&'", "'>&'", "'<<-'", "'-'", "'&>'", "'<>'", "'>|'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "WORD", "NUMBER", "NEWLINES", "WS"
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
	public String getGrammarFileName() { return "Bash.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BashParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CommandContext extends ParserRuleContext {
		public SimpleCommandContext simpleCommand() {
			return getRuleContext(SimpleCommandContext.class,0);
		}
		public ShellCommandContext shellCommand() {
			return getRuleContext(ShellCommandContext.class,0);
		}
		public RedirectionListContext redirectionList() {
			return getRuleContext(RedirectionListContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_command);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				simpleCommand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				shellCommand();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				shellCommand();
				setState(65);
				redirectionList();
				}
				break;
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

	public static class ShellCommandContext extends ParserRuleContext {
		public ForCommandContext forCommand() {
			return getRuleContext(ForCommandContext.class,0);
		}
		public CaseCommandContext caseCommand() {
			return getRuleContext(CaseCommandContext.class,0);
		}
		public List<CompoundListContext> compoundList() {
			return getRuleContexts(CompoundListContext.class);
		}
		public CompoundListContext compoundList(int i) {
			return getRuleContext(CompoundListContext.class,i);
		}
		public SelectCommandContext selectCommand() {
			return getRuleContext(SelectCommandContext.class,0);
		}
		public IfCommandContext ifCommand() {
			return getRuleContext(IfCommandContext.class,0);
		}
		public SubShellContext subShell() {
			return getRuleContext(SubShellContext.class,0);
		}
		public GroupCommandContext groupCommand() {
			return getRuleContext(GroupCommandContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public ShellCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shellCommand; }
	}

	public final ShellCommandContext shellCommand() throws RecognitionException {
		ShellCommandContext _localctx = new ShellCommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_shellCommand);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				forCommand();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				caseCommand();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(T__0);
				setState(72);
				compoundList();
				setState(73);
				match(T__1);
				setState(74);
				compoundList();
				setState(75);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(T__3);
				setState(78);
				compoundList();
				setState(79);
				match(T__1);
				setState(80);
				compoundList();
				setState(81);
				match(T__2);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				selectCommand();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				ifCommand();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				subShell();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 8);
				{
				setState(86);
				groupCommand();
				}
				break;
			case T__14:
			case WORD:
				enterOuterAlt(_localctx, 9);
				{
				setState(87);
				functionDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ForCommandContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public List<TerminalNode> NEWLINES() { return getTokens(BashParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(BashParser.NEWLINES, i);
		}
		public CompoundListContext compoundList() {
			return getRuleContext(CompoundListContext.class,0);
		}
		public WordListContext wordList() {
			return getRuleContext(WordListContext.class,0);
		}
		public ListTerminatorContext listTerminator() {
			return getRuleContext(ListTerminatorContext.class,0);
		}
		public ForCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCommand; }
	}

	public final ForCommandContext forCommand() throws RecognitionException {
		ForCommandContext _localctx = new ForCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forCommand);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__4);
				setState(91);
				match(WORD);
				setState(92);
				match(NEWLINES);
				setState(93);
				match(T__1);
				setState(94);
				compoundList();
				setState(95);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__4);
				setState(98);
				match(WORD);
				setState(99);
				match(NEWLINES);
				setState(100);
				match(T__5);
				setState(101);
				compoundList();
				setState(102);
				match(T__6);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(T__4);
				setState(105);
				match(WORD);
				setState(106);
				match(T__7);
				setState(107);
				match(NEWLINES);
				setState(108);
				match(T__1);
				setState(109);
				compoundList();
				setState(110);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(T__4);
				setState(113);
				match(WORD);
				setState(114);
				match(T__7);
				setState(115);
				match(NEWLINES);
				setState(116);
				match(T__5);
				setState(117);
				compoundList();
				setState(118);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(T__4);
				setState(121);
				match(WORD);
				setState(122);
				match(NEWLINES);
				setState(123);
				match(T__8);
				setState(124);
				wordList();
				setState(125);
				listTerminator();
				setState(126);
				match(NEWLINES);
				setState(127);
				match(T__1);
				setState(128);
				compoundList();
				setState(129);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(131);
				match(T__4);
				setState(132);
				match(WORD);
				setState(133);
				match(NEWLINES);
				setState(134);
				match(T__8);
				setState(135);
				wordList();
				setState(136);
				listTerminator();
				setState(137);
				match(NEWLINES);
				setState(138);
				match(T__5);
				setState(139);
				compoundList();
				setState(140);
				match(T__6);
				}
				break;
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

	public static class SelectCommandContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public List<TerminalNode> NEWLINES() { return getTokens(BashParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(BashParser.NEWLINES, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public WordListContext wordList() {
			return getRuleContext(WordListContext.class,0);
		}
		public ListTerminatorContext listTerminator() {
			return getRuleContext(ListTerminatorContext.class,0);
		}
		public SelectCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectCommand; }
	}

	public final SelectCommandContext selectCommand() throws RecognitionException {
		SelectCommandContext _localctx = new SelectCommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectCommand);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__9);
				setState(145);
				match(WORD);
				setState(146);
				match(NEWLINES);
				setState(147);
				match(T__1);
				setState(148);
				list();
				setState(149);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(T__9);
				setState(152);
				match(WORD);
				setState(153);
				match(NEWLINES);
				setState(154);
				match(T__5);
				setState(155);
				list();
				setState(156);
				match(T__6);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				match(T__9);
				setState(159);
				match(WORD);
				setState(160);
				match(T__7);
				setState(161);
				match(NEWLINES);
				setState(162);
				match(T__1);
				setState(163);
				list();
				setState(164);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				match(T__9);
				setState(167);
				match(WORD);
				setState(168);
				match(T__7);
				setState(169);
				match(NEWLINES);
				setState(170);
				match(T__5);
				setState(171);
				list();
				setState(172);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(174);
				match(T__9);
				setState(175);
				match(WORD);
				setState(176);
				match(NEWLINES);
				setState(177);
				match(T__8);
				setState(178);
				wordList();
				setState(179);
				listTerminator();
				setState(180);
				match(NEWLINES);
				setState(181);
				match(T__1);
				setState(182);
				list();
				setState(183);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				match(T__9);
				setState(186);
				match(WORD);
				setState(187);
				match(NEWLINES);
				setState(188);
				match(T__8);
				setState(189);
				wordList();
				setState(190);
				listTerminator();
				setState(191);
				match(NEWLINES);
				setState(192);
				match(T__5);
				setState(193);
				list();
				setState(194);
				match(T__6);
				}
				break;
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

	public static class CaseCommandContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public List<TerminalNode> NEWLINES() { return getTokens(BashParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(BashParser.NEWLINES, i);
		}
		public WordListContext wordList() {
			return getRuleContext(WordListContext.class,0);
		}
		public CaseClauseSequenceContext caseClauseSequence() {
			return getRuleContext(CaseClauseSequenceContext.class,0);
		}
		public CaseClauseContext caseClause() {
			return getRuleContext(CaseClauseContext.class,0);
		}
		public CaseCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseCommand; }
	}

	public final CaseCommandContext caseCommand() throws RecognitionException {
		CaseCommandContext _localctx = new CaseCommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_caseCommand);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(T__10);
				setState(199);
				match(WORD);
				setState(200);
				match(NEWLINES);
				setState(201);
				match(T__8);
				setState(202);
				wordList();
				setState(203);
				match(T__11);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(T__10);
				setState(206);
				match(WORD);
				setState(207);
				match(NEWLINES);
				setState(208);
				match(T__8);
				setState(209);
				caseClauseSequence(0);
				setState(210);
				match(NEWLINES);
				setState(211);
				match(T__11);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				match(T__10);
				setState(214);
				match(WORD);
				setState(215);
				match(NEWLINES);
				setState(216);
				match(T__8);
				setState(217);
				caseClause();
				setState(218);
				match(T__11);
				}
				break;
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

	public static class FunctionDefContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public TerminalNode NEWLINES() { return getToken(BashParser.NEWLINES, 0); }
		public GroupCommandContext groupCommand() {
			return getRuleContext(GroupCommandContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionDef);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(WORD);
				setState(223);
				match(T__12);
				setState(224);
				match(T__13);
				setState(225);
				match(NEWLINES);
				setState(226);
				groupCommand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(T__14);
				setState(228);
				match(WORD);
				setState(229);
				match(T__12);
				setState(230);
				match(T__13);
				setState(231);
				match(NEWLINES);
				setState(232);
				groupCommand();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				match(T__14);
				setState(234);
				match(WORD);
				setState(235);
				match(NEWLINES);
				setState(236);
				groupCommand();
				}
				break;
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

	public static class SubShellContext extends ParserRuleContext {
		public CompoundListContext compoundList() {
			return getRuleContext(CompoundListContext.class,0);
		}
		public SubShellContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subShell; }
	}

	public final SubShellContext subShell() throws RecognitionException {
		SubShellContext _localctx = new SubShellContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_subShell);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__12);
			setState(240);
			compoundList();
			setState(241);
			match(T__13);
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

	public static class IfCommandContext extends ParserRuleContext {
		public List<CompoundListContext> compoundList() {
			return getRuleContexts(CompoundListContext.class);
		}
		public CompoundListContext compoundList(int i) {
			return getRuleContext(CompoundListContext.class,i);
		}
		public ElifClauseContext elifClause() {
			return getRuleContext(ElifClauseContext.class,0);
		}
		public IfCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCommand; }
	}

	public final IfCommandContext ifCommand() throws RecognitionException {
		IfCommandContext _localctx = new IfCommandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifCommand);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(T__15);
				setState(244);
				compoundList();
				setState(245);
				match(T__16);
				setState(246);
				compoundList();
				setState(247);
				match(T__17);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(T__15);
				setState(250);
				compoundList();
				setState(251);
				match(T__16);
				setState(252);
				compoundList();
				setState(253);
				match(T__18);
				setState(254);
				compoundList();
				setState(255);
				match(T__17);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				match(T__15);
				setState(258);
				compoundList();
				setState(259);
				match(T__16);
				setState(260);
				compoundList();
				setState(261);
				elifClause();
				setState(262);
				match(T__17);
				}
				break;
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

	public static class GroupCommandContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public GroupCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupCommand; }
	}

	public final GroupCommandContext groupCommand() throws RecognitionException {
		GroupCommandContext _localctx = new GroupCommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_groupCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__5);
			setState(267);
			list();
			setState(268);
			match(T__6);
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

	public static class ElifClauseContext extends ParserRuleContext {
		public List<CompoundListContext> compoundList() {
			return getRuleContexts(CompoundListContext.class);
		}
		public CompoundListContext compoundList(int i) {
			return getRuleContext(CompoundListContext.class,i);
		}
		public ElifClauseContext elifClause() {
			return getRuleContext(ElifClauseContext.class,0);
		}
		public ElifClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifClause; }
	}

	public final ElifClauseContext elifClause() throws RecognitionException {
		ElifClauseContext _localctx = new ElifClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elifClause);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(T__19);
				setState(271);
				compoundList();
				setState(272);
				match(T__16);
				setState(273);
				compoundList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(T__19);
				setState(276);
				compoundList();
				setState(277);
				match(T__16);
				setState(278);
				compoundList();
				setState(279);
				match(T__18);
				setState(280);
				compoundList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				match(T__19);
				setState(283);
				compoundList();
				setState(284);
				match(T__16);
				setState(285);
				compoundList();
				setState(286);
				elifClause();
				}
				break;
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

	public static class CaseClauseContext extends ParserRuleContext {
		public PatternListContext patternList() {
			return getRuleContext(PatternListContext.class,0);
		}
		public CaseClauseSequenceContext caseClauseSequence() {
			return getRuleContext(CaseClauseSequenceContext.class,0);
		}
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(290);
				caseClauseSequence(0);
				}
				break;
			}
			setState(293);
			patternList();
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

	public static class PatternListContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINES() { return getTokens(BashParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(BashParser.NEWLINES, i);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public CompoundListContext compoundList() {
			return getRuleContext(CompoundListContext.class,0);
		}
		public PatternListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternList; }
	}

	public final PatternListContext patternList() throws RecognitionException {
		PatternListContext _localctx = new PatternListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_patternList);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(NEWLINES);
				setState(296);
				pattern();
				setState(297);
				match(T__13);
				setState(298);
				compoundList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(NEWLINES);
				setState(301);
				pattern();
				setState(302);
				match(T__13);
				setState(303);
				match(NEWLINES);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(NEWLINES);
				setState(306);
				match(T__12);
				setState(307);
				pattern();
				setState(308);
				match(T__13);
				setState(309);
				compoundList();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
				match(NEWLINES);
				setState(312);
				match(T__12);
				setState(313);
				pattern();
				setState(314);
				match(T__13);
				setState(315);
				match(NEWLINES);
				}
				break;
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

	public static class CaseClauseSequenceContext extends ParserRuleContext {
		public PatternListContext patternList() {
			return getRuleContext(PatternListContext.class,0);
		}
		public CaseClauseSequenceContext caseClauseSequence() {
			return getRuleContext(CaseClauseSequenceContext.class,0);
		}
		public CaseClauseSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClauseSequence; }
	}

	public final CaseClauseSequenceContext caseClauseSequence() throws RecognitionException {
		return caseClauseSequence(0);
	}

	private CaseClauseSequenceContext caseClauseSequence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CaseClauseSequenceContext _localctx = new CaseClauseSequenceContext(_ctx, _parentState);
		CaseClauseSequenceContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_caseClauseSequence, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(320);
			patternList();
			setState(321);
			match(T__20);
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CaseClauseSequenceContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_caseClauseSequence);
					setState(323);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(324);
					patternList();
					setState(325);
					match(T__20);
					}
					} 
				}
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(BashParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BashParser.WORD, i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(WORD);
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(333);
				match(T__21);
				setState(334);
				match(WORD);
				}
				}
				setState(339);
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode NEWLINES() { return getToken(BashParser.NEWLINES, 0); }
		public List0Context list0() {
			return getRuleContext(List0Context.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(NEWLINES);
			setState(341);
			list0();
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

	public static class CompoundListContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode NEWLINES() { return getToken(BashParser.NEWLINES, 0); }
		public List1Context list1() {
			return getRuleContext(List1Context.class,0);
		}
		public CompoundListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundList; }
	}

	public final CompoundListContext compoundList() throws RecognitionException {
		CompoundListContext _localctx = new CompoundListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compoundList);
		try {
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				match(NEWLINES);
				setState(345);
				list1(0);
				}
				break;
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

	public static class List0Context extends ParserRuleContext {
		public List1Context list1() {
			return getRuleContext(List1Context.class,0);
		}
		public TerminalNode NEWLINES() { return getToken(BashParser.NEWLINES, 0); }
		public List0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list0; }
	}

	public final List0Context list0() throws RecognitionException {
		List0Context _localctx = new List0Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_list0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			list1(0);
			setState(349);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__22) | (1L << T__23))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(350);
			match(NEWLINES);
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

	public static class List1Context extends ParserRuleContext {
		public PipelineCommandContext pipelineCommand() {
			return getRuleContext(PipelineCommandContext.class,0);
		}
		public List<List1Context> list1() {
			return getRuleContexts(List1Context.class);
		}
		public List1Context list1(int i) {
			return getRuleContext(List1Context.class,i);
		}
		public TerminalNode NEWLINES() { return getToken(BashParser.NEWLINES, 0); }
		public List1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list1; }
	}

	public final List1Context list1() throws RecognitionException {
		return list1(0);
	}

	private List1Context list1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		List1Context _localctx = new List1Context(_ctx, _parentState);
		List1Context _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_list1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(353);
			pipelineCommand();
			}
			_ctx.stop = _input.LT(-1);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new List1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_list1);
					setState(355);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(356);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(357);
					match(NEWLINES);
					setState(358);
					list1(3);
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListTerminatorContext extends ParserRuleContext {
		public ListTerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listTerminator; }
	}

	public final ListTerminatorContext listTerminator() throws RecognitionException {
		ListTerminatorContext _localctx = new ListTerminatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_listTerminator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SimpleListContext extends ParserRuleContext {
		public SimpleList1Context simpleList1() {
			return getRuleContext(SimpleList1Context.class,0);
		}
		public SimpleListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleList; }
	}

	public final SimpleListContext simpleList() throws RecognitionException {
		SimpleListContext _localctx = new SimpleListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_simpleList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			simpleList1();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__23) {
				{
				setState(367);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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

	public static class SimpleList1Context extends ParserRuleContext {
		public List<PipelineCommandContext> pipelineCommand() {
			return getRuleContexts(PipelineCommandContext.class);
		}
		public PipelineCommandContext pipelineCommand(int i) {
			return getRuleContext(PipelineCommandContext.class,i);
		}
		public List<TerminalNode> NEWLINES() { return getTokens(BashParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(BashParser.NEWLINES, i);
		}
		public SimpleList1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleList1; }
	}

	public final SimpleList1Context simpleList1() throws RecognitionException {
		SimpleList1Context _localctx = new SimpleList1Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_simpleList1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			pipelineCommand();
			setState(382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(377);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__24:
						{
						setState(371);
						match(T__24);
						setState(372);
						match(NEWLINES);
						}
						break;
					case T__25:
						{
						setState(373);
						match(T__25);
						setState(374);
						match(NEWLINES);
						}
						break;
					case T__23:
						{
						setState(375);
						match(T__23);
						}
						break;
					case T__7:
						{
						setState(376);
						match(T__7);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(379);
					pipelineCommand();
					}
					} 
				}
				setState(384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class PipelineCommandContext extends ParserRuleContext {
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public TimeSpecContext timeSpec() {
			return getRuleContext(TimeSpecContext.class,0);
		}
		public PipelineCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipelineCommand; }
	}

	public final PipelineCommandContext pipelineCommand() throws RecognitionException {
		PipelineCommandContext _localctx = new PipelineCommandContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_pipelineCommand);
		try {
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				pipeline();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				match(T__26);
				setState(387);
				pipeline();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(388);
				timeSpec();
				setState(389);
				pipeline();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(391);
				timeSpec();
				setState(392);
				match(T__26);
				setState(393);
				pipeline();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(395);
				match(T__26);
				setState(396);
				timeSpec();
				setState(397);
				pipeline();
				}
				break;
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

	public static class PipelineContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<TerminalNode> NEWLINES() { return getTokens(BashParser.NEWLINES); }
		public TerminalNode NEWLINES(int i) {
			return getToken(BashParser.NEWLINES, i);
		}
		public PipelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline; }
	}

	public final PipelineContext pipeline() throws RecognitionException {
		PipelineContext _localctx = new PipelineContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_pipeline);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			command();
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(402);
					match(T__21);
					setState(403);
					match(NEWLINES);
					setState(404);
					command();
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class TimeOptContext extends ParserRuleContext {
		public TimeOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeOpt; }
	}

	public final TimeOptContext timeOpt() throws RecognitionException {
		TimeOptContext _localctx = new TimeOptContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_timeOpt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(T__27);
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

	public static class TimeSpecContext extends ParserRuleContext {
		public TimeOptContext timeOpt() {
			return getRuleContext(TimeOptContext.class,0);
		}
		public TimeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSpec; }
	}

	public final TimeSpecContext timeSpec() throws RecognitionException {
		TimeSpecContext _localctx = new TimeSpecContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_timeSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(T__28);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(413);
				timeOpt();
				}
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

	public static class SimpleCommandContext extends ParserRuleContext {
		public List<SimpleCommandElementContext> simpleCommandElement() {
			return getRuleContexts(SimpleCommandElementContext.class);
		}
		public SimpleCommandElementContext simpleCommandElement(int i) {
			return getRuleContext(SimpleCommandElementContext.class,i);
		}
		public SimpleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCommand; }
	}

	public final SimpleCommandContext simpleCommand() throws RecognitionException {
		SimpleCommandContext _localctx = new SimpleCommandContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_simpleCommand);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			simpleCommandElement();
			setState(420);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(417);
					simpleCommandElement();
					}
					} 
				}
				setState(422);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class RedirectionListContext extends ParserRuleContext {
		public List<RedirectionContext> redirection() {
			return getRuleContexts(RedirectionContext.class);
		}
		public RedirectionContext redirection(int i) {
			return getRuleContext(RedirectionContext.class,i);
		}
		public RedirectionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redirectionList; }
	}

	public final RedirectionListContext redirectionList() throws RecognitionException {
		RedirectionListContext _localctx = new RedirectionListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_redirectionList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			redirection();
			setState(427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(424);
					redirection();
					}
					} 
				}
				setState(429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class SimpleCommandElementContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public AssignmentWordContext assignmentWord() {
			return getRuleContext(AssignmentWordContext.class,0);
		}
		public RedirectionContext redirection() {
			return getRuleContext(RedirectionContext.class,0);
		}
		public SimpleCommandElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCommandElement; }
	}

	public final SimpleCommandElementContext simpleCommandElement() throws RecognitionException {
		SimpleCommandElementContext _localctx = new SimpleCommandElementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_simpleCommandElement);
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				assignmentWord();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				redirection();
				}
				break;
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

	public static class RedirectionContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(BashParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(BashParser.NUMBER, i);
		}
		public RedirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redirection; }
	}

	public final RedirectionContext redirection() throws RecognitionException {
		RedirectionContext _localctx = new RedirectionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_redirection);
		try {
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				match(T__29);
				setState(436);
				match(WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(T__30);
				setState(438);
				match(WORD);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				match(NUMBER);
				setState(440);
				match(T__29);
				setState(441);
				match(WORD);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(442);
				match(NUMBER);
				setState(443);
				match(T__30);
				setState(444);
				match(WORD);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(445);
				match(T__31);
				setState(446);
				match(WORD);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(447);
				match(NUMBER);
				setState(448);
				match(T__31);
				setState(449);
				match(WORD);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(450);
				match(T__32);
				setState(451);
				match(WORD);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(452);
				match(NUMBER);
				setState(453);
				match(T__32);
				setState(454);
				match(WORD);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(455);
				match(T__33);
				setState(456);
				match(NUMBER);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(457);
				match(NUMBER);
				setState(458);
				match(T__33);
				setState(459);
				match(NUMBER);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(460);
				match(T__34);
				setState(461);
				match(NUMBER);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(462);
				match(NUMBER);
				setState(463);
				match(T__34);
				setState(464);
				match(NUMBER);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(465);
				match(T__33);
				setState(466);
				match(WORD);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(467);
				match(NUMBER);
				setState(468);
				match(T__33);
				setState(469);
				match(WORD);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(470);
				match(T__34);
				setState(471);
				match(WORD);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(472);
				match(NUMBER);
				setState(473);
				match(T__34);
				setState(474);
				match(WORD);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(475);
				match(T__35);
				setState(476);
				match(WORD);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(477);
				match(NUMBER);
				setState(478);
				match(T__35);
				setState(479);
				match(WORD);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(480);
				match(T__34);
				setState(481);
				match(T__36);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(482);
				match(NUMBER);
				setState(483);
				match(T__34);
				setState(484);
				match(T__36);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(485);
				match(T__33);
				setState(486);
				match(T__36);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(487);
				match(NUMBER);
				setState(488);
				match(T__33);
				setState(489);
				match(T__36);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(490);
				match(T__37);
				setState(491);
				match(WORD);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(492);
				match(NUMBER);
				setState(493);
				match(T__38);
				setState(494);
				match(WORD);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(495);
				match(T__38);
				setState(496);
				match(WORD);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(497);
				match(T__39);
				setState(498);
				match(WORD);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(499);
				match(NUMBER);
				setState(500);
				match(T__39);
				setState(501);
				match(WORD);
				}
				break;
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

	public static class AssignmentWordContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(BashParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BashParser.WORD, i);
		}
		public AssignmentWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentWord; }
	}

	public final AssignmentWordContext assignmentWord() throws RecognitionException {
		AssignmentWordContext _localctx = new AssignmentWordContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_assignmentWord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(WORD);
			setState(505);
			match(T__40);
			setState(506);
			match(WORD);
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

	public static class WordListContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(BashParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BashParser.WORD, i);
		}
		public WordListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordList; }
	}

	public final WordListContext wordList() throws RecognitionException {
		WordListContext _localctx = new WordListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_wordList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(WORD);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(509);
				match(WORD);
				}
				}
				setState(514);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return caseClauseSequence_sempred((CaseClauseSequenceContext)_localctx, predIndex);
		case 17:
			return list1_sempred((List1Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean caseClauseSequence_sempred(CaseClauseSequenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean list1_sempred(List1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0206\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\5\2F\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3[\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0091\n\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00c7\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6\u00df\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u00f0\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u010b"+
		"\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0123\n\13\3\f\5\f\u0126"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0140\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u014a\n\16\f\16\16\16\u014d\13\16\3\17\3\17\3\17"+
		"\7\17\u0152\n\17\f\17\16\17\u0155\13\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\5\21\u015d\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u016a\n\23\f\23\16\23\u016d\13\23\3\24\3\24\3\25\3\25\5\25\u0173"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u017c\n\26\3\26\7\26\u017f"+
		"\n\26\f\26\16\26\u0182\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u0192\n\27\3\30\3\30\3\30\3\30\7\30"+
		"\u0198\n\30\f\30\16\30\u019b\13\30\3\31\3\31\3\32\3\32\5\32\u01a1\n\32"+
		"\3\33\3\33\7\33\u01a5\n\33\f\33\16\33\u01a8\13\33\3\34\3\34\7\34\u01ac"+
		"\n\34\f\34\16\34\u01af\13\34\3\35\3\35\3\35\5\35\u01b4\n\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01f9\n\36\3\37\3\37"+
		"\3\37\3\37\3 \3 \7 \u0201\n \f \16 \u0204\13 \3 \2\4\32$!\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\6\4\2\n\n\31\32"+
		"\4\2\n\n\31\34\4\2\n\n\31\31\4\2\n\n\32\32\2\u0234\2E\3\2\2\2\4Z\3\2\2"+
		"\2\6\u0090\3\2\2\2\b\u00c6\3\2\2\2\n\u00de\3\2\2\2\f\u00ef\3\2\2\2\16"+
		"\u00f1\3\2\2\2\20\u010a\3\2\2\2\22\u010c\3\2\2\2\24\u0122\3\2\2\2\26\u0125"+
		"\3\2\2\2\30\u013f\3\2\2\2\32\u0141\3\2\2\2\34\u014e\3\2\2\2\36\u0156\3"+
		"\2\2\2 \u015c\3\2\2\2\"\u015e\3\2\2\2$\u0162\3\2\2\2&\u016e\3\2\2\2(\u0170"+
		"\3\2\2\2*\u0174\3\2\2\2,\u0191\3\2\2\2.\u0193\3\2\2\2\60\u019c\3\2\2\2"+
		"\62\u019e\3\2\2\2\64\u01a2\3\2\2\2\66\u01a9\3\2\2\28\u01b3\3\2\2\2:\u01f8"+
		"\3\2\2\2<\u01fa\3\2\2\2>\u01fe\3\2\2\2@F\5\64\33\2AF\5\4\3\2BC\5\4\3\2"+
		"CD\5\66\34\2DF\3\2\2\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2F\3\3\2\2\2G[\5\6"+
		"\4\2H[\5\n\6\2IJ\7\3\2\2JK\5 \21\2KL\7\4\2\2LM\5 \21\2MN\7\5\2\2N[\3\2"+
		"\2\2OP\7\6\2\2PQ\5 \21\2QR\7\4\2\2RS\5 \21\2ST\7\5\2\2T[\3\2\2\2U[\5\b"+
		"\5\2V[\5\20\t\2W[\5\16\b\2X[\5\22\n\2Y[\5\f\7\2ZG\3\2\2\2ZH\3\2\2\2ZI"+
		"\3\2\2\2ZO\3\2\2\2ZU\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2["+
		"\5\3\2\2\2\\]\7\7\2\2]^\7,\2\2^_\7.\2\2_`\7\4\2\2`a\5 \21\2ab\7\5\2\2"+
		"b\u0091\3\2\2\2cd\7\7\2\2de\7,\2\2ef\7.\2\2fg\7\b\2\2gh\5 \21\2hi\7\t"+
		"\2\2i\u0091\3\2\2\2jk\7\7\2\2kl\7,\2\2lm\7\n\2\2mn\7.\2\2no\7\4\2\2op"+
		"\5 \21\2pq\7\5\2\2q\u0091\3\2\2\2rs\7\7\2\2st\7,\2\2tu\7\n\2\2uv\7.\2"+
		"\2vw\7\b\2\2wx\5 \21\2xy\7\t\2\2y\u0091\3\2\2\2z{\7\7\2\2{|\7,\2\2|}\7"+
		".\2\2}~\7\13\2\2~\177\5> \2\177\u0080\5&\24\2\u0080\u0081\7.\2\2\u0081"+
		"\u0082\7\4\2\2\u0082\u0083\5 \21\2\u0083\u0084\7\5\2\2\u0084\u0091\3\2"+
		"\2\2\u0085\u0086\7\7\2\2\u0086\u0087\7,\2\2\u0087\u0088\7.\2\2\u0088\u0089"+
		"\7\13\2\2\u0089\u008a\5> \2\u008a\u008b\5&\24\2\u008b\u008c\7.\2\2\u008c"+
		"\u008d\7\b\2\2\u008d\u008e\5 \21\2\u008e\u008f\7\t\2\2\u008f\u0091\3\2"+
		"\2\2\u0090\\\3\2\2\2\u0090c\3\2\2\2\u0090j\3\2\2\2\u0090r\3\2\2\2\u0090"+
		"z\3\2\2\2\u0090\u0085\3\2\2\2\u0091\7\3\2\2\2\u0092\u0093\7\f\2\2\u0093"+
		"\u0094\7,\2\2\u0094\u0095\7.\2\2\u0095\u0096\7\4\2\2\u0096\u0097\5\36"+
		"\20\2\u0097\u0098\7\5\2\2\u0098\u00c7\3\2\2\2\u0099\u009a\7\f\2\2\u009a"+
		"\u009b\7,\2\2\u009b\u009c\7.\2\2\u009c\u009d\7\b\2\2\u009d\u009e\5\36"+
		"\20\2\u009e\u009f\7\t\2\2\u009f\u00c7\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1"+
		"\u00a2\7,\2\2\u00a2\u00a3\7\n\2\2\u00a3\u00a4\7.\2\2\u00a4\u00a5\7\4\2"+
		"\2\u00a5\u00a6\5\36\20\2\u00a6\u00a7\7\5\2\2\u00a7\u00c7\3\2\2\2\u00a8"+
		"\u00a9\7\f\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ab\7\n\2\2\u00ab\u00ac\7.\2"+
		"\2\u00ac\u00ad\7\b\2\2\u00ad\u00ae\5\36\20\2\u00ae\u00af\7\t\2\2\u00af"+
		"\u00c7\3\2\2\2\u00b0\u00b1\7\f\2\2\u00b1\u00b2\7,\2\2\u00b2\u00b3\7.\2"+
		"\2\u00b3\u00b4\7\13\2\2\u00b4\u00b5\5> \2\u00b5\u00b6\5&\24\2\u00b6\u00b7"+
		"\7.\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5\36\20\2\u00b9\u00ba\7\5\2\2"+
		"\u00ba\u00c7\3\2\2\2\u00bb\u00bc\7\f\2\2\u00bc\u00bd\7,\2\2\u00bd\u00be"+
		"\7.\2\2\u00be\u00bf\7\13\2\2\u00bf\u00c0\5> \2\u00c0\u00c1\5&\24\2\u00c1"+
		"\u00c2\7.\2\2\u00c2\u00c3\7\b\2\2\u00c3\u00c4\5\36\20\2\u00c4\u00c5\7"+
		"\t\2\2\u00c5\u00c7\3\2\2\2\u00c6\u0092\3\2\2\2\u00c6\u0099\3\2\2\2\u00c6"+
		"\u00a0\3\2\2\2\u00c6\u00a8\3\2\2\2\u00c6\u00b0\3\2\2\2\u00c6\u00bb\3\2"+
		"\2\2\u00c7\t\3\2\2\2\u00c8\u00c9\7\r\2\2\u00c9\u00ca\7,\2\2\u00ca\u00cb"+
		"\7.\2\2\u00cb\u00cc\7\13\2\2\u00cc\u00cd\5> \2\u00cd\u00ce\7\16\2\2\u00ce"+
		"\u00df\3\2\2\2\u00cf\u00d0\7\r\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d2\7.\2"+
		"\2\u00d2\u00d3\7\13\2\2\u00d3\u00d4\5\32\16\2\u00d4\u00d5\7.\2\2\u00d5"+
		"\u00d6\7\16\2\2\u00d6\u00df\3\2\2\2\u00d7\u00d8\7\r\2\2\u00d8\u00d9\7"+
		",\2\2\u00d9\u00da\7.\2\2\u00da\u00db\7\13\2\2\u00db\u00dc\5\26\f\2\u00dc"+
		"\u00dd\7\16\2\2\u00dd\u00df\3\2\2\2\u00de\u00c8\3\2\2\2\u00de\u00cf\3"+
		"\2\2\2\u00de\u00d7\3\2\2\2\u00df\13\3\2\2\2\u00e0\u00e1\7,\2\2\u00e1\u00e2"+
		"\7\17\2\2\u00e2\u00e3\7\20\2\2\u00e3\u00e4\7.\2\2\u00e4\u00f0\5\22\n\2"+
		"\u00e5\u00e6\7\21\2\2\u00e6\u00e7\7,\2\2\u00e7\u00e8\7\17\2\2\u00e8\u00e9"+
		"\7\20\2\2\u00e9\u00ea\7.\2\2\u00ea\u00f0\5\22\n\2\u00eb\u00ec\7\21\2\2"+
		"\u00ec\u00ed\7,\2\2\u00ed\u00ee\7.\2\2\u00ee\u00f0\5\22\n\2\u00ef\u00e0"+
		"\3\2\2\2\u00ef\u00e5\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0\r\3\2\2\2\u00f1"+
		"\u00f2\7\17\2\2\u00f2\u00f3\5 \21\2\u00f3\u00f4\7\20\2\2\u00f4\17\3\2"+
		"\2\2\u00f5\u00f6\7\22\2\2\u00f6\u00f7\5 \21\2\u00f7\u00f8\7\23\2\2\u00f8"+
		"\u00f9\5 \21\2\u00f9\u00fa\7\24\2\2\u00fa\u010b\3\2\2\2\u00fb\u00fc\7"+
		"\22\2\2\u00fc\u00fd\5 \21\2\u00fd\u00fe\7\23\2\2\u00fe\u00ff\5 \21\2\u00ff"+
		"\u0100\7\25\2\2\u0100\u0101\5 \21\2\u0101\u0102\7\24\2\2\u0102\u010b\3"+
		"\2\2\2\u0103\u0104\7\22\2\2\u0104\u0105\5 \21\2\u0105\u0106\7\23\2\2\u0106"+
		"\u0107\5 \21\2\u0107\u0108\5\24\13\2\u0108\u0109\7\24\2\2\u0109\u010b"+
		"\3\2\2\2\u010a\u00f5\3\2\2\2\u010a\u00fb\3\2\2\2\u010a\u0103\3\2\2\2\u010b"+
		"\21\3\2\2\2\u010c\u010d\7\b\2\2\u010d\u010e\5\36\20\2\u010e\u010f\7\t"+
		"\2\2\u010f\23\3\2\2\2\u0110\u0111\7\26\2\2\u0111\u0112\5 \21\2\u0112\u0113"+
		"\7\23\2\2\u0113\u0114\5 \21\2\u0114\u0123\3\2\2\2\u0115\u0116\7\26\2\2"+
		"\u0116\u0117\5 \21\2\u0117\u0118\7\23\2\2\u0118\u0119\5 \21\2\u0119\u011a"+
		"\7\25\2\2\u011a\u011b\5 \21\2\u011b\u0123\3\2\2\2\u011c\u011d\7\26\2\2"+
		"\u011d\u011e\5 \21\2\u011e\u011f\7\23\2\2\u011f\u0120\5 \21\2\u0120\u0121"+
		"\5\24\13\2\u0121\u0123\3\2\2\2\u0122\u0110\3\2\2\2\u0122\u0115\3\2\2\2"+
		"\u0122\u011c\3\2\2\2\u0123\25\3\2\2\2\u0124\u0126\5\32\16\2\u0125\u0124"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\5\30\r\2"+
		"\u0128\27\3\2\2\2\u0129\u012a\7.\2\2\u012a\u012b\5\34\17\2\u012b\u012c"+
		"\7\20\2\2\u012c\u012d\5 \21\2\u012d\u0140\3\2\2\2\u012e\u012f\7.\2\2\u012f"+
		"\u0130\5\34\17\2\u0130\u0131\7\20\2\2\u0131\u0132\7.\2\2\u0132\u0140\3"+
		"\2\2\2\u0133\u0134\7.\2\2\u0134\u0135\7\17\2\2\u0135\u0136\5\34\17\2\u0136"+
		"\u0137\7\20\2\2\u0137\u0138\5 \21\2\u0138\u0140\3\2\2\2\u0139\u013a\7"+
		".\2\2\u013a\u013b\7\17\2\2\u013b\u013c\5\34\17\2\u013c\u013d\7\20\2\2"+
		"\u013d\u013e\7.\2\2\u013e\u0140\3\2\2\2\u013f\u0129\3\2\2\2\u013f\u012e"+
		"\3\2\2\2\u013f\u0133\3\2\2\2\u013f\u0139\3\2\2\2\u0140\31\3\2\2\2\u0141"+
		"\u0142\b\16\1\2\u0142\u0143\5\30\r\2\u0143\u0144\7\27\2\2\u0144\u014b"+
		"\3\2\2\2\u0145\u0146\f\3\2\2\u0146\u0147\5\30\r\2\u0147\u0148\7\27\2\2"+
		"\u0148\u014a\3\2\2\2\u0149\u0145\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\33\3\2\2\2\u014d\u014b\3\2\2\2\u014e"+
		"\u0153\7,\2\2\u014f\u0150\7\30\2\2\u0150\u0152\7,\2\2\u0151\u014f\3\2"+
		"\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\35\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7.\2\2\u0157\u0158\5\"\22"+
		"\2\u0158\37\3\2\2\2\u0159\u015d\5\36\20\2\u015a\u015b\7.\2\2\u015b\u015d"+
		"\5$\23\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015d!\3\2\2\2\u015e"+
		"\u015f\5$\23\2\u015f\u0160\t\2\2\2\u0160\u0161\7.\2\2\u0161#\3\2\2\2\u0162"+
		"\u0163\b\23\1\2\u0163\u0164\5,\27\2\u0164\u016b\3\2\2\2\u0165\u0166\f"+
		"\4\2\2\u0166\u0167\t\3\2\2\u0167\u0168\7.\2\2\u0168\u016a\5$\23\5\u0169"+
		"\u0165\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c%\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u016f\t\4\2\2\u016f\'\3"+
		"\2\2\2\u0170\u0172\5*\26\2\u0171\u0173\t\5\2\2\u0172\u0171\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173)\3\2\2\2\u0174\u0180\5,\27\2\u0175\u0176\7\33\2\2"+
		"\u0176\u017c\7.\2\2\u0177\u0178\7\34\2\2\u0178\u017c\7.\2\2\u0179\u017c"+
		"\7\32\2\2\u017a\u017c\7\n\2\2\u017b\u0175\3\2\2\2\u017b\u0177\3\2\2\2"+
		"\u017b\u0179\3\2\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f"+
		"\5,\27\2\u017e\u017b\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181+\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0192\5.\30\2"+
		"\u0184\u0185\7\35\2\2\u0185\u0192\5.\30\2\u0186\u0187\5\62\32\2\u0187"+
		"\u0188\5.\30\2\u0188\u0192\3\2\2\2\u0189\u018a\5\62\32\2\u018a\u018b\7"+
		"\35\2\2\u018b\u018c\5.\30\2\u018c\u0192\3\2\2\2\u018d\u018e\7\35\2\2\u018e"+
		"\u018f\5\62\32\2\u018f\u0190\5.\30\2\u0190\u0192\3\2\2\2\u0191\u0183\3"+
		"\2\2\2\u0191\u0184\3\2\2\2\u0191\u0186\3\2\2\2\u0191\u0189\3\2\2\2\u0191"+
		"\u018d\3\2\2\2\u0192-\3\2\2\2\u0193\u0199\5\2\2\2\u0194\u0195\7\30\2\2"+
		"\u0195\u0196\7.\2\2\u0196\u0198\5\2\2\2\u0197\u0194\3\2\2\2\u0198\u019b"+
		"\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a/\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019c\u019d\7\36\2\2\u019d\61\3\2\2\2\u019e\u01a0\7\37"+
		"\2\2\u019f\u01a1\5\60\31\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\63\3\2\2\2\u01a2\u01a6\58\35\2\u01a3\u01a5\58\35\2\u01a4\u01a3\3\2\2"+
		"\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\65"+
		"\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01ad\5:\36\2\u01aa\u01ac\5:\36\2\u01ab"+
		"\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2"+
		"\2\2\u01ae\67\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b4\7,\2\2\u01b1\u01b4"+
		"\5<\37\2\u01b2\u01b4\5:\36\2\u01b3\u01b0\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3"+
		"\u01b2\3\2\2\2\u01b49\3\2\2\2\u01b5\u01b6\7 \2\2\u01b6\u01f9\7,\2\2\u01b7"+
		"\u01b8\7!\2\2\u01b8\u01f9\7,\2\2\u01b9\u01ba\7-\2\2\u01ba\u01bb\7 \2\2"+
		"\u01bb\u01f9\7,\2\2\u01bc\u01bd\7-\2\2\u01bd\u01be\7!\2\2\u01be\u01f9"+
		"\7,\2\2\u01bf\u01c0\7\"\2\2\u01c0\u01f9\7,\2\2\u01c1\u01c2\7-\2\2\u01c2"+
		"\u01c3\7\"\2\2\u01c3\u01f9\7,\2\2\u01c4\u01c5\7#\2\2\u01c5\u01f9\7,\2"+
		"\2\u01c6\u01c7\7-\2\2\u01c7\u01c8\7#\2\2\u01c8\u01f9\7,\2\2\u01c9\u01ca"+
		"\7$\2\2\u01ca\u01f9\7-\2\2\u01cb\u01cc\7-\2\2\u01cc\u01cd\7$\2\2\u01cd"+
		"\u01f9\7-\2\2\u01ce\u01cf\7%\2\2\u01cf\u01f9\7-\2\2\u01d0\u01d1\7-\2\2"+
		"\u01d1\u01d2\7%\2\2\u01d2\u01f9\7-\2\2\u01d3\u01d4\7$\2\2\u01d4\u01f9"+
		"\7,\2\2\u01d5\u01d6\7-\2\2\u01d6\u01d7\7$\2\2\u01d7\u01f9\7,\2\2\u01d8"+
		"\u01d9\7%\2\2\u01d9\u01f9\7,\2\2\u01da\u01db\7-\2\2\u01db\u01dc\7%\2\2"+
		"\u01dc\u01f9\7,\2\2\u01dd\u01de\7&\2\2\u01de\u01f9\7,\2\2\u01df\u01e0"+
		"\7-\2\2\u01e0\u01e1\7&\2\2\u01e1\u01f9\7,\2\2\u01e2\u01e3\7%\2\2\u01e3"+
		"\u01f9\7\'\2\2\u01e4\u01e5\7-\2\2\u01e5\u01e6\7%\2\2\u01e6\u01f9\7\'\2"+
		"\2\u01e7\u01e8\7$\2\2\u01e8\u01f9\7\'\2\2\u01e9\u01ea\7-\2\2\u01ea\u01eb"+
		"\7$\2\2\u01eb\u01f9\7\'\2\2\u01ec\u01ed\7(\2\2\u01ed\u01f9\7,\2\2\u01ee"+
		"\u01ef\7-\2\2\u01ef\u01f0\7)\2\2\u01f0\u01f9\7,\2\2\u01f1\u01f2\7)\2\2"+
		"\u01f2\u01f9\7,\2\2\u01f3\u01f4\7*\2\2\u01f4\u01f9\7,\2\2\u01f5\u01f6"+
		"\7-\2\2\u01f6\u01f7\7*\2\2\u01f7\u01f9\7,\2\2\u01f8\u01b5\3\2\2\2\u01f8"+
		"\u01b7\3\2\2\2\u01f8\u01b9\3\2\2\2\u01f8\u01bc\3\2\2\2\u01f8\u01bf\3\2"+
		"\2\2\u01f8\u01c1\3\2\2\2\u01f8\u01c4\3\2\2\2\u01f8\u01c6\3\2\2\2\u01f8"+
		"\u01c9\3\2\2\2\u01f8\u01cb\3\2\2\2\u01f8\u01ce\3\2\2\2\u01f8\u01d0\3\2"+
		"\2\2\u01f8\u01d3\3\2\2\2\u01f8\u01d5\3\2\2\2\u01f8\u01d8\3\2\2\2\u01f8"+
		"\u01da\3\2\2\2\u01f8\u01dd\3\2\2\2\u01f8\u01df\3\2\2\2\u01f8\u01e2\3\2"+
		"\2\2\u01f8\u01e4\3\2\2\2\u01f8\u01e7\3\2\2\2\u01f8\u01e9\3\2\2\2\u01f8"+
		"\u01ec\3\2\2\2\u01f8\u01ee\3\2\2\2\u01f8\u01f1\3\2\2\2\u01f8\u01f3\3\2"+
		"\2\2\u01f8\u01f5\3\2\2\2\u01f9;\3\2\2\2\u01fa\u01fb\7,\2\2\u01fb\u01fc"+
		"\7+\2\2\u01fc\u01fd\7,\2\2\u01fd=\3\2\2\2\u01fe\u0202\7,\2\2\u01ff\u0201"+
		"\7,\2\2\u0200\u01ff\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202"+
		"\u0203\3\2\2\2\u0203?\3\2\2\2\u0204\u0202\3\2\2\2\33EZ\u0090\u00c6\u00de"+
		"\u00ef\u010a\u0122\u0125\u013f\u014b\u0153\u015c\u016b\u0172\u017b\u0180"+
		"\u0191\u0199\u01a0\u01a6\u01ad\u01b3\u01f8\u0202";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}