package com.appanddata.calcuation_engine;

public class ParameterDefinition {
    private Class<?> type = Object.class;
    private String name;

    public ParameterDefinition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
