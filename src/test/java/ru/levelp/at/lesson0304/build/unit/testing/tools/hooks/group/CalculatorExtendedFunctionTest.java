package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.homework.MyCalculatorHomeworkAllClasses;

public class CalculatorExtendedFunctionTest extends BaseCalculatorBeforeAfterGroupsHookTest{

    @Test(groups = {"sum", "double"})
    public void sumDoubleTest() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sumDoubleTest"));
        double res = MyCalculator.sum(2D, 2D);
        assertEquals(res, 4D);
    }

    @Test(groups = {"subtract", "double"})
    public void subDoubleTest() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "subDoubleTest"));
        double res = MyCalculator.sub(6D, 2D);
        assertEquals(res, 4D);
    }

    @Test(groups = {"multiply", "double"})
    public void multDoubleTest() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "multDoubleTest"));
        double res = MyCalculator.mult(6D, 2D);
        assertEquals(res, 12D);
    }
}
