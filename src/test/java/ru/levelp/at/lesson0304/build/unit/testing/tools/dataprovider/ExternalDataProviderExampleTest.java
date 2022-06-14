package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExternalDataProviderExampleTest extends BaseDataProviderTest {

    @Test(dataProvider = "sumDataProvider", dataProviderClass = ExternalDataProvider.class)
    public void sumTest(double a, double b, double expectedResult) {
        System.out.println(String.format("Class: %s, test method: %s", ExternalDataProviderExampleTest.class
            .getCanonicalName(), "sumTest"));
        double res = calculator.sum(a, b);
        assertEquals(res, expectedResult);
    }

    @Test(dataProvider = "Test Data for Divide Method", dataProviderClass = ExternalDataProvider.class)
    public void divTest(double a, double b, double expectedResult) {
        System.out.println(String.format("Class: %s, test method: %s", ExternalDataProviderExampleTest.class
            .getCanonicalName(), "divTest"));
        double res = calculator.div(a, b);
        assertEquals(res, expectedResult);
    }

    // Random Test Data provider example
    // @Test(dataProvider = "Random Test Data for Power Method", dataProviderClass = ExternalDataProvider.class)
    // public void powTest(int a, int b, int expectedResult) {
    //    System.out.println(String.format("Class: %s, test method: %s", ExternalDataProviderExampleTest.class
    //        .getCanonicalName(), "powTest"));
    //    int res = (int) MyCalculator.powInt(a, b);
    //    assertEquals(res, expectedResult);
    // }
}
