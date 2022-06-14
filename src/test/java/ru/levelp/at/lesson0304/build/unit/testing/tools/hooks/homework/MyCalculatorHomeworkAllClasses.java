package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class MyCalculatorHomeworkAllClasses {

    private Calculator MyCalculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("+++++");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "beforeSuite"));
        System.out.println();
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "beforeClass"));
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("<Start of test>");
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "setUp"));
        MyCalculator = new Calculator();
    }
    @Test
    public void sumLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sumLong"));
        long res = MyCalculator.sum(2, 2);
        assertEquals(res, 4L);
    }
    @Test
    public void sumDouble(){
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sumDouble"));
        double res = MyCalculator.sum(4.3D, 2.6D);
        assertEquals(res, 6.9D, 0.01);
    }
    @Test
    public void subLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "subLong"));
        long res = MyCalculator.sub(4, 2);
        assertEquals(res, 2L);
    }
    @Test
    public void subDouble(){
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "subDouble"));
        double res = MyCalculator.sub(5.2, 4.1);
        assertEquals(res, 1.1D, 0.01);
    }
    @Test
    public void multLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "multLong"));
        long res = MyCalculator.mult(2, 3);
        assertEquals(res, 6L);
    }
    @Test
    public void multDouble(){
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "multDouble"));
        double res = MyCalculator.mult(2.3D, 4.6D);
        assertEquals(res, 10.58D, 1);
    }
    @Test
    public void divLong() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "divLong"));
        long res = MyCalculator.div(4, 2);
        assertEquals(res, 2L);
    }
    @Test
    public void divDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "divDouble"));
        double res = MyCalculator.div(3.1725D, 2.35D);
        assertEquals(res, 1.35D, 0.01);
    }
    @Test
    public void powDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "powDouble"));
        double res = MyCalculator.pow(2.2D, 3.3D);
        assertEquals(res, 10.648D, 0.001);
    }
    @Test
    public void sqrtDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sqrtDouble"));
        double res = MyCalculator.sqrt(-5.4289D);
        assertEquals(res, 2.33D, 0.01);
    }
    @Test
    public void sinDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sinDouble"));
        double res = MyCalculator.sin(0.52D);
        assertEquals(res, 0.5D, 0.01);
    }
    @Test
    public void cosDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "cosDouble"));
        double res = MyCalculator.cos(0.7D);
        assertEquals(res, 0.76D, 0.01);
    }
    @Test
    public void tgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "tgDouble"));
        double res = MyCalculator.tg(0.61D);
        assertEquals(res, 0.7D, 0.01);
    }
    @Test
    public void ctgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "ctgDouble"));
        double res = MyCalculator.ctg(0.45D);
        assertEquals(res, 2.07D, 0.01);
    }
    @Test
    public void booleanPositive() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "booleanPositive"));
        boolean res = MyCalculator.isPositive(10);
        assertEquals(res, true);
    }
    @Test
    public void booleanNull() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "booleanNull"));
        boolean res = MyCalculator.isPositive(0);
        assertEquals(res, false);
    }
    @Test
    public void booleanNegative() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "booleanNegative"));
        boolean res = MyCalculator.isNegative(-10);
        assertEquals(res, true);
    }
    @AfterMethod
    public void tearDown(){
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "tearDown"));
        MyCalculator = null;
        System.out.println("<End of test>");
        System.out.println("=====");
        System.out.println();
    }

    @AfterClass
    public void afterClass(){
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "afterClass"));
        System.out.println("*****");
        System.out.println();
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println(String.format("Class: %s, method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "afterSuite"));
        System.out.println("+++++");
        System.out.println();
    }
}