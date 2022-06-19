package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumXPathLocatorExampleTest extends AbstractSeleniumLocatorExampleTest {

    @Test
    public void idXPathTest() {
        // WebElement applicationButton = driver.findElement(By.id("gbwa")); DOM locator
        // WebElement applicationButton = driver.findElement(By.cssSelector("#gbwa")); CSS selector
        WebElement applicationButton = driver.findElement(By.xpath("//*[@id='gbwa']"));
        applicationButton.click();

        // WebElement applicationFrame = driver.findElement(By.cssSelector("div > iframe[role='presentation']")); CSS
        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        // List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li")); CSS
        List<WebElement> applicationElements = driver.findElements(By.xpath("//ul//li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void nameXPathTest() {
        // WebElement searchTextBox = driver.findElement(By.name("q")); DOM
        // WebElement searchTextBox = driver.findElement(By.cssSelector("[name='q']")); CSS
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchTextBox.sendKeys("yandex" + Keys.ENTER);

        // Ошибка "ElementNotInteractableException: element not interactable"
        // WebElement searchButton = driver.findElement(By.name("btnK"));
        // searchButton.click();

        // assertTrue(driver.findElement(By.id("search")).isDisplayed()); DOM
        // assertTrue(driver.findElement(By.cssSelector("[id='search']")).isDisplayed()); CSS var1
        // assertTrue(driver.findElement(By.cssSelector("#search")).isDisplayed()); CSS var2
        assertTrue(driver.findElement(By.xpath("//*[@id='search']")).isDisplayed());
    }

    @Test
    public void classNameXPathTest() {
        // WebElement applicationButton = driver.findElement(By.className("gb_fd")); DOM
        // WebElement applicationButton = driver.findElement(By.cssSelector(".gb_fd")); CSS var1 (частичное совпадение)
        // WebElement applicationButton = driver.findElement(By.cssSelector("[class='gb_z gb_fd gb_f gb_yf']"));
        // CSS var2 (полное совпадение)
        // WebElement applicationButton = driver.findElement(By.xpath("//*[@class='gb_z gb_fd gb_f gb_yf']"));
        // XPath (полное совпадение)
        WebElement applicationButton = driver.findElement(By.xpath(
            "//*[contains(@class, 'gb_fd')]")); // XPath (частичное совпадение)
        applicationButton.click();

        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void linkTextXPathTest() {
        // WebElement gmailLink = driver.findElement(By.linkText("Gmail")); DOM
        WebElement gmailLink = driver.findElement(By.xpath("//*[text()='Gmail']"));
        gmailLink.click();

        assertTrue(driver.getTitle().contains("Gmail"));
    }

    @Test
    public void partialLinkTextXPathTest() {
        // WebElement imagLink = driver.findElement(By.partialLinkText("Imag")); DOM
        WebElement imagLink = driver.findElement(By.xpath("//*[contains(text(), 'Imag')]"));
        imagLink.click();

        assertTrue(driver.getCurrentUrl().contains("imghp"));
    }

    @Test
    public void indexesXPathTest() {
        // WebElement applicationButton = driver.findElement(By.id("gbwa")); DOM locator
        // WebElement applicationButton = driver.findElement(By.cssSelector("#gbwa")); CSS selector
        WebElement applicationButton = driver.findElement(By.xpath("//*[@id='gbwa']"));
        applicationButton.click();

        // WebElement applicationFrame = driver.findElement(By.cssSelector("div > iframe[role='presentation']")); CSS
        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        // List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li")); CSS
        WebElement applicationElement = driver.findElement(By.xpath("//ul//li[5]"));
        System.out.println(String.format("Text from application element [5]: %s", applicationElement.getText()));
    }
}
