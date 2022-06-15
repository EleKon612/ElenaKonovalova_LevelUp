package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class BeforeAfterMethodHookInheritanceTest extends BaseCalculatorBeforeAfterHookInheritanceTest {

    private Calculator calculator;

    @BeforeMethod
    @Override
    public void setUp() {
        System.out.println("^_^ ^_^ ^_^");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
        System.out.println("this method was override");
    }

    @Test
    public void sum2And2() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(), "sum2And2"));
        long res = calculator.sum(2, 2);
        assertEquals(res, 4L, "Incorrect");
    }

    @Test
    public void sum2point0and4point0() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sum2point0and4point0"));
        double res = calculator.sum(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }

    @AfterClass
    @Override
    public void afterClass() {
        System.out.println("XD XD XD");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "afterClass"));
        calculator = new Calculator();
        System.out.println("this method was override");
    }
}