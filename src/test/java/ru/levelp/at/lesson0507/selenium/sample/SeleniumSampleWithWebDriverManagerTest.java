package ru.levelp.at.lesson0507.selenium.sample;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumSampleWithWebDriverManagerTest {

    private static final String GOOGLE_URL = "https://google.com";

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogleTest() {
        driver.navigate().to(GOOGLE_URL);
        assertEquals(driver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
