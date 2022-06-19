package ru.levelp.at.lesson0507.selenium.homework3;

import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Exercise1RamblerTest {

    private static final String RAMBLER_URL = "https://mail.rambler.ru";

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("user-data-dir=C:/Users/ekonovalova/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void enterRamblerTest() {
        driver.navigate().to(RAMBLER_URL);

        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@src='https://id.rambler.ru/login-20/login?=undefined&rname=mail&theme"
                + "=&session=false&back=https%3A%2F%2Fmail.rambler.ru%2F&param=embed&iframeOrigin"
                + "=https%3A%2F%2Fmail.rambler.ru']"));
        driver.switchTo().frame(loginFrame);

        WebElement insertAccountName = driver.findElement(By.xpath("//div/input[@id='login']"));
        insertAccountName.sendKeys("elekon612@rambler.ru");
        WebElement insertPassword = driver.findElement(By.xpath("//div/input[@id='password']"));
        insertPassword.sendKeys("Selenium2022" + Keys.ENTER);
        var ramblerInbox = driver.getWindowHandle();
        driver.switchTo().window(ramblerInbox);
        assertTrue(driver.getCurrentUrl().contains("INBOX"));
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
