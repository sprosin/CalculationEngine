package com.appanddata.calcuation_engine.equations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class StringEquationTest {

    @Test
    public void simpleParseTest() throws IOException {
        var eq = new StringEquation("C = A + B + A");

        Assert.assertEquals(eq.getInputParameters().length, 2);
        Assert.assertEquals(eq.getInputParameters()[0].getName(), "A");
        Assert.assertEquals(eq.getInputParameters()[1].getName(), "B");
        Assert.assertEquals(eq.getOutputParameter().getName(), "C");
    }

    @Test
    public void simpleExecuteTest() throws IOException {
        var eq = new StringEquation("C = A + B + A");
        var result = eq.execute(new Object[] {1,2});

        Assert.assertEquals(result, 4);
    }

    @Test
    public void intConstExecuteTest() throws IOException {
        var eq = new StringEquation("C = 3");
        var result = eq.execute(new Object[] {});

        Assert.assertEquals(result, 3);
    }

    @Test
    public void floatConstExecuteTest() throws IOException {
        var eq = new StringEquation("C = 3.5");
        var result = eq.execute(new Object[] {});

        Assert.assertEquals(result, 3.5);
    }

    @Test
    public void formulaExecuteTest() throws IOException {
        var eq = new StringEquation("C = -(3) + (A+5*3)");
        var result = eq.execute(new Object[] {1});

        Assert.assertEquals(result, 13);
    }

    @Test
    public void floatSumTest() throws IOException {
        var eq = new StringEquation("C = 3.5+5.5");
        var result = eq.execute(new Object[] {});

        Assert.assertEquals((double)result, 9.0d, 0.0001);
    }

}