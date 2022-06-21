package ru.levelp.at.lesson0507.selenium.pageobjects;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractSeleniumBaseTest {

    protected static final String USERS_BUGRED = "http://users.bugred.ru";
    protected static final String USERS_BUGRED_LOGIN_REG_PAGE_URL = USERS_BUGRED + "/user/login/index.html";

    protected static final Faker FAKER = new Faker();

    protected WebDriver driver;

    protected WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(USERS_BUGRED_LOGIN_REG_PAGE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
