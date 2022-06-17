package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorExtendedFunctionTest extends BaseCalculatorBeforeAfterGroupsHookTest {

    @Test(groups = {"sum", "double"})
    public void sumDoubleTest() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sumDoubleTest"));
        double res = calculator.sum(2D, 2D);
        assertEquals(res, 4D);
    }

    @Test(groups = {"subtract", "double"})
    public void subDoubleTest() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "subDoubleTest"));
        double res = calculator.sub(6D, 2D);
        assertEquals(res, 4D);
    }

    @Test(groups = {"multiply", "double"})
    public void multDoubleTest() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "multDoubleTest"));
        double res = calculator.mult(6D, 2D);
        assertEquals(res, 12D);
    }
}
