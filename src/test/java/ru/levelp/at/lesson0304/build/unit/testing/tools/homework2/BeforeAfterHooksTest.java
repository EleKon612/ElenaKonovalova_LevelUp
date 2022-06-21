package ru.levelp.at.lesson0304.build.unit.testing.tools.homework2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.calculator.Calculator;

public class BeforeAfterHooksTest {

    protected Calculator calculator;

    /* This method is optional
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("+++++");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "beforeSuite"));
        System.out.println();
    }*/

    /* This method is optional
    @BeforeTest
    public void beforeTest() {
        System.out.println("-----");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "beforeTest"));
        System.out.println();
    }*/

    /* This method is optional
    @BeforeClass
    public void beforeClass() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "beforeClass"));
    }*/

    @BeforeMethod
    public void setUp() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }

    /* This method is optional
    @AfterClass
    public void afterClass() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "afterClass"));
        System.out.println("*****");
        System.out.println();
    }*/

    /* This method is optional
    @AfterTest
    public void afterTest() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "afterTest"));
        System.out.println("-----");
        System.out.println();
    }*/

    /* This method is optional
    @AfterSuite
    public void afterSuite() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "afterSuite"));
        System.out.println("+++++");
        System.out.println();
    }*/
}