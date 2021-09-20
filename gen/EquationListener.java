// Generated from C:/projects/com.appanddata.calculation_engine/src/main/antlr4\Equation.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EquationParser}.
 */
public interface EquationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EquationParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(EquationParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EquationParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(EquationParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EquationParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(EquationParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EquationParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(EquationParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EquationParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EquationParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EquationParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EquationParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EquationParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(EquationParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EquationParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(EquationParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EquationParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(EquationParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link EquationParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(EquationParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link EquationParser#output_variable}.
	 * @param ctx the parse tree
	 */
	void enterOutput_variable(EquationParser.Output_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link EquationParser#output_variable}.
	 * @param ctx the parse tree
	 */
	void exitOutput_variable(EquationParser.Output_variableContext ctx);
}