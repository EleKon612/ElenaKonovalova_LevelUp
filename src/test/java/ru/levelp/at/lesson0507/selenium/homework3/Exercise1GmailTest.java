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

public class Exercise1GmailTest {

    private static final String GMAIL_URL = "https://gmail.com";

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
        driver.navigate().to(GMAIL_URL);
        // assertEquals(driver.getTitle(), "Gmail");

        WebElement printAccountName = driver.findElement(By.xpath(
            "//*[contains(@class, 'N3Hzgf')]"));
        printAccountName.sendKeys("elekon612" + Keys.ENTER);

        WebElement printPassword = driver.findElement(By.xpath("//*[contains(@type," + "'password')]"));
        printPassword.sendKeys("Selenium-2022" + Keys.ENTER);
    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
