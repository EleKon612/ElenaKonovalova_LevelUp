package ru.levelp.at.lesson0507.selenium.pageobjects.homework5.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMainPage;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorPostPage;
import ru.levelp.at.lesson0507.selenium.pageobjects.homework5.steps.Homework5Steps;

public abstract class Homework5RefactorBaseStepsTest {
    protected Homework4RefactorMainPage mainPage;
    protected Homework4RefactorPostPage postPage;
    protected Homework5Steps steps;

    protected WebDriver driver;
    protected WebDriverWait wait;

    final String username = ConfProperties.getProperty("username");
    final String password = ConfProperties.getProperty("password");
    final String receiver1 = ConfProperties.getProperty("receiver1");
    final String subject1 = ConfProperties.getProperty("subject1");
    final String letterBody1 = ConfProperties.getProperty("letterBody1");
    final String receiver2 = ConfProperties.getProperty("receiver2");
    final String receiverInbox2 = ConfProperties.getProperty("receiverInbox2");
    final String subject2 = ConfProperties.getProperty("subject2");
    final String letterBody2 = ConfProperties.getProperty("letterBody2");
    final String receiver3 = ConfProperties.getProperty("receiver3");
    final String receiverInbox3 = (ConfProperties.getProperty("receiverInbox3"));
    final String subject3 = ConfProperties.getProperty("subject3");
    final String letterBody3 = ConfProperties.getProperty("letterBody3");
    final String mailRuURL = ConfProperties.getProperty("mailRuURL");
    final String inboxURL = ConfProperties.getProperty("inboxURL");
    final String draftsURL = ConfProperties.getProperty("draftsURL");
    final String sentURL = ConfProperties.getProperty("sentURL");
    final String trashURL = ConfProperties.getProperty("trashURL");
    final String testFolderURL = ConfProperties.getProperty("testFolderURL");

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new Homework4RefactorMainPage(driver);
        postPage = new Homework4RefactorPostPage(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        steps = new Homework5Steps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}