package ru.levelp.at.lesson0304.build.unit.testing.tools.homework;

import org.testng.annotations.DataProvider;

public class HomeworkExternalDataProvider {

    @DataProvider(name = "Test Data for sumLong Method")
    public static Object[][] sumLongDataProvider() {
        return new Object[][] {
            {4, 2, 6},
            {77, 110, 187},
            {1000, 1, 1001},
        };
    }

    @DataProvider(name = "Test Data for sumDouble Method")
    public static Object[][] sumDoubleDataProvider() {
        return new Object[][] {
            {4.0, 2.3, 6.3},
            {77.11, 110.33, 187.44},
            {1000.01, 1.003, 1001.013},
        };
    }
}