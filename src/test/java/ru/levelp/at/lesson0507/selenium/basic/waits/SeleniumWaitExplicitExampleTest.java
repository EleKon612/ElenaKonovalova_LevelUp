package ru.levelp.at.lesson0507.selenium.basic.waits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWaitExplicitExampleTest extends AbstractSeleniumWaitsExampleTest {

    private WebDriverWait wait;

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    @Test
    public void googleSearchTest() {
        // driver.findElement(By.cssSelector("[name='q']"));
        WebElement searchTextBox = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='q']")));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        // driver.findElements(By.cssSelector("div#search a > h3"));
        var searchResults = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.cssSelector("div#search a > h3"), EXPECTED_SEARCH_RESULT_SIZE));
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }
}
