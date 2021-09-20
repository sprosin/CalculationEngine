// Generated from C:/projects/com.appanddata.calculation_engine/src/main/antlr4\Equation.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EquationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, IDENTIFIER=4, NEWLINE=5, INT_CONSTANT=6, FLOAT_CONSTANT=7, 
		PLUS_SIGN=8, MINUS_SIGN=9, DIVIDE_SIGN=10, MULTIPLY_SIGN=11, EQUALS_SIGN=12, 
		WS=13;
	public static final int
		RULE_parse = 0, RULE_equation = 1, RULE_expr = 2, RULE_function = 3, RULE_variable = 4, 
		RULE_output_variable = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "equation", "expr", "function", "variable", "output_variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", null, null, null, null, "'+'", "'-'", "'/'", 
			"'*'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "IDENTIFIER", "NEWLINE", "INT_CONSTANT", "FLOAT_CONSTANT", 
			"PLUS_SIGN", "MINUS_SIGN", "DIVIDE_SIGN", "MULTIPLY_SIGN", "EQUALS_SIGN", 
			"WS"
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
	public String getGrammarFileName() { return "Equation.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EquationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EquationVisitor ) return ((EquationVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			equation();
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

	public static class EquationContext extends ParserRuleContext {
		public Output_variableContext output_variable() {
			return getRuleContext(Output_variableContext.class,0);
		}
		public TerminalNode EQUALS_SIGN() { return getToken(EquationParser.EQUALS_SIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EquationVisitor ) return ((EquationVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			output_variable();
			setState(15);
			match(EQUALS_SIGN);
			setState(16);
			expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode INT_CONSTANT() { return getToken(EquationParser.INT_CONSTANT, 0); }
		public TerminalNode FLOAT_CONSTANT() { return getToken(EquationParser.FLOAT_CONSTANT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode MINUS_SIGN() { return getToken(EquationParser.MINUS_SIGN, 0); }
		public TerminalNode MULTIPLY_SIGN() { return getToken(EquationParser.MULTIPLY_SIGN, 0); }
		public TerminalNode DIVIDE_SIGN() { return getToken(EquationParser.DIVIDE_SIGN, 0); }
		public TerminalNode PLUS_SIGN() { return getToken(EquationParser.PLUS_SIGN, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EquationVisitor ) return ((EquationVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(19);
				match(INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(20);
				match(FLOAT_CONSTANT);
				}
				break;
			case 3:
				{
				setState(21);
				match(T__0);
				setState(22);
				expr(0);
				setState(23);
				match(T__1);
				}
				break;
			case 4:
				{
				setState(25);
				function();
				}
				break;
			case 5:
				{
				setState(26);
				variable();
				}
				break;
			case 6:
				{
				setState(27);
				match(MINUS_SIGN);
				setState(28);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(37);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(31);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(32);
						_la = _input.LA(1);
						if ( !(_la==DIVIDE_SIGN || _la==MULTIPLY_SIGN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(33);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(34);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(35);
						_la = _input.LA(1);
						if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(36);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(41);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(EquationParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EquationVisitor ) return ((EquationVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(IDENTIFIER);
			setState(43);
			match(T__0);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IDENTIFIER) | (1L << INT_CONSTANT) | (1L << FLOAT_CONSTANT) | (1L << MINUS_SIGN))) != 0)) {
				{
				setState(44);
				expr(0);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(45);
					match(T__2);
					setState(46);
					expr(0);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(54);
			match(T__1);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(EquationParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EquationVisitor ) return ((EquationVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IDENTIFIER);
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

	public static class Output_variableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(EquationParser.IDENTIFIER, 0); }
		public Output_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).enterOutput_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EquationListener ) ((EquationListener)listener).exitOutput_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EquationVisitor ) return ((EquationVisitor<? extends T>)visitor).visitOutput_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Output_variableContext output_variable() throws RecognitionException {
		Output_variableContext _localctx = new Output_variableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_output_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IDENTIFIER);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17?\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4 \n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4"+
		"(\n\4\f\4\16\4+\13\4\3\5\3\5\3\5\3\5\3\5\7\5\62\n\5\f\5\16\5\65\13\5\5"+
		"\5\67\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\2\3\6\b\2\4\6\b\n\f\2\4\3\2\f\r"+
		"\3\2\n\13\2A\2\16\3\2\2\2\4\20\3\2\2\2\6\37\3\2\2\2\b,\3\2\2\2\n:\3\2"+
		"\2\2\f<\3\2\2\2\16\17\5\4\3\2\17\3\3\2\2\2\20\21\5\f\7\2\21\22\7\16\2"+
		"\2\22\23\5\6\4\2\23\5\3\2\2\2\24\25\b\4\1\2\25 \7\b\2\2\26 \7\t\2\2\27"+
		"\30\7\3\2\2\30\31\5\6\4\2\31\32\7\4\2\2\32 \3\2\2\2\33 \5\b\5\2\34 \5"+
		"\n\6\2\35\36\7\13\2\2\36 \5\6\4\3\37\24\3\2\2\2\37\26\3\2\2\2\37\27\3"+
		"\2\2\2\37\33\3\2\2\2\37\34\3\2\2\2\37\35\3\2\2\2 )\3\2\2\2!\"\f\n\2\2"+
		"\"#\t\2\2\2#(\5\6\4\13$%\f\t\2\2%&\t\3\2\2&(\5\6\4\n\'!\3\2\2\2\'$\3\2"+
		"\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\7\3\2\2\2+)\3\2\2\2,-\7\6\2\2-\66"+
		"\7\3\2\2.\63\5\6\4\2/\60\7\5\2\2\60\62\5\6\4\2\61/\3\2\2\2\62\65\3\2\2"+
		"\2\63\61\3\2\2\2\63\64\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\66.\3\2\2\2"+
		"\66\67\3\2\2\2\678\3\2\2\289\7\4\2\29\t\3\2\2\2:;\7\6\2\2;\13\3\2\2\2"+
		"<=\7\6\2\2=\r\3\2\2\2\7\37\')\63\66";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}