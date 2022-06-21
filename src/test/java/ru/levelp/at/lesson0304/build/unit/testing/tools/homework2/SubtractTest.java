package ru.levelp.at.lesson0304.build.unit.testing.tools.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SubtractTest extends BeforeAfterHooksTest {

    @Test
    public void subLong() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(), "subLong"));
        long res = calculator.sub(4, 2);
        assertEquals(res, 2L);
    }

    @Test
    public void subDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "subDouble"));
        double res = calculator.sub(5.2, 4.1);
        assertEquals(res, 1.1D, 0.01);
    }
}