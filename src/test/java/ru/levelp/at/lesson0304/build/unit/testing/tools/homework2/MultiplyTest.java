package ru.levelp.at.lesson0304.build.unit.testing.tools.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MultiplyTest extends BeforeAfterHooksTest {

    @Test
    public void multLong() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(), "multLong"));
        long res = calculator.mult(2, 3);
        assertEquals(res, 6L);
    }

    @Test
    public void multDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "multDouble"));
        double res = calculator.mult(2.3D, 4.6D);
        assertEquals(res, 10.58D, 1);
    }
}