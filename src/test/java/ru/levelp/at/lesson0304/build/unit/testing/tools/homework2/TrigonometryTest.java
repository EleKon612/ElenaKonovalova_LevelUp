package ru.levelp.at.lesson0304.build.unit.testing.tools.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TrigonometryTest extends BeforeAfterHooksTest {

    @Test
    public void sinDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sinDouble"));
        double res = calculator.sin(0.52D);
        assertEquals(res, 0.5D, 0.01);
    }

    @Test
    public void cosDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "cosDouble"));
        double res = calculator.cos(0.7D);
        assertEquals(res, 0.76D, 0.01);
    }

    @Test
    public void tgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "tgDouble"));
        double res = calculator.tg(0.61D);
        assertEquals(res, 0.7D, 0.01);
    }

    @Test
    public void ctgDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "ctgDouble"));
        double res = calculator.ctg(0.45D);
        assertEquals(res, 2.07D, 0.01);
    }
}