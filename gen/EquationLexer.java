// Generated from C:/projects/com.appanddata.calculation_engine/src/main/antlr4\Equation.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EquationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, IDENTIFIER=4, NEWLINE=5, INT_CONSTANT=6, FLOAT_CONSTANT=7, 
		PLUS_SIGN=8, MINUS_SIGN=9, DIVIDE_SIGN=10, MULTIPLY_SIGN=11, EQUALS_SIGN=12, 
		WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "IDENTIFIER", "NEWLINE", "INT_CONSTANT", "FLOAT_CONSTANT", 
			"PLUS_SIGN", "MINUS_SIGN", "DIVIDE_SIGN", "MULTIPLY_SIGN", "EQUALS_SIGN", 
			"WS", "DIGIT"
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


	public EquationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Equation.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17Z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\7\5)\n\5\f\5\16\5,\13\5\3\6\6\6/\n\6\r\6\16\6\60\3\6\3\6\3\7\6"+
		"\7\66\n\7\r\7\16\7\67\3\b\6\b;\n\b\r\b\16\b<\3\b\3\b\6\bA\n\b\r\b\16\b"+
		"B\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16P\n\16\r\16\16\16"+
		"Q\3\16\3\16\3\17\6\17W\n\17\r\17\16\17X\2\2\20\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\3\2\6\4\2C\\c|\3\2\f\f\4"+
		"\2\13\13\"\"\3\2\62;\2`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\37\3\2\2\2\5!\3\2\2"+
		"\2\7#\3\2\2\2\t%\3\2\2\2\13.\3\2\2\2\r\65\3\2\2\2\17:\3\2\2\2\21D\3\2"+
		"\2\2\23F\3\2\2\2\25H\3\2\2\2\27J\3\2\2\2\31L\3\2\2\2\33O\3\2\2\2\35V\3"+
		"\2\2\2\37 \7*\2\2 \4\3\2\2\2!\"\7+\2\2\"\6\3\2\2\2#$\7.\2\2$\b\3\2\2\2"+
		"%*\t\2\2\2&)\5\35\17\2\')\t\2\2\2(&\3\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2"+
		"\2\2*+\3\2\2\2+\n\3\2\2\2,*\3\2\2\2-/\t\3\2\2.-\3\2\2\2/\60\3\2\2\2\60"+
		".\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\b\6\2\2\63\f\3\2\2\2\64\66"+
		"\5\35\17\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\16\3"+
		"\2\2\29;\5\35\17\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>"+
		"@\7\60\2\2?A\5\35\17\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\20\3\2"+
		"\2\2DE\7-\2\2E\22\3\2\2\2FG\7/\2\2G\24\3\2\2\2HI\7\61\2\2I\26\3\2\2\2"+
		"JK\7,\2\2K\30\3\2\2\2LM\7?\2\2M\32\3\2\2\2NP\t\4\2\2ON\3\2\2\2PQ\3\2\2"+
		"\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\b\16\2\2T\34\3\2\2\2UW\t\5\2\2VU\3"+
		"\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\36\3\2\2\2\13\2(*\60\67<BQX\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}