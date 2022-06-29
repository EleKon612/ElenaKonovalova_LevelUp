package ru.levelp.at.lesson0304.build.unit.testing.tools.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SumTest extends BeforeAfterHooksTest {

    @Test
    public void sumLong() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(), "sumLong"));
        long res = calculator.sum(2, 2);
        assertEquals(res, 4L);
    }

    @Test(dataProvider = "Test Data for sumLong Method", dataProviderClass = DataProviders.class)
    public void sumLongWithDataProvider(long a, long b, long expectedResult) {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sumLongWithDataProvider"));
        long res = calculator.sum(a, b);
        assertEquals(res, expectedResult);
    }

    @Test
    public void sumDouble() {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sumDouble"));
        double res = calculator.sum(4.3D, 2.6D);
        assertEquals(res, 6.9D, 0.01);
    }

    @Test(dataProvider = "Test Data for sumDouble Method", dataProviderClass = DataProviders.class)
    public void sumDoubleWithDataProvider(double a, double b, double expectedResult) {
        System.out.println(String.format("Class: %s, test method: %s", this.getClass().getCanonicalName(),
            "sumDoubleWithDataProvider"));
        double res = calculator.sum(a, b);
        assertEquals(res, expectedResult, 0.001);
    }
}