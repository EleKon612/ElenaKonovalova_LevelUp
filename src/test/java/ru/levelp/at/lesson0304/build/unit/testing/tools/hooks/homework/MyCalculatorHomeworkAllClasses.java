package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.homework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class MyCalculatorHomeworkAllClasses extends BaseCalculatorBeforeAfterHookInheritanceTestHomework {
    private Calculator MyCalculator;

    @Test
    public void sum2And2() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sum2And2"));
        long res = MyCalculator.sum(2, 2);
        assertEquals(res, 4L);
    }

    @Test
    public void sum2point3and4point5() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sum2point0and4point0"));
        double res = MyCalculator.sum(2.3D, 4.5D);
        assertEquals(res, 6.8D);
    }

    @Test
    public void sub3minus2() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sub3minus2"));
        long res = MyCalculator.sub(3, 2);
        assertEquals(res, 1L);
    }

    @Test
    public void sub5point2minus3point1() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sub5point2minus3point1"));
        double res = MyCalculator.sub(5.2D, 3.1D);
        assertEquals(res, 2.1D);
    }
}