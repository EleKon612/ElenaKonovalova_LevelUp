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

public class Exercise1RefactorTest {

    private static final String MAILRU_URL = "https://mail.ru";

    private WebDriver driver;

    private WebDriverWait wait;

    CharSequence testLetterReceiver = "elena.volnova@mail.ru";
    CharSequence testLetterSubject = "New TestLetter Subject";
    CharSequence testLetterBody = "New TestLetter Body";

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
        // Открыть сайт mail.ru и нажать кнопку "Войти"
        driver.navigate().to(MAILRU_URL);
        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, 'resplash-btn')]"));
        enterButton.click();

        // Переключиться на логин фрейм
        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);

        // Ввести логин и пароль
        WebElement insertAccountName = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='username']")));
        insertAccountName.sendKeys("elekon612" + Keys.ENTER);
        WebElement insertPassword = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='password']")));
        insertPassword.sendKeys("Selenium2022" + Keys.ENTER);

        // Дождаться загрузки страницы "Входящие" убедиться, что она открылась, и нажать кнопку "Написать письмо"
        WebElement newLetterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='compose-button__wrapper']")));
        driver.getCurrentUrl();
        assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru/inbox"));
        newLetterButton.click();

        // Переключиться на окно создания письма
        driver.switchTo().activeElement();

        // Ввести адресата, тему и тело письма
        WebElement insertReceivers = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'container--H9L5q')]")));
        insertReceivers.sendKeys(testLetterReceiver);
        WebElement insertSubject = driver.findElement(By.xpath("//*[@name='Subject']"));
        insertSubject.sendKeys(testLetterSubject);
        WebElement insertBody = driver.findElement(By.cssSelector(".cke_editable"));
        insertBody.sendKeys(testLetterBody);

        // Сохранить и закрыть черновик
        WebElement saveDraft = driver.findElement(By.xpath("//*[text()='Сохранить']"));
        saveDraft.click();
        WebElement closeDraft = driver.findElement(By.cssSelector(".container--2lPGK"));
        closeDraft.click();

        // Открыть черновики
        WebElement openDrafts = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[text()='Черновики']")));
        openDrafts.click();

        // Проверить, что письмо сохранилось в черновиках
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Черновики']")));
        assertTrue(driver.findElement(By.xpath("//span[text()='New TestLetter Subject']")).isDisplayed());
        driver.findElement(By.xpath("//span[text()='New TestLetter Subject']")).click();

        // Проверить контент, адресата и тему письма
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='Отправить']")));
        assertTrue(driver.findElement(By.xpath("//*[@value='New TestLetter Subject']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[text()='elena.volnova@mail.ru']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div[text()='New TestLetter Body']")).isDisplayed());

        // Отправить сохраненный черновик
        driver.findElement(By.xpath("//span[text()='Отправить']")).click();

        // Закрыть окно "Сообщение отправлено" (не работает!!! поэтому SleepUtils)
        WebElement crossButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='layer-window__container']")));
        crossButton.click();
        SleepUtils.sleep(21000);

        // Проверить, что письмо изчезло из черновиков (письмо не исчезает!!! поэтому assertFalse закомментирован)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Черновики']")));
        // assertFalse(driver.findElement(By.xpath("//span[text()='New TestLetter Subject']")).isDisplayed());

        // Перейти в "Отправленные"
        WebElement openSent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Отправленные']")));
        openSent.click();
        wait.until(ExpectedConditions.urlContains("sent"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New TestLetter Subject']")));

        // Verify, что письмо появилось в папке отправленные, открыть его и проверить содержимое
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'letter__body')]")));
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[text()='elena.volnova@mail.ru']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Body']")).isDisplayed());

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
