package ru.levelp.at.lesson0507.selenium.basic.waits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumWithoutWaitThreadSleepTest extends AbstractSeleniumWaitsExampleTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
    }

    @Test
    public void googleSearchTest() {
        WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']"));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        var searchResults = driver.findElements(By.cssSelector("div#search a > h3"));
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }
}
