package com.appanddata.calcuation_engine;

import java.util.*;
import java.util.stream.Collectors;

public class CalculationEngine {
    public void calculate(IEquation[] equations, IParameterValuesProvider parameterValuesProvider) {
        CalculationContextBuilder builder = new CalculationContextBuilder();
        var context = builder.withEquations(equations).build();

        calculate(context, parameterValuesProvider);
    }

    public void calculate(CalculationContext calculationContext, IParameterValuesProvider parameterValuesProvider) {
        for (IEquation equation :
                calculationContext.getEquations()
        ) {
            var outputValue = parameterValuesProvider.get(equation.getOutputParameter().getName());
            if (outputValue!=null && outputValue.isUserDefined())
                continue;

            boolean requireRecalc = false;
            for (var param:equation.getInputParameters()) {
                String name = param.getName();
                if (parameterValuesProvider.isUpdated(name)) {
                    requireRecalc = true;
                    break;
                }
            }
            if (!requireRecalc)
                continue;

            Object[] paramValues = Arrays.stream(equation.getInputParameters())
                    .map(param -> parameterValuesProvider.get(param.getName()).getValue()).toArray();

            Object value = equation.execute(paramValues);

            parameterValuesProvider.set(equation.getOutputParameter().getName(), new ParameterValue(value));
        }
    }

//    public void calculate2(CalculationContext calculationContext, IParameterValuesProvider parameterValuesProvider){
//        //Set<String> paramsToCalculate = new HashSet<>();
//        var allParams = Arrays.stream(calculationContext.getEquations())
//                .flatMap(eq -> Arrays.stream(eq.getInputParameters())).map(p -> p.getName());
//        var paramsToCalculate = allParams
//                .dropWhile(p -> parameterValuesProvider.isUpdated(p) || parameterValuesProvider.get(p) == null)
//                .collect(Collectors.toSet());
//
//        for (IEquation equation:
//                calculationContext.getEquations()
//        ) {
//            boolean requireRecalc = Arrays.stream(equation.getInputParameters()).anyMatch(p -> parameterValuesProvider.isUpdated(p.getName()));
//            if(!requireRecalc)
//                continue;
//
//            Object[] paramValues = Arrays.stream(equation.getInputParameters())
//                    .map(param -> parameterValuesProvider.get(param.getName())).toArray();
//
//            Object value = equation.execute(paramValues);
//
//            parameterValuesProvider.set(equation.getOutputParameter().getName(), value);
//        }
//    }

}
