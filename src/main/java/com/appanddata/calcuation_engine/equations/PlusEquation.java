package com.appanddata.calcuation_engine.equations;

import com.appanddata.calcuation_engine.IEquation;
import com.appanddata.calcuation_engine.ParameterDefinition;

public class PlusEquation implements IEquation {
    private String p1Name;
    private String p2Name;
    private String outputName;

    public PlusEquation(String p1Name, String p2Name, String outputName) {
        this.p1Name = p1Name;
        this.p2Name = p2Name;
        this.outputName = outputName;
    }

    @Override
    public ParameterDefinition[] getInputParameters() {
        return new ParameterDefinition[] {
                new ParameterDefinition(p1Name),
                new ParameterDefinition(p2Name)
        };
    }

    @Override
    public ParameterDefinition getOutputParameter() {
        return new ParameterDefinition(outputName);
    }

    @Override
    public Object execute(Object[] paramValues) {
        int a = (int)paramValues[0];
        int b = (int)paramValues[1];
        return a+b;
    }
}
