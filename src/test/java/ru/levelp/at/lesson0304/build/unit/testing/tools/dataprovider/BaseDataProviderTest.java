package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class BaseDataProviderTest {

    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("=start=");
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(String.format("Class: %s, method %s", this.getClass().getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=end=");
        System.out.println();
    }
}