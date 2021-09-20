package com.appanddata.calcuation_engine;

import java.util.HashMap;
import java.util.Map;

public class ParameterValuesProvider implements IParameterValuesProvider {
    private Map<String, ParameterValue> originalValues = new HashMap<>();
    private Map<String, ParameterValue> updatedValues = new HashMap<>();

    @Override
    public ParameterValue get(String paramName) {
        return updatedValues.getOrDefault(paramName, originalValues.get(paramName));
    }

    @Override
    public void set(String paramName, ParameterValue value) {
        updatedValues.put(paramName, value);
    }

    @Override
    public boolean isUpdated(String name) {
        return updatedValues.containsKey(name);
    }

    @Override
    public void flushUpdated() {
        for(var kv: updatedValues.entrySet()) {
            originalValues.put(kv.getKey(), kv.getValue());
        }
        updatedValues.clear();
    }
}
