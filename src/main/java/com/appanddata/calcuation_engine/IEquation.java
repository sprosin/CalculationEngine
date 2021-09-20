package com.appanddata.calcuation_engine;


public interface IEquation {
    ParameterDefinition[] getInputParameters();
    ParameterDefinition getOutputParameter();
    Object execute(Object[] paramValues);
}
