package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class BaseCalculatorBeforeAfterHookInheritanceTest {

    protected Calculator MyCalculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("+++++");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "beforeSuite"));
        System.out.println();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "beforeClass"));
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("<Start of test>");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "setUp"));
        MyCalculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "tearDown"));
        MyCalculator = null;
        System.out.println("<End of test>");
        System.out.println("=====");
        System.out.println();
    }

    @AfterClass
    public void afterClass() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "afterClass"));
        System.out.println("*****");
        System.out.println();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "afterSuite"));
        System.out.println("+++++");
        System.out.println();
    }
}
