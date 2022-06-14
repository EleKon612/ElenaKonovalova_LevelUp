package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InternalDataProviderExampleTest extends BaseDataProviderTest {

    @DataProvider
    public static Object[][] addDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 4, 7},
            {8, 9, 17},
        };
    }

    @Test(dataProvider = "addDataProvider")
    public void sumTest(double a, double b, double expectedResult) {
        System.out.println(String.format("Class: %s, test method: %s", InternalDataProviderExampleTest.class
            .getCanonicalName(), "sumTest"));
        double res = calculator.sum(a, b);
        assertEquals(res, expectedResult);
    }

    @DataProvider(name = "Test Data for Divide Method")
    public static Object[][] divideDataProvider() {
        return new Object[][] {
            {4.4, 2, 2.2},
            {77, 11, 7},
            {9, 9, 1},
        };
    }

    @Test(dataProvider = "Test Data for Divide Method")
    public void divTest(double a, double b, double expectedResult) {
        System.out.println(String.format("Class: %s, test method: %s", InternalDataProviderExampleTest.class
            .getCanonicalName(), "divTest"));
        double res = calculator.div(a, b);
        assertEquals(res, expectedResult);
    }
}
