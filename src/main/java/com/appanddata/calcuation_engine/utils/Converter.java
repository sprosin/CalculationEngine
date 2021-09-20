package com.appanddata.calcuation_engine.utils;

import com.appanddata.calcuation_engine.equations.LambdaEquation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Converter {
    private static final Map<String, Function<Object, Object>> converters;

    static {
        converters = new HashMap<>();
        converters.put("java.lang.Integer,java.lang.Double", Converter::convertIntegerToDouble);
    }

    private static Function<Object, Object> getConverter(String origClassName, String targetClassName) {
        String key = "%s,%s".formatted(origClassName, targetClassName);
        var converter = converters.getOrDefault(key, o -> o);
        return converter;
    }

    public static Object convert(String origClassName, String targetClassName, Object value) {
        Function<Object, Object> converter = getConverter(origClassName, targetClassName);
        return converter.apply(value);
    }

    private static Object convertIntegerToDouble(Object o) {
        return (double) ((int) o);
    }
}
