package ru.levelp.at.lesson0507.selenium.basic.homework3;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.utils.SleepUtils;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
        SleepUtils.sleep(3000);

        String InboxURL = driver.getCurrentUrl();
        assertEquals(InboxURL, "https://mail.rambler.ru/folder/INBOX");

        WebElement newLetterButton = driver.findElement(By.xpath("//*[@class='rui-Button-content']"));
        newLetterButton.click();

        WebElement insertReceivers = driver.findElement(By.xpath("//span/input[@id='receivers']"));
        insertReceivers.sendKeys("elena.volnova@mail.ru");
        WebElement insertSubject = driver.findElement(By.xpath("//div/input[@id='subject']"));
        insertSubject.sendKeys("TestLetter Subject");
        /*WebElement insertBody = driver.findElement(By.xpath("//*[@id='tinymce']"));
        insertBody.sendKeys("TestLetter body");*/
        WebElement saveDraft = driver.findElement(By.xpath("//*[text()='Сохранить черновик']"));
        saveDraft.click();
        WebElement goToDrafts = driver.findElement(By.xpath("//*[text()='Черновики']"));
        goToDrafts.click();

        ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("ListItem-subject-2M")),
            "TestLetter Subject");
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
