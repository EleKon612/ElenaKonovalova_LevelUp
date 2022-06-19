package ru.levelp.at.lesson0507.selenium.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Exercise1YahooTest {

    private static final String YAHOO_URL = "https://mail.yahoo.com";

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        SleepUtils.sleep(750);
    }

    @Test
    public void enterYahooTest() {
        driver.navigate().to(YAHOO_URL);

        WebElement signInButton = driver.findElement(By.xpath
            ("//div/a[@class='fuji-button-link fuji-button-inverted signin']"));
        signInButton.click();


        WebElement insertUsername = driver.findElement(By.xpath("//*[@class='phone-no']"));
        insertUsername.sendKeys("elekon612" + Keys.ENTER);

        WebElement insertPassword = driver.findElement(By.xpath("//*[@class='password']"));
        insertPassword.sendKeys("Selenium2022" + Keys.ENTER);
        /*Assert.assertTrue(driver.getTitle().contains("Yahoo Почта"));*/
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
