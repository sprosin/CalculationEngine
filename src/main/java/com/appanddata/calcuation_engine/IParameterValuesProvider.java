package com.appanddata.calcuation_engine;

public interface IParameterValuesProvider {
    ParameterValue get(String paramName);

    void set(String paramName, ParameterValue value);

    boolean isUpdated(String name);

    void flushUpdated();
}
