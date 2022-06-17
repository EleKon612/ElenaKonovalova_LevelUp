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

public class Exercise1MailruTest {

    private static final String MAILRU_URL = "https://mail.ru";

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
        driver.navigate().to(MAILRU_URL);
        assertEquals(driver.getTitle(), "Mail.ru: почта, поиск в интернете, новости, игры");

        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, " +
            "'resplash-btn resplash-btn_primary resplash-btn_mailbox-big svelte-vawtzz')]"));
        enterButton.click();

        WebElement loginFrame = driver.findElement(By.xpath
            ("//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);

        /*WebElement printAccountName = driver.findElement(By.xpath("//*[contains(@placeholder, " +
            "'Account name')]"));
        printAccountName.sendKeys("elekon612" + Keys.ENTER);*/

        WebElement printAccountName = driver.findElement(By.xpath
            ("//div/input[@placeholder='Account name']"));
        printAccountName.sendKeys("elekon612" + Keys.ENTER);

        /*WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='iframe-0-2-16']"));
        driver.switchTo().frame(loginFrame);*/

        /*WebElement printPassword = driver.findElement(By.xpath("//*[contains(@name," + "'password')]"));
        printPassword.sendKeys("Lubrasil5D" + Keys.ENTER);*/
    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
