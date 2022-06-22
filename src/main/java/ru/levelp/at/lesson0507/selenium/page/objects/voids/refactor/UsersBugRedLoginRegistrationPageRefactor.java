package ru.levelp.at.lesson0507.selenium.page.objects.voids.refactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersBugRedLoginRegistrationPageRefactor extends UsersBugRedBasePageRefactor {

    private static final String USERS_BUGRED_LOGIN_REG_PAGE_URL = USERS_BUGRED_URL + "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='name']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='password']")
    private WebElement passwordInputField;

    // @FindBy(xpath = "//form[contains(@action, 'register')]//*[@name='act_register_now']")
    @FindBy(how = How.XPATH, using = "//form[contains(@action, 'register')]//*[@name='act_register_now']")
    private WebElement registerButton;

    public UsersBugRedLoginRegistrationPageRefactor(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open(USERS_BUGRED_LOGIN_REG_PAGE_URL);
    }

    public void fillUsernameInputField(final String username) {
        fillInputField(usernameInputField, username);
    }

    public void fillEmailInputField(final String email) {
        fillInputField(emailInputField, email);
    }

    public void fillPasswordInputField(final String password) {
        fillInputField(passwordInputField, password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }
}
