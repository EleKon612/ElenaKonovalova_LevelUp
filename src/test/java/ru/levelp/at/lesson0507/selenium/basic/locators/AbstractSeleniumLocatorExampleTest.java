package ru.levelp.at.lesson0507.selenium.basic.locators;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class AbstractSeleniumLocatorExampleTest {

    private static final String GOOGLE_URL = "https://google.com";

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", this.getClass()
            .getResource("/ru/levelp/at/lesson0507/selenium/basic/drivers/chromedriver").getPath());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
        SleepUtils.sleep(750);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
