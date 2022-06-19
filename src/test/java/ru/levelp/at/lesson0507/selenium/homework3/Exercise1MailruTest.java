package ru.levelp.at.lesson0507.selenium.homework3;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
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

        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, "
            + "'resplash-btn resplash-btn_primary resplash-btn_mailbox-big svelte-vawtzz')]"));
        enterButton.click();

        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);

        /*WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.click();*/

        WebElement username = driver.switchTo().activeElement();
        username.sendKeys("elekon612" + Keys.ENTER);

        /*WebElement printAccountName = driver.findElement(By.xpath("//input[@name='username']"));
        printAccountName.sendKeys("elekon612" + Keys.ENTER);*/
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
