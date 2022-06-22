package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Exercise1RefactorBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Exercise1RefactorBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void insertInputField(final WebElement insertField, final String text) {
        wait.until(ExpectedConditions.visibilityOf(insertField)).sendKeys(text);
    }

    protected void clickButton(final WebElement buttonClicked) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonClicked)).click();
    }

    protected void switchToFrame(final WebElement frame) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}
