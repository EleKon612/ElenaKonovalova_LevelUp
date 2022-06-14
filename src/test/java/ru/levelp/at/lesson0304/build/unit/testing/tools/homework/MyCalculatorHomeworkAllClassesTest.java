package ru.levelp.at.lesson0304.build.unit.testing.tools.homework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class MyCalculatorHomeworkAllClassesTest {

    private Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("+++++");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "beforeSuite"));
        System.out.println();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("-----");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "beforeTest"));
        System.out.println();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "beforeClass"));
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @Test
    public void sumLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "sumLong"));
        long res = calculator.sum(2, 2);
        assertEquals(res, 4L);
    }

    @Test
    public void sumDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "sumDouble"));
        double res = calculator.sum(4.3D, 2.6D);
        assertEquals(res, 6.9D, 0.01);
    }

    @Test
    public void subLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "subLong"));
        long res = calculator.sub(4, 2);
        assertEquals(res, 2L);
    }

    @Test
    public void subDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "subDouble"));
        double res = calculator.sub(5.2, 4.1);
        assertEquals(res, 1.1D, 0.01);
    }

    @Test
    public void multLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "multLong"));
        long res = calculator.mult(2, 3);
        assertEquals(res, 6L);
    }

    @Test
    public void multDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "multDouble"));
        double res = calculator.mult(2.3D, 4.6D);
        assertEquals(res, 10.58D, 1);
    }

    @Test
    public void divLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "divLong"));
        long res = calculator.div(4, 2);
        assertEquals(res, 2L);
    }

    @Test(expectedExceptions = {NumberFormatException.class}, expectedExceptionsMessageRegExp =
        "Attempt to divide by zero")
    public void divideByZeroTest() {
        calculator.div(1, 0);
    }

    @Test
    public void divDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "divDouble"));
        double res = calculator.div(3.1725D, 2.35D);
        assertEquals(res, 1.35D, 0.01);
    }

    @Test
    public void powDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "powDouble"));
        double res = calculator.pow(2.2D, 3.3D);
        assertEquals(res, 10.648D, 0.001);
    }

    @Test
    public void sqrtDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "sqrtDouble"));
        double res = calculator.sqrt(-5.4289D);
        assertEquals(res, 2.33D, 0.01);
    }

    @Test
    public void sinDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "sinDouble"));
        double res = calculator.sin(0.52D);
        assertEquals(res, 0.5D, 0.01);
    }

    @Test
    public void cosDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "cosDouble"));
        double res = calculator.cos(0.7D);
        assertEquals(res, 0.76D, 0.01);
    }

    @Test
    public void tgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "tgDouble"));
        double res = calculator.tg(0.61D);
        assertEquals(res, 0.7D, 0.01);
    }

    @Test
    public void ctgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "ctgDouble"));
        double res = calculator.ctg(0.45D);
        assertEquals(res, 2.07D, 0.01);
    }

    @Test
    public void booleanPositive() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "booleanPositive"));
        boolean res = calculator.isPositive(10);
        assertEquals(res, true);
    }

    @Test
    public void booleanNull() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "booleanNull"));
        boolean res = calculator.isPositive(0);
        assertEquals(res, false);
    }

    @Test
    public void booleanNegative() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "booleanNegative"));
        boolean res = calculator.isNegative(-10);
        assertEquals(res, true);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }

    @AfterClass
    public void afterClass() {
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "afterClass"));
        System.out.println("*****");
        System.out.println();
    }

    @AfterTest
    public void afterTest() {
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "afterTest"));
        System.out.println("-----");
        System.out.println();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClassesTest.class
            .getCanonicalName(), "afterSuite"));
        System.out.println("+++++");
        System.out.println();
    }
}