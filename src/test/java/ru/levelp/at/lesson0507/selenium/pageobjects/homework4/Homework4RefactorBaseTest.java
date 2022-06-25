package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public abstract class Homework4RefactorBaseTest {

    protected final String inboxURL = "https://e.mail.ru/inbox";
    protected final String draftsURL = "https://e.mail.ru/drafts";
    protected final String sentURL = "https://e.mail.ru/sent";
    protected final String username = "elekon612@mail.ru";
    protected final String password = "Selenium2022";
    protected final String receiver = "elena.volnova@mail.ru";
    protected final String subject = "New TestLetter Subject";
    protected final String letterBody = "New TestLetter Body";

    protected WebDriver driver;
    protected WebDriverWait wait;

    // protected static WebElement inboxPage;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
