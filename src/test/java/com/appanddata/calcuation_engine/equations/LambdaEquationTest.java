package com.appanddata.calcuation_engine.equations;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LambdaEquationTest {

    @Test
    public void simpleLambdaIntegerTest() {
        var le = new LambdaEquation<>(Integer.class,
                "C",
                "A", "B",
                Integer::sum);

        Assert.assertEquals(le.execute(new Object[] {1,2}), 3);
    }
    @Test
    public void simpleLambdaDoubleTest() {
        var le = new LambdaEquation<>(Double.class,
                "C",
                "A", "B",
                Double::sum);

        Assert.assertEquals(le.execute(new Object[] {1,2}), 3.0);
    }

}