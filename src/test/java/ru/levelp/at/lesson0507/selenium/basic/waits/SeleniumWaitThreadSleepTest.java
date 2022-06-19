package ru.levelp.at.lesson0507.selenium.basic.waits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumWaitThreadSleepTest extends AbstractSeleniumWaitsExampleTest {

    @Test
    public void googleSearchTest() {
        WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']"));
        searchTextBox.sendKeys(SEARCH_STRING + Keys.ENTER);

        SleepUtils.sleep(2500);
        // div#search a > h3 (чтобы сузить поиск и найти локатор)
        var searchResults = driver.findElements(By.cssSelector("div#search a > h3"));
        assertTrue(searchResults.size() > EXPECTED_SEARCH_RESULT_SIZE);
        assertEquals(searchResults.get(0).getText(), EXPECTED_FIRST_LINK_TITLE);
    }
}
