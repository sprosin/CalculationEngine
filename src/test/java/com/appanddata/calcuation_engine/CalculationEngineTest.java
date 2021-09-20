package com.appanddata.calcuation_engine;

import com.appanddata.calcuation_engine.equations.PlusEquation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CalculationEngineTest {

    @Test
    public void calcualtionEngineSimpleTest() {
        CalculationEngine engine = new CalculationEngine();
        IEquation equation = new PlusEquation("A", "B", "C");

        IParameterValuesProvider valuesProvider = new ParameterValuesProvider();
        valuesProvider.set("A", new ParameterValue(1));
        valuesProvider.set("B", new ParameterValue(2));
        engine.calculate(new IEquation[] {equation}, valuesProvider);

        Assert.assertEquals(valuesProvider.get("C").getValue(),3);

    }

    @Test
    public void calcualtionEngineCascadeTest() {
        CalculationEngine engine = new CalculationEngine();
        List<IEquation> equationList = new LinkedList<>();
        for (int i = 0; i < 50000; i++) {
            IEquation equation = new PlusEquation("p"+i, "p"+(i+1), "p"+(i+2));
            equationList.add(equation);
        }
        IParameterValuesProvider valuesProvider = new ParameterValuesProvider();
        valuesProvider.set("p0", new ParameterValue(1));
        valuesProvider.set("p1", new ParameterValue(1));
        engine.calculate(equationList.toArray(new IEquation[0]), valuesProvider);
    }

    @Test
    public void calcualtionEngineBackwardCascadeTest() {
        CalculationEngine engine = new CalculationEngine();
        List<IEquation> equationList = new LinkedList<>();
        for (int i = 500000; i > 0; i--) {
            IEquation equation = new PlusEquation("p"+i, "p"+(i+1), "p"+(i+2));
            equationList.add(equation);
        }
        IParameterValuesProvider valuesProvider = new ParameterValuesProvider();
        valuesProvider.set("p1", new ParameterValue(1));
        valuesProvider.set("p2", new ParameterValue(1));
        engine.calculate(equationList.toArray(new IEquation[0]), valuesProvider);
    }


}