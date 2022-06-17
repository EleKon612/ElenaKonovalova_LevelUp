package ru.levelp.at.lesson0304.build.unit.testing.tools.homework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class DivideTest extends BeforeAfterHooksTest {

    @Test
    public void divLong() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(), "divLong"));
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
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "divDouble"));
        double res = calculator.div(3.1725D, 2.35D);
        assertEquals(res, 1.35D, 0.01);
    }
}