package ru.levelp.at.lesson0304.build.unit.testing.tools.simpletests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class SimpleTest {

    @Test
    public void sum2And2() {
        Calculator calculator = new Calculator();
        long res = calculator.sum(2, 2);
        assertEquals(res, 4L, "Incorrect");
    }

    @Test
    public void sum2point0and4point0() {
        Calculator calculator = new Calculator();
        double res = calculator.sum(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }
}
