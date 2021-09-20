package com.appanddata.calcuation_engine;

public class CalculationContext {

    private final IEquation[] equations;

    public CalculationContext(IEquation[] equations) {
        this.equations = equations;
    }

    public IEquation[] getEquations() {
        return equations;
    }
}
