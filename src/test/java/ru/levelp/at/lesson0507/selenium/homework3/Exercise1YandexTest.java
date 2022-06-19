package ru.levelp.at.lesson0507.selenium.homework3;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Exercise1YandexTest {

    private static final String YANDEX_MAIL_URL = "https://mail.yandex.ru";

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
    public void enterMailruTest() {
        driver.navigate().to(YANDEX_MAIL_URL);
        // assertEquals(driver.getTitle(), "Mail.ru: почта, поиск в интернете, новости, игры");

        WebElement enterMailLink = driver.findElement(By.linkText("Войти"));
        enterMailLink.click();

        WebElement loginTextBox = driver.findElement(By.id("passp-field-login"));
        loginTextBox.sendKeys("elekon612" + Keys.ENTER);
    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
