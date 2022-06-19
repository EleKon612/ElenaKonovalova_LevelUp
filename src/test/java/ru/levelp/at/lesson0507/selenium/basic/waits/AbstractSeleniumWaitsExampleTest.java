package ru.levelp.at.lesson0507.selenium.basic.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractSeleniumWaitsExampleTest {

    protected static final String GOOGLE_URL = "https://google.com";

    protected static final String SEARCH_STRING = "selenium";

    protected static final Integer EXPECTED_SEARCH_RESULT_SIZE = 13;
    protected static final String EXPECTED_FIRST_LINK_TITLE = "Selenium";

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
            WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
        SleepUtils.sleep(750);
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
