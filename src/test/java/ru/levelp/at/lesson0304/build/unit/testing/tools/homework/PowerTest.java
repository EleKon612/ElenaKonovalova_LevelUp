package ru.levelp.at.lesson0304.build.unit.testing.tools.homework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class PowerTest extends BeforeAfterHooksTest {

    @Test
    public void powDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "powDouble"));
        double res = calculator.pow(2.2D, 3.3D);
        assertEquals(res, 10.648D, 0.001);
    }
}