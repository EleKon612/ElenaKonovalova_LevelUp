package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson0304.build.unit.testing.tools.homework2.BeforeAfterHooksTest;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class BaseCalculatorBeforeAfterGroupsHookTest extends BeforeAfterHooksTest {

    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "setUp"));
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(), "tearDown"));
        calculator = null;
        System.out.println("=====");
        System.out.println();
    }

    @BeforeGroups(groups = {"sum"})
    public void beforeSumGroup() {
        System.out.println("*****");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(),
            "beforeSumGroup"));
    }

    @AfterGroups(groups = {"integer"})
    public void afterIntegerGroup() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(),
            "afterIntegerGroup"));
        System.out.println("*****");
    }

    @BeforeGroups(groups = {"sum", "double"})
    public void beforeSumDoubleGroup() {
        System.out.println("-----");
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(),
            "beforeSumDoubleGroup"));
    }

    @AfterGroups(groups = {"integer", "multiply"})
    public void afterIntegerMultiplyGroup() {
        System.out.println(String.format("Class: %s, method: %s", this.getClass().getCanonicalName(),
            "afterIntegerMultiplyGroup"));
        System.out.println("%%%%%");
    }
}
