package ru.levelp.at.lesson0304.build.unit.testing.tools.hooks.inheritance;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class MyCalculatorBeforeAfterSuiteHookTest extends BaseCalculatorBeforeAfterHookTest {

    @Test
    public void sum2And2() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass()
            .getCanonicalName(), "sum2And2"));
        long res = MyCalculator.sum(2, 2);
        assertEquals(res, 4L, "Incorrect");
    }

    @Test
    public void sum2point0and4point0(){
        System.out.println(String.format("Class: %s, test method: %s", this.getClass()
            .getCanonicalName(), "sum2point0and4point0"));
        double res = MyCalculator.sum(2.0D, 4.0D);
        assertEquals(res, 6.0D);
    }
}