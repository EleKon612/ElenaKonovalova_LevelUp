package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumCssSelectorLocatorExampleTest extends AbstractSeleniumLocatorExampleTest {

    @Test
    public void idCssSelectorTest() {
        // WebElement applicationButton = driver.findElement(By.id("gbwa")); DOM locator
        WebElement applicationButton = driver.findElement(By.cssSelector("#gbwa"));
        applicationButton.click();

        // WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']")); xPath
        WebElement applicationFrame = driver.findElement(By.cssSelector("div > iframe[role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void nameCssSelectorTest() {
        // WebElement searchTextBox = driver.findElement(By.name("q")); DOM
        WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']"));
        searchTextBox.sendKeys("yandex" + Keys.ENTER);

        // Ошибка "ElementNotInteractableException: element not interactable"
        // WebElement searchButton = driver.findElement(By.name("btnK"));
        // searchButton.click();

        // assertTrue(driver.findElement(By.id("search")).isDisplayed()); DOM
        assertTrue(driver.findElement(By.cssSelector("[id='search']")).isDisplayed()); // CSS var1
        // assertTrue(driver.findElement(By.cssSelector("#search")).isDisplayed()); CSS var2
    }

    @Test
    public void classNameCssSelectorTest() {
        // WebElement applicationButton = driver.findElement(By.className("gb_z")); DOM
        WebElement applicationButton = driver.findElement(By.cssSelector(".gb_z")); // CSS var1
        // WebElement applicationButton = driver.findElement(By.cssSelector("[class='gb_z']")); CSS var2
        applicationButton.click();

        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    // Not available for CSS selectors:
    /*@Test
    public void linkTextDomLocatorTest() {
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        assertTrue(driver.getTitle().contains("Gmail"));
    }

    @Test
    public void partialLinkTextDomLocatorTest() {
        WebElement imagLink = driver.findElement(By.partialLinkText("Imag"));
        imagLink.click();

        assertTrue(driver.getCurrentUrl().contains("imghp"));
    }*/
}
