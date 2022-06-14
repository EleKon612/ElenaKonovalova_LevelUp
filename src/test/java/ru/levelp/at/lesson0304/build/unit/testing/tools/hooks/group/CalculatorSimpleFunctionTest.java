package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.build.unit.testing.tools.homework.MyCalculatorHomeworkAllClasses;

public class CalculatorSimpleFunctionTest extends BaseCalculatorBeforeAfterGroupsHookTest {

    @Test(groups = {"sum", "long"})
    public void sumLongTest() {
        System.out.println(
            String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class.getCanonicalName(),
                "sumLongTest"));
        long res = calculator.sum(2, 2);
        assertEquals(res, 4);
    }

    @Test(groups = {"subtract", "long"})
    public void subLongTest() {
        System.out.println(
            String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class.getCanonicalName(),
                "subLongTest"));
        long res = calculator.sub(6, 2);
        assertEquals(res, 4);
    }

    @Test(groups = {"multiply", "long"})
    public void multLongTest() {
        System.out.println(
            String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class.getCanonicalName(),
                "multLongTest"));
        long res = calculator.mult(6, 2);
        assertEquals(res, 12);
    }
}
