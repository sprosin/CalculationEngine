// Generated from C:/projects/com.appanddata.calculation_engine/src/main/antlr4\Equation.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EquationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EquationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EquationParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(EquationParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EquationParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(EquationParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EquationParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(EquationParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EquationParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(EquationParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EquationParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(EquationParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link EquationParser#output_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_variable(EquationParser.Output_variableContext ctx);
}