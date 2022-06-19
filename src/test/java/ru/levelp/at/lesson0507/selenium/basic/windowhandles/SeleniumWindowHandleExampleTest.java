package ru.levelp.at.lesson0507.selenium.basic.windowhandles;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumWindowHandleExampleTest {

    private static final String GOOGLE_URL = "https://google.com";
    private static final String YA_URL = "https://ya.ru";
    private static final String YANDEX_URL = "https://yandex.ru";
    private static final String EPAM_URL = "https://epam.com";

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", this.getClass()
            .getResource("/ru/levelp/at/lesson0507/selenium/basic/drivers/chromedriver").getPath());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogleTest() {
        // открываем гугл
        driver.navigate().to(GOOGLE_URL);
        var windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After open Google window handles are %s", GOOGLE_URL, windowHandles));

        // открываем ya.ru
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YA_URL);
        windowHandles = driver.getWindowHandles();
        // var yaRuWindowHandle = driver.getWindowHandle();
        System.out.println(String.format("After open Ya.ru window handles are %s", YA_URL, windowHandles));

        // открываем yandex.ru
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(YANDEX_URL);
        windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After open Yandex.ru window handles are %s", YANDEX_URL, windowHandles));

        // закрываем yandex.ru
        driver.close();
        windowHandles = driver.getWindowHandles();
        // driver.switchTo().window(yaRuWindowHandle);
        System.out.println(String.format("After close Yandex.ru window handles are %s", YANDEX_URL, windowHandles));
        driver.switchTo().defaultContent();

        // открываем epam.com
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(EPAM_URL);
        windowHandles = driver.getWindowHandles();
        System.out.println(String.format("After open epam.com window handles are %s", EPAM_URL, windowHandles));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
