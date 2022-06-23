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

    public static final String MAILRU_URL = "https://mail.ru";
    public static WebElement lastDraftMessage;
    public static WebElement ourDraftMessageReceiver;

    public static WebElement ourDraftMessageSubject;

    public static WebElement ourDraftMessageBody;
    String username = "elekon612@mail.ru";
    String password = "Selenium2022";
    CharSequence inboxURL = "https://e.mail.ru/inbox";
    CharSequence draftsURL = "https://e.mail.ru/drafts";
    protected static String receiver = "elena.volnova@mail.ru";
    String subject = "New TestLetter Subject";
    String letterBody = "New TestLetter Body";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected WebElement inboxPage;

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
