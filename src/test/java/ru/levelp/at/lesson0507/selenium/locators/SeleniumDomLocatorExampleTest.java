package ru.levelp.at.lesson0507.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDomLocatorExampleTest extends AbstractSeleniumLocatorExampleTest {

    @Test
    public void idDomLocatorTest() {
        WebElement applicationButton = driver.findElement(By.id("gbwa"));
        applicationButton.click();

        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
    public void nameDomLocatorTest() {
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("yandex" + Keys.ENTER);

        // Ошибка "ElementNotInteractableException: element not interactable"
        // WebElement searchButton = driver.findElement(By.name("btnK"));
        // searchButton.click();

        assertTrue(driver.findElement(By.id("search")).isDisplayed());
    }

    @Test
    public void classNameDomLocatorTest() {
        WebElement applicationButton = driver.findElement(By.className("gb_z"));
        applicationButton.click();

        WebElement applicationFrame = driver.findElement(By.xpath("//div/iframe[@role='presentation']"));
        driver.switchTo().frame(applicationFrame);

        List<WebElement> applicationElements = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(String.format("Size of application elements: %d", applicationElements.size()));

        assertTrue(applicationElements.size() > 2);
    }

    @Test
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
    }
}
