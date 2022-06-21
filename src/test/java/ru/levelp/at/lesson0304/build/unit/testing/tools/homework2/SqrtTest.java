package ru.levelp.at.lesson0304.build.unit.testing.tools.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SqrtTest extends BeforeAfterHooksTest {

    @Test
    public void sqrtDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sqrtDouble"));
        double res = calculator.sqrt(-5.4289D);
        assertEquals(res, 2.33D, 0.01);
    }
}