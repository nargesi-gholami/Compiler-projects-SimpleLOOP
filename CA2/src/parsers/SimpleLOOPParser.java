// Generated from C:/Users/98902/Desktop/UT Course Material_spring_spring_1401/Compiler/projects/P2-1/SimpleLOOP-Compiler/src/main/grammar\SimpleLOOP.g4 by ANTLR 4.10.1
package parsers;

     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.classDec.*;
     import main.ast.nodes.declaration.classDec.classMembersDec.*;
     import main.ast.nodes.declaration.variableDec.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.nodes.statement.set.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import main.ast.types.set.*;
     import main.ast.types.functionPointer.*;
     import main.ast.types.array.*;
     import java.util.*;
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLOOPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_BREAK=1, CLASS=2, PUBLIC=3, PRIVATE=4, INITIALIZE=5, NEW=6, SELF=7, 
		RETURN=8, VOID=9, DELETE=10, INCLUDE=11, ADD=12, MERGE=13, PRINT=14, IF=15, 
		ELSE=16, ELSIF=17, PLUS=18, MINUS=19, MULT=20, DIVIDE=21, INC=22, DEC=23, 
		EQUAL=24, GREATER_THAN=25, LESS_THAN=26, ARROW=27, BAR=28, AND=29, OR=30, 
		NOT=31, TIF=32, TELSE=33, TRUE=34, FALSE=35, NULL=36, BEGIN=37, END=38, 
		INT=39, BOOL=40, FPTR=41, SET=42, EACH=43, DO=44, ASSIGN=45, SHARP=46, 
		LPAR=47, RPAR=48, LBRACK=49, RBRACK=50, LBRACE=51, RBRACE=52, COMMA=53, 
		DOT=54, SEMICOLON=55, NEWLINE=56, INT_VALUE=57, IDENTIFIER=58, CLASS_IDENTIFIER=59, 
		COMMENT=60, MLCOMMENT=61, WS=62;
	public static final int
		RULE_simpleLOOP = 0, RULE_program = 1, RULE_constructor = 2, RULE_classDeclaration = 3, 
		RULE_field_decleration = 4, RULE_method = 5, RULE_methodBody = 6, RULE_methodArgsDec = 7, 
		RULE_argDec = 8, RULE_methodArgs = 9, RULE_body = 10, RULE_blockStatement = 11, 
		RULE_singleStatement = 12, RULE_addStatement = 13, RULE_mergeStatement = 14, 
		RULE_deleteStatement = 15, RULE_varDecStatement = 16, RULE_ifStatement = 17, 
		RULE_elsifStatement = 18, RULE_condition = 19, RULE_elseStatement = 20, 
		RULE_printStatement = 21, RULE_methodCallStmt = 22, RULE_returnStatement = 23, 
		RULE_assignmentStatement = 24, RULE_loopStatement = 25, RULE_expression = 26, 
		RULE_ternaryExpression = 27, RULE_orExpression = 28, RULE_andExpression = 29, 
		RULE_equalityExpression = 30, RULE_relationalExpression = 31, RULE_additiveExpression = 32, 
		RULE_multiplicativeExpression = 33, RULE_preUnaryExpression = 34, RULE_postUnaryExpression = 35, 
		RULE_accessExpression = 36, RULE_otherExpression = 37, RULE_setNew = 38, 
		RULE_value = 39, RULE_boolValue = 40, RULE_class_identifier = 41, RULE_identifier = 42, 
		RULE_type = 43, RULE_array_type = 44, RULE_fptr_type = 45, RULE_set_type = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"simpleLOOP", "program", "constructor", "classDeclaration", "field_decleration", 
			"method", "methodBody", "methodArgsDec", "argDec", "methodArgs", "body", 
			"blockStatement", "singleStatement", "addStatement", "mergeStatement", 
			"deleteStatement", "varDecStatement", "ifStatement", "elsifStatement", 
			"condition", "elseStatement", "printStatement", "methodCallStmt", "returnStatement", 
			"assignmentStatement", "loopStatement", "expression", "ternaryExpression", 
			"orExpression", "andExpression", "equalityExpression", "relationalExpression", 
			"additiveExpression", "multiplicativeExpression", "preUnaryExpression", 
			"postUnaryExpression", "accessExpression", "otherExpression", "setNew", 
			"value", "boolValue", "class_identifier", "identifier", "type", "array_type", 
			"fptr_type", "set_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'class'", "'public'", "'private'", "'initialize'", "'new'", 
			"'self'", "'return'", "'void'", "'delete'", "'include'", "'add'", "'merge'", 
			"'print'", "'if'", "'else'", "'elsif'", "'+'", "'-'", "'*'", "'/'", "'++'", 
			"'--'", "'=='", "'>'", "'<'", "'->'", "'|'", "'&&'", "'||'", "'!'", "'?'", 
			"':'", "'true'", "'false'", "'null'", "'=begin'", "'=end'", "'int'", 
			"'bool'", "'fptr'", "'Set'", "'each'", "'do'", "'='", "'#'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "','", "'.'", "';'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_BREAK", "CLASS", "PUBLIC", "PRIVATE", "INITIALIZE", "NEW", 
			"SELF", "RETURN", "VOID", "DELETE", "INCLUDE", "ADD", "MERGE", "PRINT", 
			"IF", "ELSE", "ELSIF", "PLUS", "MINUS", "MULT", "DIVIDE", "INC", "DEC", 
			"EQUAL", "GREATER_THAN", "LESS_THAN", "ARROW", "BAR", "AND", "OR", "NOT", 
			"TIF", "TELSE", "TRUE", "FALSE", "NULL", "BEGIN", "END", "INT", "BOOL", 
			"FPTR", "SET", "EACH", "DO", "ASSIGN", "SHARP", "LPAR", "RPAR", "LBRACK", 
			"RBRACK", "LBRACE", "RBRACE", "COMMA", "DOT", "SEMICOLON", "NEWLINE", 
			"INT_VALUE", "IDENTIFIER", "CLASS_IDENTIFIER", "COMMENT", "MLCOMMENT", 
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
	public String getGrammarFileName() { return "SimpleLOOP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLOOPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SimpleLOOPContext extends ParserRuleContext {
		public Program simpleLOOPProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(SimpleLOOPParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public SimpleLOOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLOOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSimpleLOOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSimpleLOOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSimpleLOOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleLOOPContext simpleLOOP() throws RecognitionException {
		SimpleLOOPContext _localctx = new SimpleLOOPContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simpleLOOP);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					match(NEWLINE);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(100);
			((SimpleLOOPContext)_localctx).p = program();
			((SimpleLOOPContext)_localctx).simpleLOOPProgram =  ((SimpleLOOPContext)_localctx).p.programRet;
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(102);
				match(NEWLINE);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
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

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public VarDecStatementContext v;
		public ClassDeclarationContext c;
		public List<VarDecStatementContext> varDecStatement() {
			return getRuleContexts(VarDecStatementContext.class);
		}
		public VarDecStatementContext varDecStatement(int i) {
			return getRuleContext(VarDecStatementContext.class,i);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

			        ((ProgramContext)_localctx).programRet =  new Program();
			        int line = 1;
			        _localctx.programRet.setLine(line);
			    
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FPTR) | (1L << SET) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				{
				setState(111);
				((ProgramContext)_localctx).v = varDecStatement();
				setState(113); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(112);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(115); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

				        for (VariableDeclaration varDec: ((ProgramContext)_localctx).v.varDecRet)
				            _localctx.programRet.addGlobalVariable(varDec);
				    
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(124);
				((ProgramContext)_localctx).c = classDeclaration();
				setState(126); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(125);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(128); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				_localctx.programRet.addClass(((ProgramContext)_localctx).c.ClassDecRet);
				}
				}
				setState(136);
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

	public static class ConstructorContext extends ParserRuleContext {
		public ConstructorDeclaration constructorRet;
		public Token init;
		public MethodArgsDecContext args;
		public MethodBodyContext b;
		public TerminalNode PUBLIC() { return getToken(SimpleLOOPParser.PUBLIC, 0); }
		public TerminalNode INITIALIZE() { return getToken(SimpleLOOPParser.INITIALIZE, 0); }
		public MethodArgsDecContext methodArgsDec() {
			return getRuleContext(MethodArgsDecContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(PUBLIC);
			setState(138);
			((ConstructorContext)_localctx).init = match(INITIALIZE);

			        ((ConstructorContext)_localctx).constructorRet =  new ConstructorDeclaration();
			        _localctx.constructorRet.setLine(((ConstructorContext)_localctx).init.getLine());
			     
			setState(140);
			((ConstructorContext)_localctx).args = methodArgsDec();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(141);
				match(NEWLINE);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.constructorRet.setArgs(((ConstructorContext)_localctx).args.ArgsDecRet); 
			setState(148);
			((ConstructorContext)_localctx).b = methodBody();

			        _localctx.constructorRet.setLocalVars(((ConstructorContext)_localctx).b.varDecmethodRet);
			        _localctx.constructorRet.setBody(((ConstructorContext)_localctx).b.methodBodyRet);
			     
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration ClassDecRet;
		public ArrayList<FieldDeclaration> fa;
		public ArrayList<MethodDeclaration> ma;
		public Token cn;
		public Class_identifierContext ci;
		public Class_identifierContext cip;
		public Field_declerationContext fd1;
		public Field_declerationContext fd2;
		public TerminalNode CLASS() { return getToken(SimpleLOOPParser.CLASS, 0); }
		public List<Class_identifierContext> class_identifier() {
			return getRuleContexts(Class_identifierContext.class);
		}
		public Class_identifierContext class_identifier(int i) {
			return getRuleContext(Class_identifierContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(SimpleLOOPParser.LESS_THAN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public TerminalNode LBRACE() { return getToken(SimpleLOOPParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLOOPParser.RBRACE, 0); }
		public List<Field_declerationContext> field_decleration() {
			return getRuleContexts(Field_declerationContext.class);
		}
		public Field_declerationContext field_decleration(int i) {
			return getRuleContext(Field_declerationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ClassDeclarationContext)_localctx).fa =  new ArrayList<>();
			setState(152);
			((ClassDeclarationContext)_localctx).cn = match(CLASS);
			setState(153);
			((ClassDeclarationContext)_localctx).ci = class_identifier();

			        ((ClassDeclarationContext)_localctx).ClassDecRet =  new ClassDeclaration(((ClassDeclarationContext)_localctx).ci.classIdentifierRet);
			        _localctx.ClassDecRet.setLine(((ClassDeclarationContext)_localctx).cn.getLine());
			    
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS_THAN) {
				{
				setState(155);
				match(LESS_THAN);
				setState(156);
				((ClassDeclarationContext)_localctx).cip = class_identifier();

				       _localctx.ClassDecRet.setParentClassName(((ClassDeclarationContext)_localctx).cip.classIdentifierRet);
				    
				}
			}

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(161);
				match(NEWLINE);
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				{
				setState(167);
				match(LBRACE);
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(168);
					match(NEWLINE);
					}
					}
					setState(171); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(173);
					((ClassDeclarationContext)_localctx).fd1 = field_decleration();
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(174);
						match(NEWLINE);
						}
						}
						setState(177); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );

					        if(((ClassDeclarationContext)_localctx).fd1.fieldDecRet != null) {
					            _localctx.ClassDecRet.addField(((ClassDeclarationContext)_localctx).fd1.fieldDecRet);
					        }
					        if(((ClassDeclarationContext)_localctx).fd1.methodDecRet != null) {
					            _localctx.ClassDecRet.addMethod(((ClassDeclarationContext)_localctx).fd1.methodDecRet);
					        }
					    
					}
					}
					setState(183); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PUBLIC || _la==PRIVATE );
				setState(185);
				match(RBRACE);
				}
				}
				break;
			case PUBLIC:
			case PRIVATE:
				{
				{
				setState(187);
				((ClassDeclarationContext)_localctx).fd2 = field_decleration();

				        if(((ClassDeclarationContext)_localctx).fd1.fieldDecRet != null) {
				             _localctx.ClassDecRet.addField(((ClassDeclarationContext)_localctx).fd1.fieldDecRet);
				        }
				        if(((ClassDeclarationContext)_localctx).fd1.methodDecRet != null) {
				             _localctx.ClassDecRet.addMethod(((ClassDeclarationContext)_localctx).fd1.methodDecRet);
				        }
				    
				}
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

	public static class Field_declerationContext extends ParserRuleContext {
		public FieldDeclaration fieldDecRet;
		public MethodDeclaration methodDecRet;
		public boolean isPrivate;
		public int line;
		public ArrayList<VariableDeclaration> varDec;
		public Token p;
		public VarDecStatementContext v;
		public MethodContext m;
		public ConstructorContext c;
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(SimpleLOOPParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(SimpleLOOPParser.PRIVATE, 0); }
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public Field_declerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterField_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitField_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitField_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declerationContext field_decleration() throws RecognitionException {
		Field_declerationContext _localctx = new Field_declerationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field_decleration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(192);
				((Field_declerationContext)_localctx).p = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PUBLIC || _la==PRIVATE) ) {
					((Field_declerationContext)_localctx).p = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				        ((Field_declerationContext)_localctx).isPrivate =  false;
				        if(((Field_declerationContext)_localctx).p.getText().equals("private")) ((Field_declerationContext)_localctx).isPrivate =  true;
				        ((Field_declerationContext)_localctx).line =  ((Field_declerationContext)_localctx).p.getLine();
				    
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(194);
					((Field_declerationContext)_localctx).v = varDecStatement();

					        ((Field_declerationContext)_localctx).varDec =  ((Field_declerationContext)_localctx).v.varDecRet;
					        ((Field_declerationContext)_localctx).fieldDecRet =  new FieldDeclaration(_localctx.varDec.get(0), _localctx.isPrivate);
					        _localctx.fieldDecRet.setLine(_localctx.line);
					     
					}
					break;
				case 2:
					{
					setState(197);
					((Field_declerationContext)_localctx).m = method();
					 ((Field_declerationContext)_localctx).methodDecRet =  ((Field_declerationContext)_localctx).m.methodRet; 
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(202);
				((Field_declerationContext)_localctx).c = constructor();
				 ((Field_declerationContext)_localctx).methodDecRet =  ((Field_declerationContext)_localctx).c.constructorRet; 
				}
				break;
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

	public static class MethodContext extends ParserRuleContext {
		public MethodDeclaration methodRet;
		public TypeContext t;
		public IdentifierContext i;
		public MethodArgsDecContext ma;
		public MethodBodyContext mb;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MethodArgsDecContext methodArgsDec() {
			return getRuleContext(MethodArgsDecContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SimpleLOOPParser.VOID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((MethodContext)_localctx).methodRet =  new MethodDeclaration(); 
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				setState(208);
				((MethodContext)_localctx).t = type();

				        _localctx.methodRet.setReturnType(((MethodContext)_localctx).t.typeRet);
				    
				}
				break;
			case VOID:
				{
				setState(211);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        _localctx.methodRet.setReturnType(new VoidType());
			    
			setState(215);
			((MethodContext)_localctx).i = identifier();

			        _localctx.methodRet.setMethodName(((MethodContext)_localctx).i.identifierRet);
			        _localctx.methodRet.setLine(((MethodContext)_localctx).i.identifierRet.getLine());
			    
			setState(217);
			((MethodContext)_localctx).ma = methodArgsDec();

			        _localctx.methodRet.setArgs(((MethodContext)_localctx).ma.ArgsDecRet);
			    
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(219);
				match(NEWLINE);
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			((MethodContext)_localctx).mb = methodBody();

			        _localctx.methodRet.setBody(((MethodContext)_localctx).mb.methodBodyRet);
			        _localctx.methodRet.setLocalVars(((MethodContext)_localctx).mb.varDecmethodRet);
			    
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

	public static class MethodBodyContext extends ParserRuleContext {
		public ArrayList<Statement> methodBodyRet;
		public ArrayList<VariableDeclaration> varDecmethodRet;
		public VarDecStatementContext v;
		public SingleStatementContext s;
		public TerminalNode LBRACE() { return getToken(SimpleLOOPParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLOOPParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public List<VarDecStatementContext> varDecStatement() {
			return getRuleContexts(VarDecStatementContext.class);
		}
		public VarDecStatementContext varDecStatement(int i) {
			return getRuleContext(VarDecStatementContext.class,i);
		}
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodBody);
		int _la;
		try {
			int _alt;
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{

				        ((MethodBodyContext)_localctx).methodBodyRet =  new ArrayList<>();
				        ((MethodBodyContext)_localctx).varDecmethodRet =  new ArrayList<>();
				    
				{
				setState(229);
				match(LBRACE);
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(230);
					match(NEWLINE);
					}
					}
					setState(233); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(235);
						((MethodBodyContext)_localctx).v = varDecStatement();
						 _localctx.varDecmethodRet.addAll(((MethodBodyContext)_localctx).v.varDecRet);
						setState(238); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(237);
							match(NEWLINE);
							}
							}
							setState(240); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << RETURN) | (1L << PRINT) | (1L << IF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
					{
					{
					setState(247);
					((MethodBodyContext)_localctx).s = singleStatement();
					_localctx.methodBodyRet.add(((MethodBodyContext)_localctx).s.statementRet);
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(249);
						match(NEWLINE);
						}
						}
						setState(252); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259);
				match(RBRACE);
				}
				}
				break;
			case SELF:
			case RETURN:
			case PRINT:
			case IF:
			case MINUS:
			case NOT:
			case TRUE:
			case FALSE:
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					{
					setState(260);
					((MethodBodyContext)_localctx).v = varDecStatement();
					 _localctx.varDecmethodRet.addAll(((MethodBodyContext)_localctx).v.varDecRet);
					}
					}
					break;
				case 2:
					{
					{
					setState(263);
					((MethodBodyContext)_localctx).s = singleStatement();
					}
					_localctx.methodBodyRet.add(((MethodBodyContext)_localctx).s.statementRet);
					}
					break;
				}
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

	public static class MethodArgsDecContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> ArgsDecRet;
		public ArgDecContext a1;
		public ArgDecContext a2;
		public ArgDecContext arg;
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public List<ArgDecContext> argDec() {
			return getRuleContexts(ArgDecContext.class);
		}
		public ArgDecContext argDec(int i) {
			return getRuleContext(ArgDecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLOOPParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLOOPParser.ASSIGN, i);
		}
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public MethodArgsDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgsDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodArgsDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodArgsDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodArgsDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgsDecContext methodArgsDec() throws RecognitionException {
		MethodArgsDecContext _localctx = new MethodArgsDecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodArgsDec);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((MethodArgsDecContext)_localctx).ArgsDecRet =  new ArrayList<>();
			setState(271);
			match(LPAR);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FPTR) | (1L << SET) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(272);
				((MethodArgsDecContext)_localctx).a1 = argDec();
				 _localctx.ArgsDecRet.add(((MethodArgsDecContext)_localctx).a1.argdecRet); 
				setState(285);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ASSIGN:
					{
					{
					setState(274);
					match(ASSIGN);
					setState(275);
					orExpression();
					}
					}
					break;
				case RPAR:
				case COMMA:
					{
					setState(282);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(276);
							match(COMMA);
							setState(277);
							((MethodArgsDecContext)_localctx).a2 = argDec();
							_localctx.ArgsDecRet.add(((MethodArgsDecContext)_localctx).a2.argdecRet);
							}
							} 
						}
						setState(284);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(287);
					match(COMMA);
					setState(288);
					((MethodArgsDecContext)_localctx).arg = argDec();
					_localctx.ArgsDecRet.add(((MethodArgsDecContext)_localctx).arg.argdecRet);
					setState(290);
					match(ASSIGN);
					setState(291);
					orExpression();
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(300);
			match(RPAR);
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

	public static class ArgDecContext extends ParserRuleContext {
		public VariableDeclaration argdecRet;
		public TypeContext t;
		public IdentifierContext i;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterArgDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitArgDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitArgDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgDecContext argDec() throws RecognitionException {
		ArgDecContext _localctx = new ArgDecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			((ArgDecContext)_localctx).t = type();
			setState(303);
			((ArgDecContext)_localctx).i = identifier();

			        ((ArgDecContext)_localctx).argdecRet =   new VariableDeclaration(((ArgDecContext)_localctx).i.identifierRet, ((ArgDecContext)_localctx).t.typeRet);
			        _localctx.argdecRet.setLine(((ArgDecContext)_localctx).i.identifierRet.getLine());
			    
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

	public static class MethodArgsContext extends ParserRuleContext {
		public ArrayList<Expression> methodArgDrc;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public MethodArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgsContext methodArgs() throws RecognitionException {
		MethodArgsContext _localctx = new MethodArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MethodArgsContext)_localctx).methodArgDrc =  new ArrayList<>();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(307);
				((MethodArgsContext)_localctx).e1 = expression();
				 _localctx.methodArgDrc.add(((MethodArgsContext)_localctx).e1.expressionRet);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(309);
					match(COMMA);
					setState(310);
					((MethodArgsContext)_localctx).e2 = expression();
					 _localctx.methodArgDrc.add(((MethodArgsContext)_localctx).e2.expressionRet);
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class BodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public BlockStatementContext b;
		public SingleStatementContext s;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(320);
				((BodyContext)_localctx).b = blockStatement();
				 ((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).b.blockStatementRet;
				}
				break;
			case NEWLINE:
				{
				{
				setState(324); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(323);
					match(NEWLINE);
					}
					}
					setState(326); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(328);
				((BodyContext)_localctx).s = singleStatement();
				((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).s.statementRet;
				}
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

	public static class BlockStatementContext extends ParserRuleContext {
		public BlockStmt blockStatementRet;
		public Token l;
		public SingleStatementContext s;
		public TerminalNode RBRACE() { return getToken(SimpleLOOPParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLOOPParser.LBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((BlockStatementContext)_localctx).blockStatementRet =  new BlockStmt();
			setState(334);
			((BlockStatementContext)_localctx).l = match(LBRACE);
			_localctx.blockStatementRet.setLine(((BlockStatementContext)_localctx).l.getLine());
			setState(337); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(336);
				match(NEWLINE);
				}
				}
				setState(339); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << RETURN) | (1L << PRINT) | (1L << IF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				{
				setState(341);
				((BlockStatementContext)_localctx).s = singleStatement();
				_localctx.blockStatementRet.addStatement(((BlockStatementContext)_localctx).s.statementRet);
				setState(344); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(343);
					match(NEWLINE);
					}
					}
					setState(346); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(353);
			match(RBRACE);
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

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement statementRet;
		public IfStatementContext i;
		public PrintStatementContext p;
		public MethodCallStmtContext m;
		public ReturnStatementContext r;
		public AssignmentStatementContext as;
		public LoopStatementContext ls;
		public AddStatementContext ads;
		public MergeStatementContext ms;
		public DeleteStatementContext ds;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public MethodCallStmtContext methodCallStmt() {
			return getRuleContext(MethodCallStmtContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public AddStatementContext addStatement() {
			return getRuleContext(AddStatementContext.class,0);
		}
		public MergeStatementContext mergeStatement() {
			return getRuleContext(MergeStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_singleStatement);
		try {
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				((SingleStatementContext)_localctx).i = ifStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).i.conditionRet;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				((SingleStatementContext)_localctx).p = printStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).p.printRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				((SingleStatementContext)_localctx).m = methodCallStmt();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).m.MethodcallRet; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
				((SingleStatementContext)_localctx).r = returnStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).r.returnRet; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(367);
				((SingleStatementContext)_localctx).as = assignmentStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).as.assignRet; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(370);
				((SingleStatementContext)_localctx).ls = loopStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).ls.eachRet; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(373);
				((SingleStatementContext)_localctx).ads = addStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).ads.setAddRet;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(376);
				((SingleStatementContext)_localctx).ms = mergeStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).ms.setMergeRet; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(379);
				((SingleStatementContext)_localctx).ds = deleteStatement();
				 ((SingleStatementContext)_localctx).statementRet =  ((SingleStatementContext)_localctx).ds.setDelRet; 
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

	public static class AddStatementContext extends ParserRuleContext {
		public SetAdd setAddRet;
		public ExpressionContext e1;
		public Token ad;
		public OrExpressionContext e2;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SimpleLOOPParser.ADD, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public AddStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAddStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAddStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAddStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddStatementContext addStatement() throws RecognitionException {
		AddStatementContext _localctx = new AddStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			((AddStatementContext)_localctx).e1 = expression();
			setState(385);
			match(DOT);
			setState(386);
			((AddStatementContext)_localctx).ad = match(ADD);
			setState(387);
			match(LPAR);
			setState(388);
			((AddStatementContext)_localctx).e2 = orExpression();
			setState(389);
			match(RPAR);

			        ((AddStatementContext)_localctx).setAddRet =  new SetAdd(((AddStatementContext)_localctx).e1.expressionRet, ((AddStatementContext)_localctx).e2.orExprRet);
			        _localctx.setAddRet.setLine(((AddStatementContext)_localctx).ad.getLine());
			    
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

	public static class MergeStatementContext extends ParserRuleContext {
		public SetMerge setMergeRet;
		public ArrayList<Expression> eArgs;
		public ExpressionContext e1;
		public Token m;
		public OrExpressionContext e2;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MERGE() { return getToken(SimpleLOOPParser.MERGE, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public MergeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mergeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMergeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMergeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMergeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MergeStatementContext mergeStatement() throws RecognitionException {
		MergeStatementContext _localctx = new MergeStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mergeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MergeStatementContext)_localctx).eArgs =  new ArrayList<>();
			setState(393);
			((MergeStatementContext)_localctx).e1 = expression();
			setState(394);
			match(DOT);
			setState(395);
			((MergeStatementContext)_localctx).m = match(MERGE);
			setState(396);
			match(LPAR);
			setState(397);
			((MergeStatementContext)_localctx).e2 = orExpression();
			_localctx.eArgs.add(((MergeStatementContext)_localctx).e2.orExprRet);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(399);
				match(COMMA);
				setState(400);
				orExpression();
				_localctx.eArgs.add(((MergeStatementContext)_localctx).e2.orExprRet);
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        ((MergeStatementContext)_localctx).setMergeRet =  new SetMerge(((MergeStatementContext)_localctx).e1.expressionRet, _localctx.eArgs);
			        _localctx.setMergeRet.setLine(((MergeStatementContext)_localctx).m.getLine());
			    
			setState(409);
			match(RPAR);
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

	public static class DeleteStatementContext extends ParserRuleContext {
		public SetDelete setDelRet;
		public ExpressionContext e1;
		public Token d;
		public OrExpressionContext e2;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SimpleLOOPParser.DELETE, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitDeleteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitDeleteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deleteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			((DeleteStatementContext)_localctx).e1 = expression();
			setState(412);
			match(DOT);
			setState(413);
			((DeleteStatementContext)_localctx).d = match(DELETE);
			setState(414);
			match(LPAR);
			setState(415);
			((DeleteStatementContext)_localctx).e2 = orExpression();
			setState(416);
			match(RPAR);

			        ((DeleteStatementContext)_localctx).setDelRet =  new SetDelete(((DeleteStatementContext)_localctx).e1.expressionRet, ((DeleteStatementContext)_localctx).e2.orExprRet);
			        _localctx.setDelRet.setLine(((DeleteStatementContext)_localctx).d.getLine());
			    
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

	public static class VarDecStatementContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> varDecRet;
		public Type tt;
		public TypeContext t;
		public IdentifierContext i;
		public IdentifierContext i2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public VarDecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterVarDecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitVarDecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitVarDecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecStatementContext varDecStatement() throws RecognitionException {
		VarDecStatementContext _localctx = new VarDecStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDecStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((VarDecStatementContext)_localctx).varDecRet =  new ArrayList<>();
			setState(420);
			((VarDecStatementContext)_localctx).t = type();
			setState(421);
			((VarDecStatementContext)_localctx).i = identifier();

			       ((VarDecStatementContext)_localctx).tt =  ((VarDecStatementContext)_localctx).t.typeRet;
			       VariableDeclaration v = new VariableDeclaration(((VarDecStatementContext)_localctx).i.identifierRet,((VarDecStatementContext)_localctx).t.typeRet);
			       v.setLine(((VarDecStatementContext)_localctx).i.identifierRet.getLine());
			       _localctx.varDecRet.add(v);
			    
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(423);
				match(COMMA);
				setState(424);
				((VarDecStatementContext)_localctx).i2 = identifier();

				        VariableDeclaration v1 = new VariableDeclaration(((VarDecStatementContext)_localctx).i2.identifierRet,_localctx.tt);
				        v1.setLine(((VarDecStatementContext)_localctx).i2.identifierRet.getLine());
				        _localctx.varDecRet.add(v1);
				    
				}
				}
				setState(431);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt conditionRet;
		public Token i;
		public ConditionContext c;
		public BodyContext b;
		public ElsifStatementContext e1;
		public ElseStatementContext e2;
		public TerminalNode IF() { return getToken(SimpleLOOPParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<ElsifStatementContext> elsifStatement() {
			return getRuleContexts(ElsifStatementContext.class);
		}
		public ElsifStatementContext elsifStatement(int i) {
			return getRuleContext(ElsifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			((IfStatementContext)_localctx).i = match(IF);
			setState(433);
			((IfStatementContext)_localctx).c = condition();
			setState(434);
			((IfStatementContext)_localctx).b = body();

			       ((IfStatementContext)_localctx).conditionRet =  new ConditionalStmt(((IfStatementContext)_localctx).c.condRet, ((IfStatementContext)_localctx).b.bodyRet);
			       _localctx.conditionRet.setLine(((IfStatementContext)_localctx).i.getLine());
			    
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(436);
					((IfStatementContext)_localctx).e1 = elsifStatement();
					_localctx.conditionRet.addElsif(((IfStatementContext)_localctx).e1.ElsifStmtRet);
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(444);
				((IfStatementContext)_localctx).e2 = elseStatement();
				_localctx.conditionRet.setElseBody(((IfStatementContext)_localctx).e2.elseRet);
				}
				break;
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

	public static class ElsifStatementContext extends ParserRuleContext {
		public ElsifStmt ElsifStmtRet;
		public Token ef;
		public ConditionContext c;
		public BodyContext b;
		public TerminalNode ELSIF() { return getToken(SimpleLOOPParser.ELSIF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ElsifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterElsifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitElsifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitElsifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsifStatementContext elsifStatement() throws RecognitionException {
		ElsifStatementContext _localctx = new ElsifStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elsifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(449);
				match(NEWLINE);
				}
				}
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(455);
			((ElsifStatementContext)_localctx).ef = match(ELSIF);
			setState(456);
			((ElsifStatementContext)_localctx).c = condition();
			setState(457);
			((ElsifStatementContext)_localctx).b = body();

			        ((ElsifStatementContext)_localctx).ElsifStmtRet =  new ElsifStmt(((ElsifStatementContext)_localctx).c.condRet, ((ElsifStatementContext)_localctx).b.bodyRet);
			        _localctx.ElsifStmtRet.setLine(((ElsifStatementContext)_localctx).ef.getLine());
			     
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

	public static class ConditionContext extends ParserRuleContext {
		public Expression condRet;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(460);
				match(LPAR);
				setState(461);
				((ConditionContext)_localctx).e1 = expression();
				setState(462);
				match(RPAR);
				}
				 ((ConditionContext)_localctx).condRet =  ((ConditionContext)_localctx).e1.expressionRet;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(466);
				((ConditionContext)_localctx).e2 = expression();
				 ((ConditionContext)_localctx).condRet =  ((ConditionContext)_localctx).e2.expressionRet;
				}
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

	public static class ElseStatementContext extends ParserRuleContext {
		public Statement elseRet;
		public BodyContext b;
		public TerminalNode ELSE() { return getToken(SimpleLOOPParser.ELSE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleLOOPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleLOOPParser.NEWLINE, i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(471);
				match(NEWLINE);
				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(477);
			match(ELSE);
			setState(478);
			((ElseStatementContext)_localctx).b = body();
			 ((ElseStatementContext)_localctx).elseRet =  ((ElseStatementContext)_localctx).b.bodyRet;
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

	public static class PrintStatementContext extends ParserRuleContext {
		public PrintStmt printRet;
		public Token p;
		public ExpressionContext e;
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode PRINT() { return getToken(SimpleLOOPParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			((PrintStatementContext)_localctx).p = match(PRINT);
			setState(482);
			match(LPAR);
			setState(483);
			((PrintStatementContext)_localctx).e = expression();
			setState(484);
			match(RPAR);

			        ((PrintStatementContext)_localctx).printRet =  new PrintStmt(((PrintStatementContext)_localctx).e.expressionRet);
			        _localctx.printRet.setLine(((PrintStatementContext)_localctx).p.getLine());
			    
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

	public static class MethodCallStmtContext extends ParserRuleContext {
		public MethodCallStmt MethodcallRet;
		public AccessExpressionContext ae;
		public Token lp;
		public MethodArgsContext m;
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public List<TerminalNode> DOT() { return getTokens(SimpleLOOPParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleLOOPParser.DOT, i);
		}
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public MethodArgsContext methodArgs() {
			return getRuleContext(MethodArgsContext.class,0);
		}
		public List<TerminalNode> INITIALIZE() { return getTokens(SimpleLOOPParser.INITIALIZE); }
		public TerminalNode INITIALIZE(int i) {
			return getToken(SimpleLOOPParser.INITIALIZE, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public MethodCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMethodCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMethodCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMethodCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallStmtContext methodCallStmt() throws RecognitionException {
		MethodCallStmtContext _localctx = new MethodCallStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_methodCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			((MethodCallStmtContext)_localctx).ae = accessExpression();
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(488);
				match(DOT);
				setState(491);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INITIALIZE:
					{
					setState(489);
					match(INITIALIZE);
					}
					break;
				case IDENTIFIER:
					{
					setState(490);
					identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(498);
			((MethodCallStmtContext)_localctx).lp = match(LPAR);
			setState(499);
			((MethodCallStmtContext)_localctx).m = methodArgs();

			       MethodCall mc = new MethodCall(((MethodCallStmtContext)_localctx).ae.accessExprRet, ((MethodCallStmtContext)_localctx).m.methodArgDrc);
			       mc.setLine(((MethodCallStmtContext)_localctx).lp.getLine());
			       ((MethodCallStmtContext)_localctx).MethodcallRet =  new MethodCallStmt(mc);
			       _localctx.MethodcallRet.setLine(((MethodCallStmtContext)_localctx).lp.getLine());
			    
			setState(501);
			match(RPAR);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt returnRet;
		public Token r;
		public ExpressionContext e;
		public TerminalNode RETURN() { return getToken(SimpleLOOPParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			((ReturnStatementContext)_localctx).r = match(RETURN);

			        ((ReturnStatementContext)_localctx).returnRet =  new ReturnStmt();
			        _localctx.returnRet.setLine(((ReturnStatementContext)_localctx).r.getLine());
			    
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(505);
				((ReturnStatementContext)_localctx).e = expression();
				_localctx.returnRet.setReturnedExpr(((ReturnStatementContext)_localctx).e.expressionRet); 
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

	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentStmt assignRet;
		public OrExpressionContext le;
		public Token as;
		public ExpressionContext re;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLOOPParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			((AssignmentStatementContext)_localctx).le = orExpression();
			setState(511);
			((AssignmentStatementContext)_localctx).as = match(ASSIGN);
			setState(512);
			((AssignmentStatementContext)_localctx).re = expression();

			        ((AssignmentStatementContext)_localctx).assignRet =  new AssignmentStmt(((AssignmentStatementContext)_localctx).le.orExprRet, ((AssignmentStatementContext)_localctx).re.expressionRet);
			        _localctx.assignRet.setLine(((AssignmentStatementContext)_localctx).as.getLine());
			    
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

	public static class LoopStatementContext extends ParserRuleContext {
		public EachStmt eachRet;
		public Expression List;
		public AccessExpressionContext ae;
		public ExpressionContext e;
		public Token each1;
		public IdentifierContext id;
		public BodyContext b;
		public List<TerminalNode> DOT() { return getTokens(SimpleLOOPParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleLOOPParser.DOT, i);
		}
		public TerminalNode DO() { return getToken(SimpleLOOPParser.DO, 0); }
		public List<TerminalNode> BAR() { return getTokens(SimpleLOOPParser.BAR); }
		public TerminalNode BAR(int i) {
			return getToken(SimpleLOOPParser.BAR, i);
		}
		public TerminalNode EACH() { return getToken(SimpleLOOPParser.EACH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				{
				setState(515);
				((LoopStatementContext)_localctx).ae = accessExpression();

				        ((LoopStatementContext)_localctx).List =  ((LoopStatementContext)_localctx).ae.accessExprRet;
				    
				}
				}
				break;
			case 2:
				{
				{
				setState(518);
				match(LPAR);
				setState(519);
				((LoopStatementContext)_localctx).e = expression();
				setState(520);
				match(DOT);
				setState(521);
				match(DOT);
				setState(522);
				expression();
				setState(523);
				match(RPAR);
				}

				        ((LoopStatementContext)_localctx).List =  ((LoopStatementContext)_localctx).e.expressionRet; //???
				    
				}
				break;
			}
			setState(529);
			match(DOT);
			setState(530);
			((LoopStatementContext)_localctx).each1 = match(EACH);
			setState(531);
			match(DO);
			setState(532);
			match(BAR);
			setState(533);
			((LoopStatementContext)_localctx).id = identifier();
			setState(534);
			match(BAR);
			setState(535);
			((LoopStatementContext)_localctx).b = body();

			        ((LoopStatementContext)_localctx).eachRet =  new EachStmt(((LoopStatementContext)_localctx).id.identifierRet, _localctx.List);
			        _localctx.eachRet.setLine(((LoopStatementContext)_localctx).each1.getLine());
			        _localctx.eachRet.setBody(((LoopStatementContext)_localctx).b.bodyRet);
			    
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

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public TernaryExpressionContext te;
		public Token ae;
		public ExpressionContext e;
		public Token inc;
		public OrExpressionContext oe;
		public TernaryExpressionContext ternaryExpression() {
			return getRuleContext(TernaryExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleLOOPParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INCLUDE() { return getToken(SimpleLOOPParser.INCLUDE, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			((ExpressionContext)_localctx).te = ternaryExpression();
			 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).te.terExprRet; 
			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(540);
				((ExpressionContext)_localctx).ae = match(ASSIGN);
				setState(541);
				((ExpressionContext)_localctx).e = expression();

				        ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).oe.orExprRet, ((ExpressionContext)_localctx).e.expressionRet, BinaryOperator.assign);
				        _localctx.expressionRet.setLine(((ExpressionContext)_localctx).ae.getLine());
				    
				}
			}

			setState(553);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(546);
				match(DOT);
				setState(547);
				((ExpressionContext)_localctx).inc = match(INCLUDE);
				setState(548);
				match(LPAR);
				setState(549);
				((ExpressionContext)_localctx).oe = orExpression();
				setState(550);
				match(RPAR);

				        ((ExpressionContext)_localctx).expressionRet =  new SetInclude(((ExpressionContext)_localctx).te.terExprRet, ((ExpressionContext)_localctx).oe.orExprRet);
				        _localctx.expressionRet.setLine(((ExpressionContext)_localctx).inc.getLine());
				    
				}
				break;
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

	public static class TernaryExpressionContext extends ParserRuleContext {
		public Expression terExprRet;
		public Expression e;
		public OrExpressionContext oe;
		public Token t;
		public TernaryExpressionContext t1;
		public TernaryExpressionContext t2;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode TELSE() { return getToken(SimpleLOOPParser.TELSE, 0); }
		public TerminalNode TIF() { return getToken(SimpleLOOPParser.TIF, 0); }
		public List<TernaryExpressionContext> ternaryExpression() {
			return getRuleContexts(TernaryExpressionContext.class);
		}
		public TernaryExpressionContext ternaryExpression(int i) {
			return getRuleContext(TernaryExpressionContext.class,i);
		}
		public TernaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryExpressionContext ternaryExpression() throws RecognitionException {
		TernaryExpressionContext _localctx = new TernaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ternaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			((TernaryExpressionContext)_localctx).oe = orExpression();
			((TernaryExpressionContext)_localctx).terExprRet =  ((TernaryExpressionContext)_localctx).oe.orExprRet;
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIF) {
				{
				setState(557);
				((TernaryExpressionContext)_localctx).t = match(TIF);
				setState(558);
				((TernaryExpressionContext)_localctx).t1 = ternaryExpression();
				setState(559);
				match(TELSE);
				setState(560);
				((TernaryExpressionContext)_localctx).t2 = ternaryExpression();

				        ((TernaryExpressionContext)_localctx).terExprRet =  new TernaryExpression(_localctx.terExprRet, ((TernaryExpressionContext)_localctx).t1.terExprRet, ((TernaryExpressionContext)_localctx).t2.terExprRet);
				        _localctx.terExprRet.setLine(((TernaryExpressionContext)_localctx).t.getLine());
				    
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

	public static class OrExpressionContext extends ParserRuleContext {
		public Expression orExprRet;
		public AndExpressionContext ae1;
		public Token or;
		public AndExpressionContext ae2;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SimpleLOOPParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SimpleLOOPParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			((OrExpressionContext)_localctx).ae1 = andExpression();
			 ((OrExpressionContext)_localctx).orExprRet =  ((OrExpressionContext)_localctx).ae1.andExprRet; 
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(567);
				((OrExpressionContext)_localctx).or = match(OR);
				setState(568);
				((OrExpressionContext)_localctx).ae2 = andExpression();

				        ((OrExpressionContext)_localctx).orExprRet =  new BinaryExpression(_localctx.orExprRet, ((OrExpressionContext)_localctx).ae2.andExprRet, BinaryOperator.or);
				        _localctx.orExprRet.setLine(((OrExpressionContext)_localctx).or.getLine());
				     
				}
				}
				setState(575);
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

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression andExprRet;
		public EqualityExpressionContext e1;
		public Token an;
		public EqualityExpressionContext e2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SimpleLOOPParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimpleLOOPParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			((AndExpressionContext)_localctx).e1 = equalityExpression();
			((AndExpressionContext)_localctx).andExprRet =  ((AndExpressionContext)_localctx).e1.equalExprRet; 
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(578);
				((AndExpressionContext)_localctx).an = match(AND);
				setState(579);
				((AndExpressionContext)_localctx).e2 = equalityExpression();

				       ((AndExpressionContext)_localctx).andExprRet =  new BinaryExpression(_localctx.andExprRet, ((AndExpressionContext)_localctx).e2.equalExprRet, BinaryOperator.and);
				       _localctx.andExprRet.setLine(((AndExpressionContext)_localctx).an.getLine());
				    
				}
				}
				setState(586);
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression equalExprRet;
		public RelationalExpressionContext r1;
		public Token e;
		public RelationalExpressionContext r2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(SimpleLOOPParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(SimpleLOOPParser.EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			((EqualityExpressionContext)_localctx).r1 = relationalExpression();
			 ((EqualityExpressionContext)_localctx).equalExprRet =  ((EqualityExpressionContext)_localctx).r1.relationExprRet; 
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL) {
				{
				{
				setState(589);
				((EqualityExpressionContext)_localctx).e = match(EQUAL);
				setState(590);
				((EqualityExpressionContext)_localctx).r2 = relationalExpression();

				        ((EqualityExpressionContext)_localctx).equalExprRet =  new BinaryExpression(_localctx.equalExprRet, ((EqualityExpressionContext)_localctx).r2.relationExprRet, BinaryOperator.eq);
				        _localctx.equalExprRet.setLine(((EqualityExpressionContext)_localctx).e.getLine());
				    
				}
				}
				setState(597);
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

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression relationExprRet;
		public BinaryOperator op;
		public int line;
		public AdditiveExpressionContext a1;
		public Token g;
		public Token l;
		public AdditiveExpressionContext a2;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(SimpleLOOPParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(SimpleLOOPParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(SimpleLOOPParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(SimpleLOOPParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			((RelationalExpressionContext)_localctx).a1 = additiveExpression();
			 ((RelationalExpressionContext)_localctx).relationExprRet =  ((RelationalExpressionContext)_localctx).a1.addExprRet; 
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				{
				setState(604);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(600);
					((RelationalExpressionContext)_localctx).g = match(GREATER_THAN);

					         ((RelationalExpressionContext)_localctx).op =  BinaryOperator.gt;
					         ((RelationalExpressionContext)_localctx).line =  ((RelationalExpressionContext)_localctx).g.getLine();
					     
					}
					break;
				case LESS_THAN:
					{
					setState(602);
					((RelationalExpressionContext)_localctx).l = match(LESS_THAN);

					         ((RelationalExpressionContext)_localctx).op =  BinaryOperator.lt;
					         ((RelationalExpressionContext)_localctx).line =  ((RelationalExpressionContext)_localctx).l.getLine();
					     
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(606);
				((RelationalExpressionContext)_localctx).a2 = additiveExpression();

				        ((RelationalExpressionContext)_localctx).relationExprRet =  new BinaryExpression(_localctx.relationExprRet, ((RelationalExpressionContext)_localctx).a2.addExprRet, _localctx.op);
				        _localctx.relationExprRet.setLine(_localctx.line);
				     
				}
				}
				setState(613);
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression addExprRet;
		public BinaryOperator op;
		public int line;
		public MultiplicativeExpressionContext m1;
		public Token p;
		public Token m;
		public MultiplicativeExpressionContext m2;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SimpleLOOPParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SimpleLOOPParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SimpleLOOPParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SimpleLOOPParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			((AdditiveExpressionContext)_localctx).m1 = multiplicativeExpression();
			((AdditiveExpressionContext)_localctx).addExprRet =  ((AdditiveExpressionContext)_localctx).m1.multExprRet;
			setState(627);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(620);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(616);
					((AdditiveExpressionContext)_localctx).p = match(PLUS);

					       ((AdditiveExpressionContext)_localctx).op =  BinaryOperator.add;
					       ((AdditiveExpressionContext)_localctx).line =  ((AdditiveExpressionContext)_localctx).p.getLine();
					    
					}
					break;
				case MINUS:
					{
					setState(618);
					((AdditiveExpressionContext)_localctx).m = match(MINUS);

					        ((AdditiveExpressionContext)_localctx).op =  BinaryOperator.sub;
					        ((AdditiveExpressionContext)_localctx).line =  ((AdditiveExpressionContext)_localctx).m.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(622);
				((AdditiveExpressionContext)_localctx).m2 = multiplicativeExpression();

				         ((AdditiveExpressionContext)_localctx).addExprRet =  new BinaryExpression(_localctx.addExprRet, ((AdditiveExpressionContext)_localctx).m2.multExprRet, _localctx.op);
				         _localctx.addExprRet.setLine(_localctx.line);
				     
				}
				}
				setState(629);
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

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression multExprRet;
		public BinaryOperator op;
		public int line;
		public PreUnaryExpressionContext p1;
		public Token m;
		public Token d;
		public PreUnaryExpressionContext p2;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(SimpleLOOPParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SimpleLOOPParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(SimpleLOOPParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(SimpleLOOPParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			((MultiplicativeExpressionContext)_localctx).p1 = preUnaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).multExprRet =  ((MultiplicativeExpressionContext)_localctx).p1.preUnaryExprRet; 
			setState(643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				{
				setState(636);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(632);
					((MultiplicativeExpressionContext)_localctx).m = match(MULT);

					        ((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.mult;
					        ((MultiplicativeExpressionContext)_localctx).line =  ((MultiplicativeExpressionContext)_localctx).m.getLine();
					    
					}
					break;
				case DIVIDE:
					{
					setState(634);
					((MultiplicativeExpressionContext)_localctx).d = match(DIVIDE);

					        ((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.div;
					        ((MultiplicativeExpressionContext)_localctx).line =  ((MultiplicativeExpressionContext)_localctx).d.getLine();
					    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(638);
				((MultiplicativeExpressionContext)_localctx).p2 = preUnaryExpression();

				        ((MultiplicativeExpressionContext)_localctx).multExprRet =  new BinaryExpression(_localctx.multExprRet, ((MultiplicativeExpressionContext)_localctx).p2.preUnaryExprRet, _localctx.op);
				        _localctx.multExprRet.setLine(_localctx.line);
				    
				}
				}
				setState(645);
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

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression preUnaryExprRet;
		public UnaryOperator op;
		public int line;
		public Token n;
		public Token m;
		public PreUnaryExpressionContext p1;
		public PostUnaryExpressionContext p2;
		public TerminalNode NOT() { return getToken(SimpleLOOPParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(SimpleLOOPParser.MINUS, 0); }
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public PostUnaryExpressionContext postUnaryExpression() {
			return getRuleContext(PostUnaryExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_preUnaryExpression);
		try {
			setState(658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(653);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(646);
					((PreUnaryExpressionContext)_localctx).n = match(NOT);

					        ((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.not;
					        ((PreUnaryExpressionContext)_localctx).line =  ((PreUnaryExpressionContext)_localctx).n.getLine();
					    
					}
					break;
				case MINUS:
					{
					setState(648);
					((PreUnaryExpressionContext)_localctx).m = match(MINUS);

					        ((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.minus;
					        ((PreUnaryExpressionContext)_localctx).line =  ((PreUnaryExpressionContext)_localctx).m.getLine();
					    
					setState(650);
					((PreUnaryExpressionContext)_localctx).p1 = preUnaryExpression();

					         ((PreUnaryExpressionContext)_localctx).preUnaryExprRet =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).p1.preUnaryExprRet, _localctx.op);
					         _localctx.preUnaryExprRet.setLine(_localctx.line);
					     
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SELF:
			case TRUE:
			case FALSE:
			case SET:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(655);
				((PreUnaryExpressionContext)_localctx).p2 = postUnaryExpression();
				 ((PreUnaryExpressionContext)_localctx).preUnaryExprRet =  ((PreUnaryExpressionContext)_localctx).p2.postUnaryExprRet; 
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

	public static class PostUnaryExpressionContext extends ParserRuleContext {
		public Expression postUnaryExprRet;
		public UnaryOperator op;
		public int line;
		public AccessExpressionContext ac;
		public Token i;
		public Token d;
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(SimpleLOOPParser.INC, 0); }
		public TerminalNode DEC() { return getToken(SimpleLOOPParser.DEC, 0); }
		public PostUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterPostUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitPostUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitPostUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostUnaryExpressionContext postUnaryExpression() throws RecognitionException {
		PostUnaryExpressionContext _localctx = new PostUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_postUnaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			((PostUnaryExpressionContext)_localctx).ac = accessExpression();
			 ((PostUnaryExpressionContext)_localctx).postUnaryExprRet =  ((PostUnaryExpressionContext)_localctx).ac.accessExprRet; 
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INC || _la==DEC) {
				{
				setState(666);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INC:
					{
					setState(662);
					((PostUnaryExpressionContext)_localctx).i = match(INC);

					        ((PostUnaryExpressionContext)_localctx).op =  UnaryOperator.postinc;
					        ((PostUnaryExpressionContext)_localctx).line =  ((PostUnaryExpressionContext)_localctx).i.getLine();
					     
					}
					break;
				case DEC:
					{
					setState(664);
					((PostUnaryExpressionContext)_localctx).d = match(DEC);

					        ((PostUnaryExpressionContext)_localctx).op =  UnaryOperator.postdec;
					        ((PostUnaryExpressionContext)_localctx).line =  ((PostUnaryExpressionContext)_localctx).d.getLine();
					     
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

				        ((PostUnaryExpressionContext)_localctx).postUnaryExprRet =  new UnaryExpression(_localctx.postUnaryExprRet, _localctx.op);
				        _localctx.postUnaryExprRet.setLine(_localctx.line);
				     
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

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression accessExprRet;
		public OtherExpressionContext oe;
		public Token l;
		public MethodArgsContext ma;
		public Token d;
		public IdentifierContext i1;
		public Token i2;
		public Token n;
		public IdentifierContext i;
		public ExpressionContext e;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SimpleLOOPParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleLOOPParser.DOT, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(SimpleLOOPParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(SimpleLOOPParser.RPAR, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(SimpleLOOPParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(SimpleLOOPParser.RBRACK, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(SimpleLOOPParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SimpleLOOPParser.LPAR, i);
		}
		public List<MethodArgsContext> methodArgs() {
			return getRuleContexts(MethodArgsContext.class);
		}
		public MethodArgsContext methodArgs(int i) {
			return getRuleContext(MethodArgsContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(SimpleLOOPParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(SimpleLOOPParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> INITIALIZE() { return getTokens(SimpleLOOPParser.INITIALIZE); }
		public TerminalNode INITIALIZE(int i) {
			return getToken(SimpleLOOPParser.INITIALIZE, i);
		}
		public List<TerminalNode> NEW() { return getTokens(SimpleLOOPParser.NEW); }
		public TerminalNode NEW(int i) {
			return getToken(SimpleLOOPParser.NEW, i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_accessExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			((AccessExpressionContext)_localctx).oe = otherExpression();
			((AccessExpressionContext)_localctx).accessExprRet =  ((AccessExpressionContext)_localctx).oe.otherExprRet;
			setState(695);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(693);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(673);
						((AccessExpressionContext)_localctx).l = match(LPAR);
						setState(674);
						((AccessExpressionContext)_localctx).ma = methodArgs();
						setState(675);
						match(RPAR);
						}

						        ((AccessExpressionContext)_localctx).accessExprRet =  new MethodCall(_localctx.accessExprRet, ((AccessExpressionContext)_localctx).ma.methodArgDrc);
						        _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).l.getLine());
						    
						}
						break;
					case DOT:
						{
						{
						setState(679);
						((AccessExpressionContext)_localctx).d = match(DOT);
						setState(691);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IDENTIFIER:
							{
							setState(680);
							((AccessExpressionContext)_localctx).i1 = identifier();

							       ((AccessExpressionContext)_localctx).accessExprRet =  new ObjectMemberAccess(_localctx.accessExprRet, ((AccessExpressionContext)_localctx).i1.identifierRet);
							       _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).d.getLine());
							    
							}
							break;
						case INITIALIZE:
							{
							setState(683);
							((AccessExpressionContext)_localctx).i2 = match(INITIALIZE);
							}
							break;
						case NEW:
							{
							setState(684);
							((AccessExpressionContext)_localctx).n = match(NEW);
							{
							setState(685);
							((AccessExpressionContext)_localctx).l = match(LPAR);
							setState(686);
							((AccessExpressionContext)_localctx).ma = methodArgs();
							setState(687);
							match(RPAR);
							}

							       ((AccessExpressionContext)_localctx).accessExprRet =  new NewClassInstance(new ClassType(((AccessExpressionContext)_localctx).oe.identifierRet1), ((AccessExpressionContext)_localctx).ma.methodArgDrc);
							       _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).n.getLine());
							    
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(697);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			setState(707);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(705);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DOT:
						{
						setState(698);
						((AccessExpressionContext)_localctx).d = match(DOT);
						{
						setState(699);
						((AccessExpressionContext)_localctx).i = identifier();
						}
						}
						break;
					case LBRACK:
						{
						{
						setState(700);
						((AccessExpressionContext)_localctx).l = match(LBRACK);
						setState(701);
						((AccessExpressionContext)_localctx).e = expression();
						setState(702);
						match(RBRACK);

						        ((AccessExpressionContext)_localctx).accessExprRet =  new ArrayAccessByIndex(_localctx.accessExprRet, ((AccessExpressionContext)_localctx).e.expressionRet);
						        _localctx.accessExprRet.setLine(((AccessExpressionContext)_localctx).l.getLine());
						    
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(709);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
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

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression otherExprRet;
		public Identifier identifierRet1;
		public Token se;
		public Class_identifierContext c;
		public ValueContext v;
		public IdentifierContext i;
		public SetNewContext s;
		public ExpressionContext e;
		public TerminalNode SELF() { return getToken(SimpleLOOPParser.SELF, 0); }
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SetNewContext setNew() {
			return getRuleContext(SetNewContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(SimpleLOOPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLOOPParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_otherExpression);
		try {
			setState(729);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELF:
				enterOuterAlt(_localctx, 1);
				{
				setState(710);
				((OtherExpressionContext)_localctx).se = match(SELF);
				((OtherExpressionContext)_localctx).otherExprRet =  new SelfClass(); _localctx.otherExprRet.setLine(((OtherExpressionContext)_localctx).se.getLine()); 
				}
				break;
			case CLASS_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(712);
				((OtherExpressionContext)_localctx).c = class_identifier();

				                                ((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).c.classIdentifierRet;
				                                ((OtherExpressionContext)_localctx).identifierRet1 =  ((OtherExpressionContext)_localctx).c.classIdentifierRet;
				                            
				}
				break;
			case TRUE:
			case FALSE:
			case INT_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(715);
				((OtherExpressionContext)_localctx).v = value();
				((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).v.valRet;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(718);
				((OtherExpressionContext)_localctx).i = identifier();
				((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).i.identifierRet;
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(721);
				((OtherExpressionContext)_localctx).s = setNew();
				((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).s.setNewRet;
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(724);
				match(LPAR);
				setState(725);
				((OtherExpressionContext)_localctx).e = expression();
				((OtherExpressionContext)_localctx).otherExprRet =  ((OtherExpressionContext)_localctx).e.expressionRet;
				setState(727);
				match(RPAR);
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

	public static class SetNewContext extends ParserRuleContext {
		public SetNew setNewRet;
		public ArrayList<Expression> exArray;
		public int line;
		public Token s;
		public OrExpressionContext ore1;
		public OrExpressionContext ore2;
		public TerminalNode DOT() { return getToken(SimpleLOOPParser.DOT, 0); }
		public TerminalNode NEW() { return getToken(SimpleLOOPParser.NEW, 0); }
		public List<TerminalNode> LPAR() { return getTokens(SimpleLOOPParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SimpleLOOPParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(SimpleLOOPParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(SimpleLOOPParser.RPAR, i);
		}
		public TerminalNode SET() { return getToken(SimpleLOOPParser.SET, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public SetNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setNew; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSetNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSetNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSetNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetNewContext setNew() throws RecognitionException {
		SetNewContext _localctx = new SetNewContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_setNew);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SetNewContext)_localctx).exArray =  new ArrayList<>();
			setState(732);
			((SetNewContext)_localctx).s = match(SET);
			((SetNewContext)_localctx).line =  ((SetNewContext)_localctx).s.getLine();
			setState(734);
			match(DOT);
			setState(735);
			match(NEW);
			setState(736);
			match(LPAR);
			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(737);
				match(LPAR);
				setState(738);
				((SetNewContext)_localctx).ore1 = orExpression();
				_localctx.exArray.add(((SetNewContext)_localctx).ore1.orExprRet);
				setState(746);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(740);
					match(COMMA);
					setState(741);
					((SetNewContext)_localctx).ore2 = orExpression();
					_localctx.exArray.add(((SetNewContext)_localctx).ore2.orExprRet);
					}
					}
					setState(748);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(749);
				match(RPAR);
				}
			}

			setState(753);
			match(RPAR);

			            ((SetNewContext)_localctx).setNewRet =  new SetNew(_localctx.exArray);
			            _localctx.setNewRet.setLine(_localctx.line);
			    
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

	public static class ValueContext extends ParserRuleContext {
		public Value valRet;
		public BoolValueContext bv;
		public Token iv;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode INT_VALUE() { return getToken(SimpleLOOPParser.INT_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_value);
		try {
			setState(761);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(756);
				((ValueContext)_localctx).bv = boolValue();
				((ValueContext)_localctx).valRet =  ((ValueContext)_localctx).bv.boolvalRet;
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(759);
				((ValueContext)_localctx).iv = match(INT_VALUE);
				((ValueContext)_localctx).valRet =  new IntValue(Integer.parseInt((((ValueContext)_localctx).iv!=null?((ValueContext)_localctx).iv.getText():null))); _localctx.valRet.setLine(((ValueContext)_localctx).iv.getLine());
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

	public static class BoolValueContext extends ParserRuleContext {
		public BoolValue boolvalRet;
		public Token t;
		public Token f;
		public TerminalNode TRUE() { return getToken(SimpleLOOPParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SimpleLOOPParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_boolValue);
		try {
			setState(767);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(763);
				((BoolValueContext)_localctx).t = match(TRUE);
				((BoolValueContext)_localctx).boolvalRet =  new BoolValue(true); _localctx.boolvalRet.setLine(((BoolValueContext)_localctx).t.getLine());
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(765);
				((BoolValueContext)_localctx).f = match(FALSE);
				((BoolValueContext)_localctx).boolvalRet =  new BoolValue(false); _localctx.boolvalRet.setLine(((BoolValueContext)_localctx).f.getLine());
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

	public static class Class_identifierContext extends ParserRuleContext {
		public Identifier classIdentifierRet;
		public Token i;
		public TerminalNode CLASS_IDENTIFIER() { return getToken(SimpleLOOPParser.CLASS_IDENTIFIER, 0); }
		public Class_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterClass_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitClass_identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitClass_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_identifierContext class_identifier() throws RecognitionException {
		Class_identifierContext _localctx = new Class_identifierContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_class_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			((Class_identifierContext)_localctx).i = match(CLASS_IDENTIFIER);

			        ((Class_identifierContext)_localctx).classIdentifierRet =  new Identifier(((Class_identifierContext)_localctx).i.getText());
			        _localctx.classIdentifierRet.setLine(((Class_identifierContext)_localctx).i.getLine());
			    
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

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier identifierRet;
		public Token i;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLOOPParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			((IdentifierContext)_localctx).i = match(IDENTIFIER);

			        ((IdentifierContext)_localctx).identifierRet =  new Identifier(((IdentifierContext)_localctx).i.getText());
			        _localctx.identifierRet.setLine(((IdentifierContext)_localctx).i.getLine());
			    
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

	public static class TypeContext extends ParserRuleContext {
		public Type typeRet;
		public Array_typeContext a;
		public Fptr_typeContext f;
		public Set_typeContext s;
		public Class_identifierContext ic;
		public TerminalNode INT() { return getToken(SimpleLOOPParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(SimpleLOOPParser.BOOL, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Fptr_typeContext fptr_type() {
			return getRuleContext(Fptr_typeContext.class,0);
		}
		public Set_typeContext set_type() {
			return getRuleContext(Set_typeContext.class,0);
		}
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(775);
				match(INT);
				((TypeContext)_localctx).typeRet =  new IntType();
				}
				break;
			case 2:
				{
				setState(777);
				match(BOOL);
				((TypeContext)_localctx).typeRet =  new BoolType();
				}
				break;
			case 3:
				{
				setState(779);
				((TypeContext)_localctx).a = array_type();
				((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).a.ArrRet;
				}
				break;
			case 4:
				{
				setState(782);
				((TypeContext)_localctx).f = fptr_type();
				((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).f.fptrRet;
				}
				break;
			case 5:
				{
				setState(785);
				((TypeContext)_localctx).s = set_type();
				((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).s.setRet;
				}
				break;
			case 6:
				{
				setState(788);
				((TypeContext)_localctx).ic = class_identifier();
				((TypeContext)_localctx).typeRet =  new ClassType(((TypeContext)_localctx).ic.classIdentifierRet);
				}
				break;
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

	public static class Array_typeContext extends ParserRuleContext {
		public ArrayType ArrRet;
		public Type atRet;
		public ArrayList<Expression> at;
		public Class_identifierContext i;
		public Token l;
		public ExpressionContext e;
		public TerminalNode INT() { return getToken(SimpleLOOPParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(SimpleLOOPParser.BOOL, 0); }
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public List<TerminalNode> RBRACK() { return getTokens(SimpleLOOPParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(SimpleLOOPParser.RBRACK, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(SimpleLOOPParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(SimpleLOOPParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitArray_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_array_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Array_typeContext)_localctx).at =  new ArrayList<>();
			setState(801);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(794);
				match(INT);
				((Array_typeContext)_localctx).atRet =  new IntType();
				}
				break;
			case BOOL:
				{
				setState(796);
				match(BOOL);
				((Array_typeContext)_localctx).atRet =  new BoolType();
				}
				break;
			case CLASS_IDENTIFIER:
				{
				setState(798);
				((Array_typeContext)_localctx).i = class_identifier();
				((Array_typeContext)_localctx).atRet =  new ClassType(((Array_typeContext)_localctx).i.classIdentifierRet);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(808); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(803);
				((Array_typeContext)_localctx).l = match(LBRACK);
				setState(804);
				((Array_typeContext)_localctx).e = expression();
				setState(805);
				match(RBRACK);

				        _localctx.at.add(((Array_typeContext)_localctx).e.expressionRet);
				    
				}
				}
				setState(810); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACK );

			        ((Array_typeContext)_localctx).ArrRet =  new ArrayType(_localctx.atRet, _localctx.at);
			    
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

	public static class Fptr_typeContext extends ParserRuleContext {
		public FptrType fptrRet;
		public Type ftRet;
		public ArrayList<Type> ft;
		public Token f;
		public TypeContext t;
		public TypeContext t1;
		public TypeContext t2;
		public TerminalNode LESS_THAN() { return getToken(SimpleLOOPParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(SimpleLOOPParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(SimpleLOOPParser.GREATER_THAN, 0); }
		public TerminalNode FPTR() { return getToken(SimpleLOOPParser.FPTR, 0); }
		public List<TerminalNode> VOID() { return getTokens(SimpleLOOPParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(SimpleLOOPParser.VOID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLOOPParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLOOPParser.COMMA, i);
		}
		public Fptr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterFptr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitFptr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitFptr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fptr_typeContext fptr_type() throws RecognitionException {
		Fptr_typeContext _localctx = new Fptr_typeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_fptr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((Fptr_typeContext)_localctx).ft =  new ArrayList<>();
			setState(815);
			((Fptr_typeContext)_localctx).f = match(FPTR);
			setState(816);
			match(LESS_THAN);
			setState(830);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(817);
				match(VOID);
				_localctx.ft.add(new VoidType());
				}
				break;
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				{
				setState(819);
				((Fptr_typeContext)_localctx).t = type();
				_localctx.ft.add(((Fptr_typeContext)_localctx).t.typeRet);
				setState(827);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(821);
					match(COMMA);
					setState(822);
					((Fptr_typeContext)_localctx).t1 = type();
					_localctx.ft.add(((Fptr_typeContext)_localctx).t1.typeRet);
					}
					}
					setState(829);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(832);
			match(ARROW);
			setState(838);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				setState(833);
				((Fptr_typeContext)_localctx).t2 = type();
				((Fptr_typeContext)_localctx).ftRet =  ((Fptr_typeContext)_localctx).t2.typeRet;
				}
				break;
			case VOID:
				{
				setState(836);
				match(VOID);
				((Fptr_typeContext)_localctx).ftRet =  new VoidType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(840);
			match(GREATER_THAN);
			((Fptr_typeContext)_localctx).fptrRet =  new FptrType(_localctx.ft, _localctx.ftRet);
			    
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

	public static class Set_typeContext extends ParserRuleContext {
		public SetType setRet;
		public Token s;
		public TerminalNode LESS_THAN() { return getToken(SimpleLOOPParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(SimpleLOOPParser.GREATER_THAN, 0); }
		public TerminalNode SET() { return getToken(SimpleLOOPParser.SET, 0); }
		public TerminalNode INT() { return getToken(SimpleLOOPParser.INT, 0); }
		public Set_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).enterSet_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLOOPListener ) ((SimpleLOOPListener)listener).exitSet_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLOOPVisitor ) return ((SimpleLOOPVisitor<? extends T>)visitor).visitSet_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_typeContext set_type() throws RecognitionException {
		Set_typeContext _localctx = new Set_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_set_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			((Set_typeContext)_localctx).s = match(SET);
			setState(844);
			match(LESS_THAN);
			{
			setState(845);
			match(INT);
			}
			setState(846);
			match(GREATER_THAN);
			 ((Set_typeContext)_localctx).setRet =  new SetType(); 
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
		"\u0004\u0001>\u0352\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0001\u0000\u0005\u0000`\b\u0000\n\u0000\f\u0000"+
		"c\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000h\b\u0000\n\u0000"+
		"\f\u0000k\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0004\u0001r\b\u0001\u000b\u0001\f\u0001s\u0001\u0001\u0001\u0001"+
		"\u0005\u0001x\b\u0001\n\u0001\f\u0001{\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001\u007f\b\u0001\u000b\u0001\f\u0001\u0080\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0085\b\u0001\n\u0001\f\u0001\u0088\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u008f\b\u0002"+
		"\n\u0002\f\u0002\u0092\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a0\b\u0003\u0001\u0003\u0005"+
		"\u0003\u00a3\b\u0003\n\u0003\f\u0003\u00a6\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003\u00aa\b\u0003\u000b\u0003\f\u0003\u00ab\u0001\u0003\u0001"+
		"\u0003\u0004\u0003\u00b0\b\u0003\u000b\u0003\f\u0003\u00b1\u0001\u0003"+
		"\u0001\u0003\u0004\u0003\u00b6\b\u0003\u000b\u0003\f\u0003\u00b7\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00bf"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00c9\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u00ce\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00d5\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00dd"+
		"\b\u0005\n\u0005\f\u0005\u00e0\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00e8\b\u0006\u000b\u0006"+
		"\f\u0006\u00e9\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00ef\b"+
		"\u0006\u000b\u0006\f\u0006\u00f0\u0005\u0006\u00f3\b\u0006\n\u0006\f\u0006"+
		"\u00f6\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00fb\b"+
		"\u0006\u000b\u0006\f\u0006\u00fc\u0005\u0006\u00ff\b\u0006\n\u0006\f\u0006"+
		"\u0102\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u010b\b\u0006\u0003\u0006\u010d\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0119"+
		"\b\u0007\n\u0007\f\u0007\u011c\t\u0007\u0003\u0007\u011e\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0126\b\u0007\n\u0007\f\u0007\u0129\t\u0007\u0003\u0007\u012b\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u013a\b\t\n\t"+
		"\f\t\u013d\t\t\u0003\t\u013f\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0004"+
		"\n\u0145\b\n\u000b\n\f\n\u0146\u0001\n\u0001\n\u0001\n\u0003\n\u014c\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u0152\b"+
		"\u000b\u000b\u000b\f\u000b\u0153\u0001\u000b\u0001\u000b\u0001\u000b\u0004"+
		"\u000b\u0159\b\u000b\u000b\u000b\f\u000b\u015a\u0005\u000b\u015d\b\u000b"+
		"\n\u000b\f\u000b\u0160\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u017f"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0194"+
		"\b\u000e\n\u000e\f\u000e\u0197\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u01ac\b\u0010"+
		"\n\u0010\f\u0010\u01af\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u01b8\b\u0011\n"+
		"\u0011\f\u0011\u01bb\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u01c0\b\u0011\u0001\u0012\u0005\u0012\u01c3\b\u0012\n\u0012\f\u0012"+
		"\u01c6\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01d6\b\u0013\u0001\u0014"+
		"\u0005\u0014\u01d9\b\u0014\n\u0014\f\u0014\u01dc\t\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u01ec\b\u0016\u0005\u0016\u01ee\b\u0016\n\u0016\f\u0016"+
		"\u01f1\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u01fd\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u0210\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0221\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u022a\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u0234\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0005\u001c\u023c\b\u001c\n\u001c\f\u001c\u023f"+
		"\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0005\u001d\u0247\b\u001d\n\u001d\f\u001d\u024a\t\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u0252\b\u001e\n\u001e\f\u001e\u0255\t\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u025d\b\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0262\b\u001f\n\u001f\f\u001f"+
		"\u0265\t\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u026d"+
		"\b \u0001 \u0001 \u0001 \u0005 \u0272\b \n \f \u0275\t \u0001!\u0001!"+
		"\u0001!\u0001!\u0001!\u0001!\u0003!\u027d\b!\u0001!\u0001!\u0001!\u0005"+
		"!\u0282\b!\n!\f!\u0285\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u028e\b\"\u0001\"\u0001\"\u0001\"\u0003\"\u0293\b\""+
		"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u029b\b#\u0001#\u0003"+
		"#\u029e\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u02b4\b$\u0005$\u02b6\b$\n$\f$\u02b9\t$\u0001$\u0001$"+
		"\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u02c2\b$\n$\f$\u02c5\t$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u02da"+
		"\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0005&\u02e9\b&\n&\f&\u02ec\t&\u0001&\u0001&\u0003"+
		"&\u02f0\b&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0003\'\u02fa\b\'\u0001(\u0001(\u0001(\u0001(\u0003(\u0300\b(\u0001"+
		")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0003+\u0318\b+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0003,\u0322\b,\u0001,\u0001,\u0001,\u0001,\u0001,\u0004,\u0329"+
		"\b,\u000b,\f,\u032a\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0005-\u033a\b-\n-\f-\u033d\t-\u0003"+
		"-\u033f\b-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u0347\b-\u0001"+
		"-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0000"+
		"\u0000/\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\\u0000\u0001\u0001"+
		"\u0000\u0003\u0004\u0382\u0000a\u0001\u0000\u0000\u0000\u0002n\u0001\u0000"+
		"\u0000\u0000\u0004\u0089\u0001\u0000\u0000\u0000\u0006\u0097\u0001\u0000"+
		"\u0000\u0000\b\u00cd\u0001\u0000\u0000\u0000\n\u00cf\u0001\u0000\u0000"+
		"\u0000\f\u010c\u0001\u0000\u0000\u0000\u000e\u010e\u0001\u0000\u0000\u0000"+
		"\u0010\u012e\u0001\u0000\u0000\u0000\u0012\u0132\u0001\u0000\u0000\u0000"+
		"\u0014\u014b\u0001\u0000\u0000\u0000\u0016\u014d\u0001\u0000\u0000\u0000"+
		"\u0018\u017e\u0001\u0000\u0000\u0000\u001a\u0180\u0001\u0000\u0000\u0000"+
		"\u001c\u0188\u0001\u0000\u0000\u0000\u001e\u019b\u0001\u0000\u0000\u0000"+
		" \u01a3\u0001\u0000\u0000\u0000\"\u01b0\u0001\u0000\u0000\u0000$\u01c4"+
		"\u0001\u0000\u0000\u0000&\u01d5\u0001\u0000\u0000\u0000(\u01da\u0001\u0000"+
		"\u0000\u0000*\u01e1\u0001\u0000\u0000\u0000,\u01e7\u0001\u0000\u0000\u0000"+
		".\u01f7\u0001\u0000\u0000\u00000\u01fe\u0001\u0000\u0000\u00002\u020f"+
		"\u0001\u0000\u0000\u00004\u021a\u0001\u0000\u0000\u00006\u022b\u0001\u0000"+
		"\u0000\u00008\u0235\u0001\u0000\u0000\u0000:\u0240\u0001\u0000\u0000\u0000"+
		"<\u024b\u0001\u0000\u0000\u0000>\u0256\u0001\u0000\u0000\u0000@\u0266"+
		"\u0001\u0000\u0000\u0000B\u0276\u0001\u0000\u0000\u0000D\u0292\u0001\u0000"+
		"\u0000\u0000F\u0294\u0001\u0000\u0000\u0000H\u029f\u0001\u0000\u0000\u0000"+
		"J\u02d9\u0001\u0000\u0000\u0000L\u02db\u0001\u0000\u0000\u0000N\u02f9"+
		"\u0001\u0000\u0000\u0000P\u02ff\u0001\u0000\u0000\u0000R\u0301\u0001\u0000"+
		"\u0000\u0000T\u0304\u0001\u0000\u0000\u0000V\u0317\u0001\u0000\u0000\u0000"+
		"X\u0319\u0001\u0000\u0000\u0000Z\u032e\u0001\u0000\u0000\u0000\\\u034b"+
		"\u0001\u0000\u0000\u0000^`\u00058\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0003\u0002"+
		"\u0001\u0000ei\u0006\u0000\uffff\uffff\u0000fh\u00058\u0000\u0000gf\u0001"+
		"\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000lm\u0005\u0000\u0000\u0001m\u0001\u0001\u0000\u0000\u0000ny\u0006"+
		"\u0001\uffff\uffff\u0000oq\u0003 \u0010\u0000pr\u00058\u0000\u0000qp\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0006\u0001\uffff"+
		"\uffff\u0000vx\u0001\u0000\u0000\u0000wo\u0001\u0000\u0000\u0000x{\u0001"+
		"\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z\u0086\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|~\u0003\u0006"+
		"\u0003\u0000}\u007f\u00058\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0006\u0001\uffff\uffff\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084"+
		"|\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0003"+
		"\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005\u0003\u0000\u0000\u008a\u008b\u0005\u0005\u0000\u0000\u008b\u008c"+
		"\u0006\u0002\uffff\uffff\u0000\u008c\u0090\u0003\u000e\u0007\u0000\u008d"+
		"\u008f\u00058\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0092"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0001\u0000\u0000\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0006\u0002\uffff\uffff\u0000\u0094"+
		"\u0095\u0003\f\u0006\u0000\u0095\u0096\u0006\u0002\uffff\uffff\u0000\u0096"+
		"\u0005\u0001\u0000\u0000\u0000\u0097\u0098\u0006\u0003\uffff\uffff\u0000"+
		"\u0098\u0099\u0005\u0002\u0000\u0000\u0099\u009a\u0003R)\u0000\u009a\u009f"+
		"\u0006\u0003\uffff\uffff\u0000\u009b\u009c\u0005\u001a\u0000\u0000\u009c"+
		"\u009d\u0003R)\u0000\u009d\u009e\u0006\u0003\uffff\uffff\u0000\u009e\u00a0"+
		"\u0001\u0000\u0000\u0000\u009f\u009b\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a4\u0001\u0000\u0000\u0000\u00a1\u00a3"+
		"\u00058\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00be\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a9\u00053\u0000\u0000\u00a8\u00aa\u00058\u0000"+
		"\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b5\u0001\u0000\u0000\u0000\u00ad\u00af\u0003\b\u0004\u0000"+
		"\u00ae\u00b0\u00058\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0006\u0003\uffff\uffff\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b5\u00ad\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u00054\u0000\u0000\u00ba"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bb\u00bc\u0003\b\u0004\u0000\u00bc\u00bd"+
		"\u0006\u0003\uffff\uffff\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be"+
		"\u00a7\u0001\u0000\u0000\u0000\u00be\u00bb\u0001\u0000\u0000\u0000\u00bf"+
		"\u0007\u0001\u0000\u0000\u0000\u00c0\u00c1\u0007\u0000\u0000\u0000\u00c1"+
		"\u00c8\u0006\u0004\uffff\uffff\u0000\u00c2\u00c3\u0003 \u0010\u0000\u00c3"+
		"\u00c4\u0006\u0004\uffff\uffff\u0000\u00c4\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0003\n\u0005\u0000\u00c6\u00c7\u0006\u0004\uffff\uffff\u0000"+
		"\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c5\u0001\u0000\u0000\u0000\u00c9\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0003\u0004\u0002\u0000\u00cb\u00cc\u0006\u0004\uffff\uffff"+
		"\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000\u00cd\u00c0\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00ce\t\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d4\u0006\u0005\uffff\uffff\u0000\u00d0\u00d1\u0003V+\u0000\u00d1"+
		"\u00d2\u0006\u0005\uffff\uffff\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d5\u0005\t\u0000\u0000\u00d4\u00d0\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0006\u0005\uffff\uffff\u0000\u00d7\u00d8\u0003T*\u0000\u00d8\u00d9"+
		"\u0006\u0005\uffff\uffff\u0000\u00d9\u00da\u0003\u000e\u0007\u0000\u00da"+
		"\u00de\u0006\u0005\uffff\uffff\u0000\u00db\u00dd\u00058\u0000\u0000\u00dc"+
		"\u00db\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0003\f\u0006\u0000\u00e2\u00e3\u0006\u0005\uffff\uffff\u0000\u00e3"+
		"\u000b\u0001\u0000\u0000\u0000\u00e4\u00e5\u0006\u0006\uffff\uffff\u0000"+
		"\u00e5\u00e7\u00053\u0000\u0000\u00e6\u00e8\u00058\u0000\u0000\u00e7\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00f4"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003 \u0010\u0000\u00ec\u00ee\u0006"+
		"\u0006\uffff\uffff\u0000\u00ed\u00ef\u00058\u0000\u0000\u00ee\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f2\u00eb\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f5\u0100\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0003\u0018\f\u0000\u00f8\u00fa\u0006\u0006"+
		"\uffff\uffff\u0000\u00f9\u00fb\u00058\u0000\u0000\u00fa\u00f9\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00ff\u0001\u0000"+
		"\u0000\u0000\u00fe\u00f7\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000"+
		"\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000"+
		"\u0000\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000"+
		"\u0000\u0000\u0103\u010d\u00054\u0000\u0000\u0104\u0105\u0003 \u0010\u0000"+
		"\u0105\u0106\u0006\u0006\uffff\uffff\u0000\u0106\u010b\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0003\u0018\f\u0000\u0108\u0109\u0006\u0006\uffff\uffff"+
		"\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0104\u0001\u0000\u0000"+
		"\u0000\u010a\u0107\u0001\u0000\u0000\u0000\u010b\u010d\u0001\u0000\u0000"+
		"\u0000\u010c\u00e4\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000"+
		"\u0000\u010d\r\u0001\u0000\u0000\u0000\u010e\u010f\u0006\u0007\uffff\uffff"+
		"\u0000\u010f\u012a\u0005/\u0000\u0000\u0110\u0111\u0003\u0010\b\u0000"+
		"\u0111\u011d\u0006\u0007\uffff\uffff\u0000\u0112\u0113\u0005-\u0000\u0000"+
		"\u0113\u011e\u00038\u001c\u0000\u0114\u0115\u00055\u0000\u0000\u0115\u0116"+
		"\u0003\u0010\b\u0000\u0116\u0117\u0006\u0007\uffff\uffff\u0000\u0117\u0119"+
		"\u0001\u0000\u0000\u0000\u0118\u0114\u0001\u0000\u0000\u0000\u0119\u011c"+
		"\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a"+
		"\u0001\u0000\u0000\u0000\u011d\u0112\u0001\u0000\u0000\u0000\u011d\u011a"+
		"\u0001\u0000\u0000\u0000\u011e\u0127\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u00055\u0000\u0000\u0120\u0121\u0003\u0010\b\u0000\u0121\u0122\u0006"+
		"\u0007\uffff\uffff\u0000\u0122\u0123\u0005-\u0000\u0000\u0123\u0124\u0003"+
		"8\u001c\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u011f\u0001\u0000"+
		"\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u012b\u0001\u0000"+
		"\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u0110\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u00050\u0000\u0000\u012d\u000f\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0003V+\u0000\u012f\u0130\u0003T*\u0000\u0130\u0131"+
		"\u0006\b\uffff\uffff\u0000\u0131\u0011\u0001\u0000\u0000\u0000\u0132\u013e"+
		"\u0006\t\uffff\uffff\u0000\u0133\u0134\u00034\u001a\u0000\u0134\u013b"+
		"\u0006\t\uffff\uffff\u0000\u0135\u0136\u00055\u0000\u0000\u0136\u0137"+
		"\u00034\u001a\u0000\u0137\u0138\u0006\t\uffff\uffff\u0000\u0138\u013a"+
		"\u0001\u0000\u0000\u0000\u0139\u0135\u0001\u0000\u0000\u0000\u013a\u013d"+
		"\u0001\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0001\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b"+
		"\u0001\u0000\u0000\u0000\u013e\u0133\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0001\u0000\u0000\u0000\u013f\u0013\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0003\u0016\u000b\u0000\u0141\u0142\u0006\n\uffff\uffff\u0000\u0142\u014c"+
		"\u0001\u0000\u0000\u0000\u0143\u0145\u00058\u0000\u0000\u0144\u0143\u0001"+
		"\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0144\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0148\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0003\u0018\f\u0000\u0149\u014a\u0006\n"+
		"\uffff\uffff\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0140\u0001"+
		"\u0000\u0000\u0000\u014b\u0144\u0001\u0000\u0000\u0000\u014c\u0015\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u0006\u000b\uffff\uffff\u0000\u014e\u014f"+
		"\u00053\u0000\u0000\u014f\u0151\u0006\u000b\uffff\uffff\u0000\u0150\u0152"+
		"\u00058\u0000\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001"+
		"\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001"+
		"\u0000\u0000\u0000\u0154\u015e\u0001\u0000\u0000\u0000\u0155\u0156\u0003"+
		"\u0018\f\u0000\u0156\u0158\u0006\u000b\uffff\uffff\u0000\u0157\u0159\u0005"+
		"8\u0000\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000"+
		"\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u0155\u0001\u0000"+
		"\u0000\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000"+
		"\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0161\u0001\u0000"+
		"\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0162\u00054\u0000"+
		"\u0000\u0162\u0017\u0001\u0000\u0000\u0000\u0163\u0164\u0003\"\u0011\u0000"+
		"\u0164\u0165\u0006\f\uffff\uffff\u0000\u0165\u017f\u0001\u0000\u0000\u0000"+
		"\u0166\u0167\u0003*\u0015\u0000\u0167\u0168\u0006\f\uffff\uffff\u0000"+
		"\u0168\u017f\u0001\u0000\u0000\u0000\u0169\u016a\u0003,\u0016\u0000\u016a"+
		"\u016b\u0006\f\uffff\uffff\u0000\u016b\u017f\u0001\u0000\u0000\u0000\u016c"+
		"\u016d\u0003.\u0017\u0000\u016d\u016e\u0006\f\uffff\uffff\u0000\u016e"+
		"\u017f\u0001\u0000\u0000\u0000\u016f\u0170\u00030\u0018\u0000\u0170\u0171"+
		"\u0006\f\uffff\uffff\u0000\u0171\u017f\u0001\u0000\u0000\u0000\u0172\u0173"+
		"\u00032\u0019\u0000\u0173\u0174\u0006\f\uffff\uffff\u0000\u0174\u017f"+
		"\u0001\u0000\u0000\u0000\u0175\u0176\u0003\u001a\r\u0000\u0176\u0177\u0006"+
		"\f\uffff\uffff\u0000\u0177\u017f\u0001\u0000\u0000\u0000\u0178\u0179\u0003"+
		"\u001c\u000e\u0000\u0179\u017a\u0006\f\uffff\uffff\u0000\u017a\u017f\u0001"+
		"\u0000\u0000\u0000\u017b\u017c\u0003\u001e\u000f\u0000\u017c\u017d\u0006"+
		"\f\uffff\uffff\u0000\u017d\u017f\u0001\u0000\u0000\u0000\u017e\u0163\u0001"+
		"\u0000\u0000\u0000\u017e\u0166\u0001\u0000\u0000\u0000\u017e\u0169\u0001"+
		"\u0000\u0000\u0000\u017e\u016c\u0001\u0000\u0000\u0000\u017e\u016f\u0001"+
		"\u0000\u0000\u0000\u017e\u0172\u0001\u0000\u0000\u0000\u017e\u0175\u0001"+
		"\u0000\u0000\u0000\u017e\u0178\u0001\u0000\u0000\u0000\u017e\u017b\u0001"+
		"\u0000\u0000\u0000\u017f\u0019\u0001\u0000\u0000\u0000\u0180\u0181\u0003"+
		"4\u001a\u0000\u0181\u0182\u00056\u0000\u0000\u0182\u0183\u0005\f\u0000"+
		"\u0000\u0183\u0184\u0005/\u0000\u0000\u0184\u0185\u00038\u001c\u0000\u0185"+
		"\u0186\u00050\u0000\u0000\u0186\u0187\u0006\r\uffff\uffff\u0000\u0187"+
		"\u001b\u0001\u0000\u0000\u0000\u0188\u0189\u0006\u000e\uffff\uffff\u0000"+
		"\u0189\u018a\u00034\u001a\u0000\u018a\u018b\u00056\u0000\u0000\u018b\u018c"+
		"\u0005\r\u0000\u0000\u018c\u018d\u0005/\u0000\u0000\u018d\u018e\u0003"+
		"8\u001c\u0000\u018e\u0195\u0006\u000e\uffff\uffff\u0000\u018f\u0190\u0005"+
		"5\u0000\u0000\u0190\u0191\u00038\u001c\u0000\u0191\u0192\u0006\u000e\uffff"+
		"\uffff\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193\u018f\u0001\u0000"+
		"\u0000\u0000\u0194\u0197\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000"+
		"\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0198\u0001\u0000"+
		"\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0198\u0199\u0006\u000e"+
		"\uffff\uffff\u0000\u0199\u019a\u00050\u0000\u0000\u019a\u001d\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u00034\u001a\u0000\u019c\u019d\u00056\u0000\u0000"+
		"\u019d\u019e\u0005\n\u0000\u0000\u019e\u019f\u0005/\u0000\u0000\u019f"+
		"\u01a0\u00038\u001c\u0000\u01a0\u01a1\u00050\u0000\u0000\u01a1\u01a2\u0006"+
		"\u000f\uffff\uffff\u0000\u01a2\u001f\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0006\u0010\uffff\uffff\u0000\u01a4\u01a5\u0003V+\u0000\u01a5\u01a6\u0003"+
		"T*\u0000\u01a6\u01ad\u0006\u0010\uffff\uffff\u0000\u01a7\u01a8\u00055"+
		"\u0000\u0000\u01a8\u01a9\u0003T*\u0000\u01a9\u01aa\u0006\u0010\uffff\uffff"+
		"\u0000\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a7\u0001\u0000\u0000"+
		"\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae!\u0001\u0000\u0000\u0000"+
		"\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005\u000f\u0000\u0000"+
		"\u01b1\u01b2\u0003&\u0013\u0000\u01b2\u01b3\u0003\u0014\n\u0000\u01b3"+
		"\u01b9\u0006\u0011\uffff\uffff\u0000\u01b4\u01b5\u0003$\u0012\u0000\u01b5"+
		"\u01b6\u0006\u0011\uffff\uffff\u0000\u01b6\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b4\u0001\u0000\u0000\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000"+
		"\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000"+
		"\u01ba\u01bf\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bd\u0003(\u0014\u0000\u01bd\u01be\u0006\u0011\uffff\uffff\u0000"+
		"\u01be\u01c0\u0001\u0000\u0000\u0000\u01bf\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0#\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c3\u00058\u0000\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c6"+
		"\u0001\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c5"+
		"\u0001\u0000\u0000\u0000\u01c5\u01c7\u0001\u0000\u0000\u0000\u01c6\u01c4"+
		"\u0001\u0000\u0000\u0000\u01c7\u01c8\u0005\u0011\u0000\u0000\u01c8\u01c9"+
		"\u0003&\u0013\u0000\u01c9\u01ca\u0003\u0014\n\u0000\u01ca\u01cb\u0006"+
		"\u0012\uffff\uffff\u0000\u01cb%\u0001\u0000\u0000\u0000\u01cc\u01cd\u0005"+
		"/\u0000\u0000\u01cd\u01ce\u00034\u001a\u0000\u01ce\u01cf\u00050\u0000"+
		"\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d1\u0006\u0013\uffff"+
		"\uffff\u0000\u01d1\u01d6\u0001\u0000\u0000\u0000\u01d2\u01d3\u00034\u001a"+
		"\u0000\u01d3\u01d4\u0006\u0013\uffff\uffff\u0000\u01d4\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d5\u01cc\u0001\u0000\u0000\u0000\u01d5\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d6\'\u0001\u0000\u0000\u0000\u01d7\u01d9\u00058\u0000"+
		"\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d9\u01dc\u0001\u0000\u0000"+
		"\u0000\u01da\u01d8\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000"+
		"\u0000\u01db\u01dd\u0001\u0000\u0000\u0000\u01dc\u01da\u0001\u0000\u0000"+
		"\u0000\u01dd\u01de\u0005\u0010\u0000\u0000\u01de\u01df\u0003\u0014\n\u0000"+
		"\u01df\u01e0\u0006\u0014\uffff\uffff\u0000\u01e0)\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e2\u0005\u000e\u0000\u0000\u01e2\u01e3\u0005/\u0000\u0000\u01e3"+
		"\u01e4\u00034\u001a\u0000\u01e4\u01e5\u00050\u0000\u0000\u01e5\u01e6\u0006"+
		"\u0015\uffff\uffff\u0000\u01e6+\u0001\u0000\u0000\u0000\u01e7\u01ef\u0003"+
		"H$\u0000\u01e8\u01eb\u00056\u0000\u0000\u01e9\u01ec\u0005\u0005\u0000"+
		"\u0000\u01ea\u01ec\u0003T*\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000\u01eb"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ee\u0001\u0000\u0000\u0000\u01ed"+
		"\u01e8\u0001\u0000\u0000\u0000\u01ee\u01f1\u0001\u0000\u0000\u0000\u01ef"+
		"\u01ed\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f2\u0001\u0000\u0000\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f2"+
		"\u01f3\u0005/\u0000\u0000\u01f3\u01f4\u0003\u0012\t\u0000\u01f4\u01f5"+
		"\u0006\u0016\uffff\uffff\u0000\u01f5\u01f6\u00050\u0000\u0000\u01f6-\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f8\u0005\b\u0000\u0000\u01f8\u01fc\u0006\u0017"+
		"\uffff\uffff\u0000\u01f9\u01fa\u00034\u001a\u0000\u01fa\u01fb\u0006\u0017"+
		"\uffff\uffff\u0000\u01fb\u01fd\u0001\u0000\u0000\u0000\u01fc\u01f9\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd/\u0001\u0000"+
		"\u0000\u0000\u01fe\u01ff\u00038\u001c\u0000\u01ff\u0200\u0005-\u0000\u0000"+
		"\u0200\u0201\u00034\u001a\u0000\u0201\u0202\u0006\u0018\uffff\uffff\u0000"+
		"\u02021\u0001\u0000\u0000\u0000\u0203\u0204\u0003H$\u0000\u0204\u0205"+
		"\u0006\u0019\uffff\uffff\u0000\u0205\u0210\u0001\u0000\u0000\u0000\u0206"+
		"\u0207\u0005/\u0000\u0000\u0207\u0208\u00034\u001a\u0000\u0208\u0209\u0005"+
		"6\u0000\u0000\u0209\u020a\u00056\u0000\u0000\u020a\u020b\u00034\u001a"+
		"\u0000\u020b\u020c\u00050\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000"+
		"\u020d\u020e\u0006\u0019\uffff\uffff\u0000\u020e\u0210\u0001\u0000\u0000"+
		"\u0000\u020f\u0203\u0001\u0000\u0000\u0000\u020f\u0206\u0001\u0000\u0000"+
		"\u0000\u0210\u0211\u0001\u0000\u0000\u0000\u0211\u0212\u00056\u0000\u0000"+
		"\u0212\u0213\u0005+\u0000\u0000\u0213\u0214\u0005,\u0000\u0000\u0214\u0215"+
		"\u0005\u001c\u0000\u0000\u0215\u0216\u0003T*\u0000\u0216\u0217\u0005\u001c"+
		"\u0000\u0000\u0217\u0218\u0003\u0014\n\u0000\u0218\u0219\u0006\u0019\uffff"+
		"\uffff\u0000\u02193\u0001\u0000\u0000\u0000\u021a\u021b\u00036\u001b\u0000"+
		"\u021b\u0220\u0006\u001a\uffff\uffff\u0000\u021c\u021d\u0005-\u0000\u0000"+
		"\u021d\u021e\u00034\u001a\u0000\u021e\u021f\u0006\u001a\uffff\uffff\u0000"+
		"\u021f\u0221\u0001\u0000\u0000\u0000\u0220\u021c\u0001\u0000\u0000\u0000"+
		"\u0220\u0221\u0001\u0000\u0000\u0000\u0221\u0229\u0001\u0000\u0000\u0000"+
		"\u0222\u0223\u00056\u0000\u0000\u0223\u0224\u0005\u000b\u0000\u0000\u0224"+
		"\u0225\u0005/\u0000\u0000\u0225\u0226\u00038\u001c\u0000\u0226\u0227\u0005"+
		"0\u0000\u0000\u0227\u0228\u0006\u001a\uffff\uffff\u0000\u0228\u022a\u0001"+
		"\u0000\u0000\u0000\u0229\u0222\u0001\u0000\u0000\u0000\u0229\u022a\u0001"+
		"\u0000\u0000\u0000\u022a5\u0001\u0000\u0000\u0000\u022b\u022c\u00038\u001c"+
		"\u0000\u022c\u0233\u0006\u001b\uffff\uffff\u0000\u022d\u022e\u0005 \u0000"+
		"\u0000\u022e\u022f\u00036\u001b\u0000\u022f\u0230\u0005!\u0000\u0000\u0230"+
		"\u0231\u00036\u001b\u0000\u0231\u0232\u0006\u001b\uffff\uffff\u0000\u0232"+
		"\u0234\u0001\u0000\u0000\u0000\u0233\u022d\u0001\u0000\u0000\u0000\u0233"+
		"\u0234\u0001\u0000\u0000\u0000\u02347\u0001\u0000\u0000\u0000\u0235\u0236"+
		"\u0003:\u001d\u0000\u0236\u023d\u0006\u001c\uffff\uffff\u0000\u0237\u0238"+
		"\u0005\u001e\u0000\u0000\u0238\u0239\u0003:\u001d\u0000\u0239\u023a\u0006"+
		"\u001c\uffff\uffff\u0000\u023a\u023c\u0001\u0000\u0000\u0000\u023b\u0237"+
		"\u0001\u0000\u0000\u0000\u023c\u023f\u0001\u0000\u0000\u0000\u023d\u023b"+
		"\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000\u023e9\u0001"+
		"\u0000\u0000\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u0240\u0241\u0003"+
		"<\u001e\u0000\u0241\u0248\u0006\u001d\uffff\uffff\u0000\u0242\u0243\u0005"+
		"\u001d\u0000\u0000\u0243\u0244\u0003<\u001e\u0000\u0244\u0245\u0006\u001d"+
		"\uffff\uffff\u0000\u0245\u0247\u0001\u0000\u0000\u0000\u0246\u0242\u0001"+
		"\u0000\u0000\u0000\u0247\u024a\u0001\u0000\u0000\u0000\u0248\u0246\u0001"+
		"\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249;\u0001\u0000"+
		"\u0000\u0000\u024a\u0248\u0001\u0000\u0000\u0000\u024b\u024c\u0003>\u001f"+
		"\u0000\u024c\u0253\u0006\u001e\uffff\uffff\u0000\u024d\u024e\u0005\u0018"+
		"\u0000\u0000\u024e\u024f\u0003>\u001f\u0000\u024f\u0250\u0006\u001e\uffff"+
		"\uffff\u0000\u0250\u0252\u0001\u0000\u0000\u0000\u0251\u024d\u0001\u0000"+
		"\u0000\u0000\u0252\u0255\u0001\u0000\u0000\u0000\u0253\u0251\u0001\u0000"+
		"\u0000\u0000\u0253\u0254\u0001\u0000\u0000\u0000\u0254=\u0001\u0000\u0000"+
		"\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0256\u0257\u0003@ \u0000\u0257"+
		"\u0263\u0006\u001f\uffff\uffff\u0000\u0258\u0259\u0005\u0019\u0000\u0000"+
		"\u0259\u025d\u0006\u001f\uffff\uffff\u0000\u025a\u025b\u0005\u001a\u0000"+
		"\u0000\u025b\u025d\u0006\u001f\uffff\uffff\u0000\u025c\u0258\u0001\u0000"+
		"\u0000\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u025e\u0001\u0000"+
		"\u0000\u0000\u025e\u025f\u0003@ \u0000\u025f\u0260\u0006\u001f\uffff\uffff"+
		"\u0000\u0260\u0262\u0001\u0000\u0000\u0000\u0261\u025c\u0001\u0000\u0000"+
		"\u0000\u0262\u0265\u0001\u0000\u0000\u0000\u0263\u0261\u0001\u0000\u0000"+
		"\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264?\u0001\u0000\u0000\u0000"+
		"\u0265\u0263\u0001\u0000\u0000\u0000\u0266\u0267\u0003B!\u0000\u0267\u0273"+
		"\u0006 \uffff\uffff\u0000\u0268\u0269\u0005\u0012\u0000\u0000\u0269\u026d"+
		"\u0006 \uffff\uffff\u0000\u026a\u026b\u0005\u0013\u0000\u0000\u026b\u026d"+
		"\u0006 \uffff\uffff\u0000\u026c\u0268\u0001\u0000\u0000\u0000\u026c\u026a"+
		"\u0001\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u026f"+
		"\u0003B!\u0000\u026f\u0270\u0006 \uffff\uffff\u0000\u0270\u0272\u0001"+
		"\u0000\u0000\u0000\u0271\u026c\u0001\u0000\u0000\u0000\u0272\u0275\u0001"+
		"\u0000\u0000\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0273\u0274\u0001"+
		"\u0000\u0000\u0000\u0274A\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000"+
		"\u0000\u0000\u0276\u0277\u0003D\"\u0000\u0277\u0283\u0006!\uffff\uffff"+
		"\u0000\u0278\u0279\u0005\u0014\u0000\u0000\u0279\u027d\u0006!\uffff\uffff"+
		"\u0000\u027a\u027b\u0005\u0015\u0000\u0000\u027b\u027d\u0006!\uffff\uffff"+
		"\u0000\u027c\u0278\u0001\u0000\u0000\u0000\u027c\u027a\u0001\u0000\u0000"+
		"\u0000\u027d\u027e\u0001\u0000\u0000\u0000\u027e\u027f\u0003D\"\u0000"+
		"\u027f\u0280\u0006!\uffff\uffff\u0000\u0280\u0282\u0001\u0000\u0000\u0000"+
		"\u0281\u027c\u0001\u0000\u0000\u0000\u0282\u0285\u0001\u0000\u0000\u0000"+
		"\u0283\u0281\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000"+
		"\u0284C\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0286"+
		"\u0287\u0005\u001f\u0000\u0000\u0287\u028e\u0006\"\uffff\uffff\u0000\u0288"+
		"\u0289\u0005\u0013\u0000\u0000\u0289\u028a\u0006\"\uffff\uffff\u0000\u028a"+
		"\u028b\u0003D\"\u0000\u028b\u028c\u0006\"\uffff\uffff\u0000\u028c\u028e"+
		"\u0001\u0000\u0000\u0000\u028d\u0286\u0001\u0000\u0000\u0000\u028d\u0288"+
		"\u0001\u0000\u0000\u0000\u028e\u0293\u0001\u0000\u0000\u0000\u028f\u0290"+
		"\u0003F#\u0000\u0290\u0291\u0006\"\uffff\uffff\u0000\u0291\u0293\u0001"+
		"\u0000\u0000\u0000\u0292\u028d\u0001\u0000\u0000\u0000\u0292\u028f\u0001"+
		"\u0000\u0000\u0000\u0293E\u0001\u0000\u0000\u0000\u0294\u0295\u0003H$"+
		"\u0000\u0295\u029d\u0006#\uffff\uffff\u0000\u0296\u0297\u0005\u0016\u0000"+
		"\u0000\u0297\u029b\u0006#\uffff\uffff\u0000\u0298\u0299\u0005\u0017\u0000"+
		"\u0000\u0299\u029b\u0006#\uffff\uffff\u0000\u029a\u0296\u0001\u0000\u0000"+
		"\u0000\u029a\u0298\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000"+
		"\u0000\u029c\u029e\u0006#\uffff\uffff\u0000\u029d\u029a\u0001\u0000\u0000"+
		"\u0000\u029d\u029e\u0001\u0000\u0000\u0000\u029eG\u0001\u0000\u0000\u0000"+
		"\u029f\u02a0\u0003J%\u0000\u02a0\u02b7\u0006$\uffff\uffff\u0000\u02a1"+
		"\u02a2\u0005/\u0000\u0000\u02a2\u02a3\u0003\u0012\t\u0000\u02a3\u02a4"+
		"\u00050\u0000\u0000\u02a4\u02a5\u0001\u0000\u0000\u0000\u02a5\u02a6\u0006"+
		"$\uffff\uffff\u0000\u02a6\u02b6\u0001\u0000\u0000\u0000\u02a7\u02b3\u0005"+
		"6\u0000\u0000\u02a8\u02a9\u0003T*\u0000\u02a9\u02aa\u0006$\uffff\uffff"+
		"\u0000\u02aa\u02b4\u0001\u0000\u0000\u0000\u02ab\u02b4\u0005\u0005\u0000"+
		"\u0000\u02ac\u02ad\u0005\u0006\u0000\u0000\u02ad\u02ae\u0005/\u0000\u0000"+
		"\u02ae\u02af\u0003\u0012\t\u0000\u02af\u02b0\u00050\u0000\u0000\u02b0"+
		"\u02b1\u0001\u0000\u0000\u0000\u02b1\u02b2\u0006$\uffff\uffff\u0000\u02b2"+
		"\u02b4\u0001\u0000\u0000\u0000\u02b3\u02a8\u0001\u0000\u0000\u0000\u02b3"+
		"\u02ab\u0001\u0000\u0000\u0000\u02b3\u02ac\u0001\u0000\u0000\u0000\u02b4"+
		"\u02b6\u0001\u0000\u0000\u0000\u02b5\u02a1\u0001\u0000\u0000\u0000\u02b5"+
		"\u02a7\u0001\u0000\u0000\u0000\u02b6\u02b9\u0001\u0000\u0000\u0000\u02b7"+
		"\u02b5\u0001\u0000\u0000\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8"+
		"\u02c3\u0001\u0000\u0000\u0000\u02b9\u02b7\u0001\u0000\u0000\u0000\u02ba"+
		"\u02bb\u00056\u0000\u0000\u02bb\u02c2\u0003T*\u0000\u02bc\u02bd\u0005"+
		"1\u0000\u0000\u02bd\u02be\u00034\u001a\u0000\u02be\u02bf\u00052\u0000"+
		"\u0000\u02bf\u02c0\u0006$\uffff\uffff\u0000\u02c0\u02c2\u0001\u0000\u0000"+
		"\u0000\u02c1\u02ba\u0001\u0000\u0000\u0000\u02c1\u02bc\u0001\u0000\u0000"+
		"\u0000\u02c2\u02c5\u0001\u0000\u0000\u0000\u02c3\u02c1\u0001\u0000\u0000"+
		"\u0000\u02c3\u02c4\u0001\u0000\u0000\u0000\u02c4I\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c3\u0001\u0000\u0000\u0000\u02c6\u02c7\u0005\u0007\u0000\u0000"+
		"\u02c7\u02da\u0006%\uffff\uffff\u0000\u02c8\u02c9\u0003R)\u0000\u02c9"+
		"\u02ca\u0006%\uffff\uffff\u0000\u02ca\u02da\u0001\u0000\u0000\u0000\u02cb"+
		"\u02cc\u0003N\'\u0000\u02cc\u02cd\u0006%\uffff\uffff\u0000\u02cd\u02da"+
		"\u0001\u0000\u0000\u0000\u02ce\u02cf\u0003T*\u0000\u02cf\u02d0\u0006%"+
		"\uffff\uffff\u0000\u02d0\u02da\u0001\u0000\u0000\u0000\u02d1\u02d2\u0003"+
		"L&\u0000\u02d2\u02d3\u0006%\uffff\uffff\u0000\u02d3\u02da\u0001\u0000"+
		"\u0000\u0000\u02d4\u02d5\u0005/\u0000\u0000\u02d5\u02d6\u00034\u001a\u0000"+
		"\u02d6\u02d7\u0006%\uffff\uffff\u0000\u02d7\u02d8\u00050\u0000\u0000\u02d8"+
		"\u02da\u0001\u0000\u0000\u0000\u02d9\u02c6\u0001\u0000\u0000\u0000\u02d9"+
		"\u02c8\u0001\u0000\u0000\u0000\u02d9\u02cb\u0001\u0000\u0000\u0000\u02d9"+
		"\u02ce\u0001\u0000\u0000\u0000\u02d9\u02d1\u0001\u0000\u0000\u0000\u02d9"+
		"\u02d4\u0001\u0000\u0000\u0000\u02daK\u0001\u0000\u0000\u0000\u02db\u02dc"+
		"\u0006&\uffff\uffff\u0000\u02dc\u02dd\u0005*\u0000\u0000\u02dd\u02de\u0006"+
		"&\uffff\uffff\u0000\u02de\u02df\u00056\u0000\u0000\u02df\u02e0\u0005\u0006"+
		"\u0000\u0000\u02e0\u02ef\u0005/\u0000\u0000\u02e1\u02e2\u0005/\u0000\u0000"+
		"\u02e2\u02e3\u00038\u001c\u0000\u02e3\u02ea\u0006&\uffff\uffff\u0000\u02e4"+
		"\u02e5\u00055\u0000\u0000\u02e5\u02e6\u00038\u001c\u0000\u02e6\u02e7\u0006"+
		"&\uffff\uffff\u0000\u02e7\u02e9\u0001\u0000\u0000\u0000\u02e8\u02e4\u0001"+
		"\u0000\u0000\u0000\u02e9\u02ec\u0001\u0000\u0000\u0000\u02ea\u02e8\u0001"+
		"\u0000\u0000\u0000\u02ea\u02eb\u0001\u0000\u0000\u0000\u02eb\u02ed\u0001"+
		"\u0000\u0000\u0000\u02ec\u02ea\u0001\u0000\u0000\u0000\u02ed\u02ee\u0005"+
		"0\u0000\u0000\u02ee\u02f0\u0001\u0000\u0000\u0000\u02ef\u02e1\u0001\u0000"+
		"\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000\u0000\u02f0\u02f1\u0001\u0000"+
		"\u0000\u0000\u02f1\u02f2\u00050\u0000\u0000\u02f2\u02f3\u0006&\uffff\uffff"+
		"\u0000\u02f3M\u0001\u0000\u0000\u0000\u02f4\u02f5\u0003P(\u0000\u02f5"+
		"\u02f6\u0006\'\uffff\uffff\u0000\u02f6\u02fa\u0001\u0000\u0000\u0000\u02f7"+
		"\u02f8\u00059\u0000\u0000\u02f8\u02fa\u0006\'\uffff\uffff\u0000\u02f9"+
		"\u02f4\u0001\u0000\u0000\u0000\u02f9\u02f7\u0001\u0000\u0000\u0000\u02fa"+
		"O\u0001\u0000\u0000\u0000\u02fb\u02fc\u0005\"\u0000\u0000\u02fc\u0300"+
		"\u0006(\uffff\uffff\u0000\u02fd\u02fe\u0005#\u0000\u0000\u02fe\u0300\u0006"+
		"(\uffff\uffff\u0000\u02ff\u02fb\u0001\u0000\u0000\u0000\u02ff\u02fd\u0001"+
		"\u0000\u0000\u0000\u0300Q\u0001\u0000\u0000\u0000\u0301\u0302\u0005;\u0000"+
		"\u0000\u0302\u0303\u0006)\uffff\uffff\u0000\u0303S\u0001\u0000\u0000\u0000"+
		"\u0304\u0305\u0005:\u0000\u0000\u0305\u0306\u0006*\uffff\uffff\u0000\u0306"+
		"U\u0001\u0000\u0000\u0000\u0307\u0308\u0005\'\u0000\u0000\u0308\u0318"+
		"\u0006+\uffff\uffff\u0000\u0309\u030a\u0005(\u0000\u0000\u030a\u0318\u0006"+
		"+\uffff\uffff\u0000\u030b\u030c\u0003X,\u0000\u030c\u030d\u0006+\uffff"+
		"\uffff\u0000\u030d\u0318\u0001\u0000\u0000\u0000\u030e\u030f\u0003Z-\u0000"+
		"\u030f\u0310\u0006+\uffff\uffff\u0000\u0310\u0318\u0001\u0000\u0000\u0000"+
		"\u0311\u0312\u0003\\.\u0000\u0312\u0313\u0006+\uffff\uffff\u0000\u0313"+
		"\u0318\u0001\u0000\u0000\u0000\u0314\u0315\u0003R)\u0000\u0315\u0316\u0006"+
		"+\uffff\uffff\u0000\u0316\u0318\u0001\u0000\u0000\u0000\u0317\u0307\u0001"+
		"\u0000\u0000\u0000\u0317\u0309\u0001\u0000\u0000\u0000\u0317\u030b\u0001"+
		"\u0000\u0000\u0000\u0317\u030e\u0001\u0000\u0000\u0000\u0317\u0311\u0001"+
		"\u0000\u0000\u0000\u0317\u0314\u0001\u0000\u0000\u0000\u0318W\u0001\u0000"+
		"\u0000\u0000\u0319\u0321\u0006,\uffff\uffff\u0000\u031a\u031b\u0005\'"+
		"\u0000\u0000\u031b\u0322\u0006,\uffff\uffff\u0000\u031c\u031d\u0005(\u0000"+
		"\u0000\u031d\u0322\u0006,\uffff\uffff\u0000\u031e\u031f\u0003R)\u0000"+
		"\u031f\u0320\u0006,\uffff\uffff\u0000\u0320\u0322\u0001\u0000\u0000\u0000"+
		"\u0321\u031a\u0001\u0000\u0000\u0000\u0321\u031c\u0001\u0000\u0000\u0000"+
		"\u0321\u031e\u0001\u0000\u0000\u0000\u0322\u0328\u0001\u0000\u0000\u0000"+
		"\u0323\u0324\u00051\u0000\u0000\u0324\u0325\u00034\u001a\u0000\u0325\u0326"+
		"\u00052\u0000\u0000\u0326\u0327\u0006,\uffff\uffff\u0000\u0327\u0329\u0001"+
		"\u0000\u0000\u0000\u0328\u0323\u0001\u0000\u0000\u0000\u0329\u032a\u0001"+
		"\u0000\u0000\u0000\u032a\u0328\u0001\u0000\u0000\u0000\u032a\u032b\u0001"+
		"\u0000\u0000\u0000\u032b\u032c\u0001\u0000\u0000\u0000\u032c\u032d\u0006"+
		",\uffff\uffff\u0000\u032dY\u0001\u0000\u0000\u0000\u032e\u032f\u0006-"+
		"\uffff\uffff\u0000\u032f\u0330\u0005)\u0000\u0000\u0330\u033e\u0005\u001a"+
		"\u0000\u0000\u0331\u0332\u0005\t\u0000\u0000\u0332\u033f\u0006-\uffff"+
		"\uffff\u0000\u0333\u0334\u0003V+\u0000\u0334\u033b\u0006-\uffff\uffff"+
		"\u0000\u0335\u0336\u00055\u0000\u0000\u0336\u0337\u0003V+\u0000\u0337"+
		"\u0338\u0006-\uffff\uffff\u0000\u0338\u033a\u0001\u0000\u0000\u0000\u0339"+
		"\u0335\u0001\u0000\u0000\u0000\u033a\u033d\u0001\u0000\u0000\u0000\u033b"+
		"\u0339\u0001\u0000\u0000\u0000\u033b\u033c\u0001\u0000\u0000\u0000\u033c"+
		"\u033f\u0001\u0000\u0000\u0000\u033d\u033b\u0001\u0000\u0000\u0000\u033e"+
		"\u0331\u0001\u0000\u0000\u0000\u033e\u0333\u0001\u0000\u0000\u0000\u033f"+
		"\u0340\u0001\u0000\u0000\u0000\u0340\u0346\u0005\u001b\u0000\u0000\u0341"+
		"\u0342\u0003V+\u0000\u0342\u0343\u0006-\uffff\uffff\u0000\u0343\u0347"+
		"\u0001\u0000\u0000\u0000\u0344\u0345\u0005\t\u0000\u0000\u0345\u0347\u0006"+
		"-\uffff\uffff\u0000\u0346\u0341\u0001\u0000\u0000\u0000\u0346\u0344\u0001"+
		"\u0000\u0000\u0000\u0347\u0348\u0001\u0000\u0000\u0000\u0348\u0349\u0005"+
		"\u0019\u0000\u0000\u0349\u034a\u0006-\uffff\uffff\u0000\u034a[\u0001\u0000"+
		"\u0000\u0000\u034b\u034c\u0005*\u0000\u0000\u034c\u034d\u0005\u001a\u0000"+
		"\u0000\u034d\u034e\u0005\'\u0000\u0000\u034e\u034f\u0005\u0019\u0000\u0000"+
		"\u034f\u0350\u0006.\uffff\uffff\u0000\u0350]\u0001\u0000\u0000\u0000O"+
		"aisy\u0080\u0086\u0090\u009f\u00a4\u00ab\u00b1\u00b7\u00be\u00c8\u00cd"+
		"\u00d4\u00de\u00e9\u00f0\u00f4\u00fc\u0100\u010a\u010c\u011a\u011d\u0127"+
		"\u012a\u013b\u013e\u0146\u014b\u0153\u015a\u015e\u017e\u0195\u01ad\u01b9"+
		"\u01bf\u01c4\u01d5\u01da\u01eb\u01ef\u01fc\u020f\u0220\u0229\u0233\u023d"+
		"\u0248\u0253\u025c\u0263\u026c\u0273\u027c\u0283\u028d\u0292\u029a\u029d"+
		"\u02b3\u02b5\u02b7\u02c1\u02c3\u02d9\u02ea\u02ef\u02f9\u02ff\u0317\u0321"+
		"\u032a\u033b\u033e\u0346";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}