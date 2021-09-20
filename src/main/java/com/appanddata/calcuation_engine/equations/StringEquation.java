package com.appanddata.calcuation_engine.equations;

import com.appanddata.calcuation_engine.IEquation;
import com.appanddata.calcuation_engine.ParameterDefinition;
import com.appanddata.calculation_engine.EquationBaseListener;
import com.appanddata.calculation_engine.EquationBaseVisitor;
import com.appanddata.calculation_engine.EquationLexer;
import com.appanddata.calculation_engine.EquationParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StringEquation implements IEquation {

    EquationParser.ParseContext context;
    private String sEquation;
    private ParameterDefinition outputPrameter = null;
    private ParameterDefinition[] outputParameters = null;

    public StringEquation(String sEquation) throws IOException {
        this.sEquation = sEquation;
        parse();
    }

    private void parse() throws IOException {
        InputStream stream = new ByteArrayInputStream(sEquation.getBytes(StandardCharsets.UTF_8));
        EquationLexer lexer = new EquationLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        EquationParser parser = new EquationParser(new CommonTokenStream(lexer));
        context = parser.parse();

        ParseTreeWalker walker = new ParseTreeWalker();
        EquationAnalysisListener listener = new EquationAnalysisListener();

        walker.walk(listener, context);

        outputPrameter = new ParameterDefinition(listener.getOutputVariable());
        outputParameters = listener.getVariables().stream().map(ParameterDefinition::new).toArray(ParameterDefinition[]::new);


    }

    @Override
    public ParameterDefinition[] getInputParameters() {
        return outputParameters;
    }

    @Override
    public ParameterDefinition getOutputParameter() {
        return outputPrameter;
    }

    @Override
    public Object execute(Object[] paramValues) {
        HashMap<String, Object> parameterValues = new HashMap<>();
        for (int i = 0; i < getInputParameters().length; i++) {
            parameterValues.put(getInputParameters()[i].getName(), paramValues[i]);
        }

        EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
        evaluationVisitor.setParameterValues(parameterValues);
        var result = evaluationVisitor.visitParse(context);

        return result.getValue();
    }

    private class Value {
        private Object value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Value value1 = (Value) o;
            return Objects.equals(value, value1.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        public Value(Object voidValue) {
            this.value = voidValue;
        }

        public Value unaryMinus() {
            if (this.getValue() instanceof Integer i) {
                return new Value(-i);
            }
            if (this.getValue() instanceof Double d) {
                return new Value(-d);
            }
            throw new IllegalArgumentException("Wrong type of v");
        }

        public Value add(Value v2) {
            if (this.getValue() instanceof Double d1 && v2.getValue() instanceof Double d2) {
                return new Value(d1 + d2);
            }

            if (this.getValue() instanceof Integer i1 && v2.getValue() instanceof Integer i2) {
                return new Value(i1 + i2);
            }

            throw new IllegalArgumentException("Wrong types");
        }

        public Value subtract(Value v2) {
            if (this.getValue() instanceof Double d1 && v2.getValue() instanceof Double d2) {
                return new Value(d1 - d2);
            }

            if (this.getValue() instanceof Integer i1 && v2.getValue() instanceof Integer i2) {
                return new Value(i1 - i2);
            }

            throw new IllegalArgumentException("Wrong types");
        }

        public Value multi(Value v2) {
            if (this.getValue() instanceof Double d1 && v2.getValue() instanceof Double d2) {
                return new Value(d1 * d2);
            }

            if (this.getValue() instanceof Integer i1 && v2.getValue() instanceof Integer i2) {
                return new Value(i1 * i2);
            }

            throw new IllegalArgumentException("Wrong types");
        }

        public Value divide(Value v2) {
            if (this.getValue() instanceof Double d1 && v2.getValue() instanceof Double d2) {
                return new Value(d1 / d2);
            }

            if (this.getValue() instanceof Integer i1 && v2.getValue() instanceof Integer i2) {
                return new Value(i1 / i2);
            }

            throw new IllegalArgumentException("Wrong types");
        }

        public Object getValue() {
            return value;
        }


        @Override
        public String toString() {
            return "Value{" +
                    "value=" + value +
                    '}';
        }
    }

    private class EquationAnalysisListener extends EquationBaseListener {
        Set<String> variables = new HashSet<>();
        String outputVariable = "";

        public Set<String> getVariables() {
            return variables;
        }

        public String getOutputVariable() {
            return outputVariable;
        }

        @Override
        public void enterVariable(EquationParser.VariableContext ctx) {
            String variable = ctx.getText();
            variables.add(variable);
        }

        @Override
        public void enterOutputVariable(EquationParser.OutputVariableContext ctx) {
            String outputVariable = ctx.getText();
            this.outputVariable = outputVariable;

        }
    }

    private class EvaluationVisitor extends EquationBaseVisitor<Value> {

        private Map<String, Object> parameterValues;

        @Override
        public Value visitParse(EquationParser.ParseContext ctx) {
            return visitEquation(ctx.equation());
        }

        @Override
        public Value visitEquation(EquationParser.EquationContext ctx) {
            String outputVariable = ctx.outputVariable().getText();
            var result = this.visit(ctx.expr());
            return result;
        }

        @Override
        public Value visitVariable(EquationParser.VariableContext ctx) {
            String variable = ctx.getText();
            return new Value(parameterValues.get(variable));
        }

        @Override
        public Value visitUnaryMinusExpr(EquationParser.UnaryMinusExprContext ctx) {

            return this.visit(ctx.expr()).unaryMinus();
        }

        @Override
        public Value visitPlusMinusExpr(EquationParser.PlusMinusExprContext ctx) {
            Value left = this.visit(ctx.expr(0));
            Value right = this.visit(ctx.expr(1));

            switch (ctx.op.getText()) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.subtract(right);
                default:
                    throw new RuntimeException("unknown operator: " + ctx.op.getText());
            }
        }

        @Override
        public Value visitIntConstExpr(EquationParser.IntConstExprContext ctx) {
            return new Value(Integer.parseInt(ctx.getText()));
        }

        @Override
        public Value visitFloatExpr(EquationParser.FloatExprContext ctx) {
            return new Value(Double.parseDouble(ctx.getText()));
        }

        @Override
        public Value visitBracketsExpr(EquationParser.BracketsExprContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Value visitFunction(EquationParser.FunctionContext ctx) {
            throw new RuntimeException("visitFunction() is not implemented yet");
        }

        @Override
        public Value visitMultiDivideExpr(EquationParser.MultiDivideExprContext ctx) {
            Value left = this.visit(ctx.expr(0));
            Value right = this.visit(ctx.expr(1));

            switch (ctx.op.getText()) {
                case "*":
                    return left.multi(right);
                case "/":
                    return left.divide(right);
                default:
                    throw new RuntimeException("unknown operator: " + ctx.op.getText());
            }
        }

        public void setParameterValues(HashMap<String, Object> parameterValues) {
            this.parameterValues = parameterValues;
        }
    }
}
