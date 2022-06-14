package ru.levelp.at.lesson0304.build.unit.testing.tools.dataprovider;

import java.security.SecureRandom;
import java.util.Random;
import org.testng.annotations.DataProvider;

public class ExternalDataProvider {

    @DataProvider
    public static Object[][] sumDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 4, 7},
            {8, 9, 17},
        };
    }

    @DataProvider(name = "Test Data for Divide Method")
    public static Object[][] divDataProvider() {
        return new Object[][] {
            {4.4, 2, 2.2},
            {77, 11, 7},
            {9, 9, 1},
        };
    }

    // Random test data provider example
    // @DataProvider(name = "Random Test Data for Power Method")
    // public static Object[][] powerDataProvider() {
    //    Object[][] array = new Object[][] {
    //        {4, 2, 16},
    //        {2, 3, 8},
    //        {2, 10, 1024},
    //    };

    //  Random rnd = new SecureRandom();
    //  int randomRow = rnd.nextInt(array.length);
    //    return new Object[][] {
    //        array[randomRow]
    //    };
    // }
}
