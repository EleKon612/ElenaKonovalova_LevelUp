package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Exercise1Refactor;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Exercise1RefactorBasePage;
import ru.levelp.at.lesson0507.selenium.page.objects.voids.UsersBugRedLoginRegistrationPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static ru.levelp.at.lesson0507.selenium.page.objects.homework4.Exercise1Refactor.MAILRU_URL;

public class Exercise1RefactorTest {
    private WebDriver driver;
    private WebDriverWait wait;

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

    @Test
    public void exercise1Test() {
        Exercise1Refactor mailRu = new Exercise1Refactor(driver);
        driver.navigate().to(MAILRU_URL);

        String username = "elekon612@mail.ru";
        String password = "Selenium2022";
        String testLetterReceiver = "elena.volnova@mail.ru";
        String testLetterSubject = "New TestLetter Subject";
        String testLetterBody = "New TestLetter Body";

        mailRu.clickLoginButton();
        mailRu.switchToLoginFrame();
        mailRu.insertUsername(username);
        mailRu.clickEnterPasswordButton();
        mailRu.insertPassword(password);
        mailRu.clickSignInButton();

        mailRu.clickNewLetterButton();

    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
