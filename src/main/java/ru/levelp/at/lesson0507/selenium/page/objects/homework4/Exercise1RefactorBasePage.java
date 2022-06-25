package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import java.time.Duration;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Exercise1RefactorBasePage {

    protected String MAILRU_URL = "https://mail.ru";
    protected final String receiver = "elena.volnova@mail.ru";
    protected final String subject = "New TestLetter Subject";
    protected final String letterBody = "New TestLetter Body";

    protected final String inboxURL = "https://e.mail.ru/inbox";
    protected final String draftsURL = "https://e.mail.ru/drafts";
    protected final String sentURL = "https://e.mail.ru/sent";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Exercise1RefactorBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToActiveElement() {
        driver.switchTo().activeElement();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getTextFromElementSubject() {
        return driver.getCurrentUrl();
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
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUntilElementToBeClickable(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitUntilUrlContains(final String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }
}
