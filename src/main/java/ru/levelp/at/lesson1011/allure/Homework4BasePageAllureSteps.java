package ru.levelp.at.lesson1011.allure;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Homework4BasePageAllureSteps {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Homework4BasePageAllureSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void findElement(final String elementName) {
        driver.findElement(By.name(elementName));
    }

    public void switchToActiveElement() {
        driver.switchTo().activeElement();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void openURL(final String url) {
        driver.navigate().to(url);
    }

    protected void insertInputField(final WebElement insertField, final CharSequence text) {
        wait.until(ExpectedConditions.visibilityOf(insertField)).sendKeys(text);
    }

    protected void clickButton(final WebElement buttonClicked) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonClicked)).click();
    }

    protected void waitUntilVisibilityOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUntilElementToBeClickable(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitUntilUrlContains(final String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }

    public static ExpectedCondition<Boolean> invisibilityOfElements(final List<WebElement> listElement) {
        return new ExpectedCondition<>() {
            public Boolean apply(WebDriver webDriver) {
                try {
                    return listElement.isEmpty();
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    return true;
                }
            }
        };
    }
}
