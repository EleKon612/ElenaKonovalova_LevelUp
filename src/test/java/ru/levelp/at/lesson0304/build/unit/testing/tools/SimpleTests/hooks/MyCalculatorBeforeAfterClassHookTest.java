package ru.levelp.at.lesson0304.build.unit.testing.tools.SimpleTests.hooks;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class MyCalculatorBeforeAfterClassTest {

    private Calculator MyCalculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorBeforeAfterClassTest.class
            .getCanonicalName(), "beforeClass"));
    }

    @BeforeMethod
    public void setUp(){
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorBeforeAfterClassTest.class
            .getCanonicalName(), "setUp"));
        MyCalculator = new Calculator();
    }

    @Test
    public void sum2And2() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorBeforeAfterClassTest.class
            .getCanonicalName(), "sum2And2"));
        long res = MyCalculator.sum(2, 2);
        assertEquals(res, 4L, "Incorrect");
    }

    @Test
    public void sum2point0and4point0(){
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorBeforeAfterClassTest.class
            .getCanonicalName(), "sum2point0and4point0"));
        double res = MyCalculator.sum(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorBeforeAfterClassTest.class
            .getCanonicalName(), "tearDown"));
        MyCalculator = null;
        System.out.println("=====");
        System.out.println();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorBeforeAfterClassTest.class
            .getCanonicalName(), "afterClass"));
    }
}