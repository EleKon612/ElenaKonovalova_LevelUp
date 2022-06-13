package ru.levelp.at.lesson0304.build.unit.testing.tools;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class CalculatorSimpleTest {

    @Test
    public void sum2And2() {
        Calculator calculator = new Calculator();
        long res = calculator.sum(2, 2);
    }
}
