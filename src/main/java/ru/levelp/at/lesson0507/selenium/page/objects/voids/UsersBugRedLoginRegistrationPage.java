package ru.levelp.at.lesson0507.selenium.page.objects.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersBugRedLoginRegistrationPage {

    private static final String USERS_BUGRED = "http://users.bugred.ru";
    private static final String USERS_BUGRED_LOGIN_REG_PAGE_URL = USERS_BUGRED + "/user/login/index.html";

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='name']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='password']")
    private WebElement passwordInputField;

    // @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='act_register_now']")
    @FindBy(how = How.XPATH, using = "//form[contains(@action, 'register')]//*[@name='act_register_now']")
    private WebElement registerButton;

    public UsersBugRedLoginRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.navigate().to(USERS_BUGRED_LOGIN_REG_PAGE_URL);
    }

    public void fillUsernameInputField(final String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInputField)).sendKeys(username);
    }

    public void fillEmailInputField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInputField)).sendKeys(email);
    }

    public void fillPasswordInputField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInputField)).sendKeys(password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }
}
