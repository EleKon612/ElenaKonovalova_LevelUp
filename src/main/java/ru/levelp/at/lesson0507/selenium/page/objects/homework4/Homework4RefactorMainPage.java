package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework4RefactorMainPage extends Homework4RefactorBasePage {

    protected WebDriver driver;

    public Homework4RefactorMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement enterPasswordButton;
    @FindBy(css = "[name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement signInButton;

    public void insertUsername(final String username) {
        insertInputField(usernameField, username);
    }

    public void insertPassword(final String password) {
        insertInputField(passwordField, password);
    }

    public void clickEnterPasswordButton() {
        clickButton(enterPasswordButton);
    }

    public void clickSignInButton() {
        clickButton(signInButton);
    }
}