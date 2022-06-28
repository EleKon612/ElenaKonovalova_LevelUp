package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Homework4RefactorBasePage {

    protected String mailRuURL = "https://mail.ru";
    protected final String draftsURL = "https://e.mail.ru/drafts/";
    protected final String sentURL = "https://e.mail.ru/sent/";
    protected final String trashURL = "https://e.mail.ru/trash/";
    protected final String testFolderURL = "https://e.mail.ru/1/";
    protected final String subject1 = "New TestLetter Subject";
    protected final String subject2 = "Тест";
    protected final String subject3 = "This is a perfect letter";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Homework4RefactorBasePage(WebDriver driver) {
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

    protected void openURL(final String url) {
        driver.navigate().to(url);
    }

    protected void insertInputField(final WebElement insertField, final CharSequence text) {
        wait.until(ExpectedConditions.visibilityOf(insertField)).sendKeys(text);
    }

    protected void clickButton(final WebElement buttonClicked) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonClicked)).click();
    }

    protected void switchToFrame(final WebElement frame) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    protected void waitUntilVisibilityOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUntilInvisibilityOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void waitUntilElementToBeClickable(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitUntilUrlContains(final String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }
}
