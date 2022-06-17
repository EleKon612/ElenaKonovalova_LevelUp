package ru.levelp.at.lesson0304.build.unit.testing.tools.homework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class PositiveNegativeTest extends BeforeAfterHooksTest {

    @Test
    public void booleanPositive() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "booleanPositive"));
        boolean res = calculator.isPositive(10);
        assertEquals(res, true);
    }

    @Test
    public void booleanNull() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "booleanNull"));
        boolean res = calculator.isPositive(0);
        assertEquals(res, false);
    }

    @Test
    public void booleanNegative() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "booleanNegative"));
        boolean res = calculator.isNegative(-10);
        assertEquals(res, true);
    }
}