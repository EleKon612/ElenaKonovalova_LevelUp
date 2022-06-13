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
        assertEquals(res, 6.9D);
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
        double res = MyCalculator.sub(5.0D, 4.0D);
        assertEquals(res, 1.0D);
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
        assertEquals(res, 10.0D);
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
        double res = MyCalculator.div(9.0D, 3.0D);
        assertEquals(res, 3.0D);
    }
    @Test
    public void powDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "powDouble"));
        double res = MyCalculator.pow(2.2D, 3.3D);
        assertEquals(res, 10.648000000000003D);
    }
    @Test
    public void sqrtDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sqrtDouble"));
        double res = MyCalculator.sqrt(-9.0D);
        assertEquals(res, 3.0D);
    }
    @Test
    public void sinDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "sinDouble"));
        double res = MyCalculator.sin(30.0D);
        assertEquals(res, -0.9880316240928618D);
    }
    @Test
    public void cosDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "cosDouble"));
        double res = MyCalculator.cos(30.0D);
        assertEquals(res, 0.15425144988758405D);
    }
    @Test
    public void tgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "tgDouble"));
        double res = MyCalculator.tg(30.0D);
        assertEquals(res, -6.405331196646276D);
    }
    @Test
    public void ctgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", MyCalculatorHomeworkAllClasses.class
            .getCanonicalName(), "ctgDouble"));
        double res = MyCalculator.ctg(30.0D);
        assertEquals(res, -0.15611995216165922D);
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