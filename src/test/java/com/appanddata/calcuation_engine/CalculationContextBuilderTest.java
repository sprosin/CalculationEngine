package com.appanddata.calcuation_engine;

import com.appanddata.calcuation_engine.equations.PlusEquation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculationContextBuilderTest {

    @Test
    public void calculationContextBuilderSimpleTest() {
        var builder = new CalculationContextBuilder();
        PlusEquation equation = new PlusEquation("A", "B", "C");
        CalculationContext context = builder.context()
                .withEquation(equation)
                .build();

        Assert.assertEquals(context.getEquations().length, 1);
        Assert.assertEquals(context.getEquations()[0], equation);
    }

    @Test
    public void reverseEquationTest() {
        var builder = new CalculationContextBuilder();
        PlusEquation equation1 = new PlusEquation("B", "C", "D");
        PlusEquation equation2 = new PlusEquation("A", "B", "C");
        CalculationContext context = builder.context()
                .withEquation(equation1)
                .withEquation(equation2)
                .build();

        Assert.assertEquals(context.getEquations().length, 2);
        Assert.assertEquals(context.getEquations()[0], equation2);
        Assert.assertEquals(context.getEquations()[1], equation1);
    }

}