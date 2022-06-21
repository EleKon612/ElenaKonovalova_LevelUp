package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Exercise2RefactorTest {

    private static final String MAILRU_URL = "https://mail.ru";

    private WebDriver driver;

    private WebDriverWait wait;

    CharSequence testLetterReceiver = "elekon612@mail.ru";
    CharSequence testLetterSubject = "Тест";
    CharSequence testLetterBody = "Я помню чудное мгновенье";

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
    public void exercise2Test() {
        // Войти в почту
        driver.navigate().to(MAILRU_URL);
        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, 'resplash-btn')]"));
        enterButton.click();
        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);
        WebElement insertAccountName = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='username']")));
        insertAccountName.sendKeys("elekon612" + Keys.ENTER);
        WebElement insertPassword = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='password']")));
        insertPassword.sendKeys("Selenium2022" + Keys.ENTER);

        // Assert, что вход выполнен успешно
        WebElement newLetterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='compose-button__wrapper']")));
        driver.getCurrentUrl();
        assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru/inbox"));

        // Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест) и тело)
        newLetterButton.click();
        driver.switchTo().activeElement();
        WebElement insertReceivers = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'container--H9L5q')]")));
        insertReceivers.sendKeys(testLetterReceiver);
        WebElement insertSubject = driver.findElement(By.xpath("//*[@name='Subject']"));
        insertSubject.sendKeys(testLetterSubject);
        WebElement insertBody = driver.findElement(By.cssSelector(".cke_editable"));
        insertBody.sendKeys(testLetterBody);

        // Отправить письмо
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='Отправить']")));
        WebElement sentWindow = driver.switchTo().activeElement();
        sentWindow.sendKeys(Keys.COMMAND, Keys.ENTER);

        // Закрыть окно "Сообщение отправлено" (не работает!!! поэтому SleepUtils)
        WebElement crossButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='layer-window__container']")));
        crossButton.click();
        SleepUtils.sleep(21000);

        // Verify, что письмо появилось в папке отправленные
        WebElement openSent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Отправленные']")));
        openSent.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Self: Тест']")));
        assertTrue(driver.findElement(By.xpath("//*[text()='Self: Тест']")).isDisplayed());

        // Verify, что письмо появилось в папке «Тест»
        WebElement openSaved = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Тест']")));
        openSaved.click();
        WebElement sentLetterInTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//span[text()='Тест']")));
        assertTrue(driver.findElement(By.xpath("//span[text()='Тест']")).isDisplayed());

        // Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        sentLetterInTest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/h2[text()='Тест']")));
        assertTrue(driver.findElement(By.xpath("//div/h2[text()='Тест']")).isEnabled());
        assertTrue(driver.findElement(By.xpath("//*[@title='elekon612@mail.ru']")).isEnabled());
        assertTrue(driver.findElement(By.xpath("//div[text()='Я помню чудное мгновенье']")).isEnabled());

        //  Выйти из учетной записи
        WebElement dropDown = driver.findElement(By.xpath(
                "//span[contains(@class, 'ph-dropdown-icon')]"));
        dropDown.click();
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Выйти']")));
        logout.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
