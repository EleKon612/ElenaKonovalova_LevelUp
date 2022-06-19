package ru.levelp.at.lesson0507.selenium.basic.homework3;

import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class Exercise1MailruImplicitTest {

    private static final String MAILRU_URL = "https://mail.ru";

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void enterMailruTest() {
        driver.navigate().to(MAILRU_URL);

        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, "
            + "'resplash-btn resplash-btn_primary resplash-btn_mailbox-big svelte-vawtzz')]"));
        enterButton.click();

        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);

        WebElement insertAccountName = driver.findElement(By.cssSelector("[name='username']"));
        insertAccountName.sendKeys("elekon612" + Keys.ENTER);

        WebElement insertPassword = driver.findElement(By.cssSelector("[name='password']"));
        insertPassword.sendKeys("Lubrasil5D" + Keys.ENTER);

        SleepUtils.sleep(3000);
        String InboxURL = driver.getCurrentUrl();
        assertTrue(driver.getCurrentUrl().contains("e.mail.ru/inbox"));

        WebElement newLetterButton = driver.findElement(By.xpath
            ("//*[@class='compose-button__wrapper']"));
        newLetterButton.click();

        SleepUtils.sleep(3000);
        WebElement insertReceivers = driver.findElement(By.xpath("//*[@class='input--3slxg']"));
        insertReceivers.sendKeys("elena.volnova@mail.ru");
        WebElement insertSubject = driver.findElement(By.xpath("//div/input[@name='subject']"));
        insertSubject.sendKeys("TestLetter Subject");
        WebElement insertBody = driver.findElement(By.cssSelector(".cke_editable"));
        insertBody.sendKeys("TestLetter body");
        WebElement saveDraft = driver.findElement(By.xpath("//*[text()='Сохранить']"));
        saveDraft.click();
        WebElement closeDraft = driver.findElement(By.cssSelector(".container--2lPGK"));
        closeDraft.click();
        WebElement goToDrafts = driver.findElement(By.cssSelector("[class='nav__folder-ico']"));
        goToDrafts.click();
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
