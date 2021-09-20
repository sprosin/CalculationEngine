package com.appanddata.calcuation_engine;

import com.appanddata.calcuation_engine.equations.PlusEquation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CalculationEngineUpdatedTest {
    IParameterValuesProvider valuesProvider;
    CalculationContext calculationContext;

    @BeforeMethod
    public void setUp() {
        CalculationContextBuilder builder = new CalculationContextBuilder();

        List<IEquation> equationList = new LinkedList<>();
        for (int i = 500000; i > 0; i--) {
            IEquation equation = new PlusEquation("p"+i, "p"+(i+1), "p"+(i+2));
            builder.withEquation(equation);
        }
        calculationContext = builder.build();

        valuesProvider = new ParameterValuesProvider();
        valuesProvider.set("p1", new ParameterValue(1));
        valuesProvider.set("p2", new ParameterValue(1));

        CalculationEngine engine = new CalculationEngine();
        engine.calculate(calculationContext, valuesProvider);

        valuesProvider.flushUpdated();
    }

    @Test
    public void updatedCalculationTest() {
        valuesProvider.set("p499999", new ParameterValue(2,true));
        valuesProvider.set("p500000", new ParameterValue(3,true));

        CalculationEngine engine = new CalculationEngine();
        engine.calculate(calculationContext, valuesProvider);

        Assert.assertEquals(valuesProvider.get("p500002").getValue(), 8);
    }
}
