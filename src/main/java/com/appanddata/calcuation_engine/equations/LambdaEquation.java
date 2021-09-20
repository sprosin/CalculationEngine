package com.appanddata.calcuation_engine.equations;


import com.appanddata.calcuation_engine.IEquation;
import com.appanddata.calcuation_engine.ParameterDefinition;
import com.appanddata.calcuation_engine.utils.Converter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class LambdaEquation<T> implements IEquation {

    private final BinaryOperator<T> operator;
    private final ParameterDefinition[] inputParameters;
    private final ParameterDefinition outputParameter;
    private final Class<T> clazz;

    public LambdaEquation(
            Class<T> clazz,
            String outputParameterName, String parameter1Name,
            String parameter2Name, BinaryOperator<T> operator) {
        this.operator = operator;
        this.inputParameters = new ParameterDefinition[]{
                new ParameterDefinition(parameter1Name),
                new ParameterDefinition(parameter2Name)
        };

        this.outputParameter = new ParameterDefinition(outputParameterName);
        this.clazz = clazz;
    }

    @Override
    public ParameterDefinition[] getInputParameters() {
        return inputParameters;
    }

    @Override
    public ParameterDefinition getOutputParameter() {
        return outputParameter;
    }

    @Override
    public Object execute(Object[] paramValues) {
        var p1class = paramValues[0].getClass();
        T p1 = (T)(Converter.convert(p1class.getName(), clazz.getName(), paramValues[0]));
        T p2 = (T)(Converter.convert(p1class.getName(), clazz.getName(), paramValues[1]));
        return operator.apply(p1, p2);
    }


}
