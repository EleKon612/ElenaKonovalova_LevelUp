package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AbstractSeleniumLocatorExampleTest {

    private static final String GOOGLE_URL = "https://google.com";

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", this.getClass()
            .getResource("/ru/levelp/at/lesson0507/selenium/drivers/chromedriver").getPath());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
