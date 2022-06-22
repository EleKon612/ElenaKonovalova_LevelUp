package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Exercise1Refactor extends Exercise1RefactorBasePage {

    public static final String MAILRU_URL = "https://mail.ru";

    @FindBy(xpath = "//*[contains(@class, 'resplash-btn')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div/iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement loginFrame;

    @FindBy(css = "[name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[text()='Enter password']")
    private WebElement enterPasswordButton;

    @FindBy(css = "[name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='compose-button__wrapper']")
    private WebElement newLetterButton;

    public Exercise1Refactor(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickButton(loginButton);
    }

    public void switchToLoginFrame() {
        switchToFrame(loginFrame);
    }

    public void insertUsername(final String username) {
        insertInputField(usernameField, username);
    }

    public void clickEnterPasswordButton() {
        clickButton(enterPasswordButton);
    }

    public void insertPassword(final String password) {
        insertInputField(passwordField, password);
    }

    public void clickSignInButton() {
        clickButton(signInButton);
    }

    public void clickNewLetterButton() {
        clickButton(newLetterButton);
    }
}