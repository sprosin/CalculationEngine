package com.appanddata.calcuation_engine;

public class ParameterValue {
    private final Object value;
    private final boolean userDefined;

    public ParameterValue(Object value, boolean userDefined) {
        this.value = value;
        this.userDefined = userDefined;
    }

    public ParameterValue(Object value) {
        this(value, false);
    }

    public boolean isUserDefined() {
        return userDefined;
    }

    public Object getValue() {
        return value;
    }
}
