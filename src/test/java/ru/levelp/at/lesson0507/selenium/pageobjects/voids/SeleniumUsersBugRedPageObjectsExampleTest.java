package ru.levelp.at.lesson0507.selenium.pageobjects.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.voids.UsersBugRedLoginRegistrationPage;
import ru.levelp.at.lesson0507.selenium.page.objects.voids.UsersBugRedUsersPage;
import ru.levelp.at.lesson0507.selenium.pageobjects.AbstractSeleniumBaseTest;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class SeleniumUsersBugRedPageObjectsExampleTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        UsersBugRedLoginRegistrationPage registrationPage = new UsersBugRedLoginRegistrationPage(driver);
        // driver.navigate().to(USERS_BUGRED_LOGIN_REG_PAGE_URL);
        registrationPage.open();

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        // var nameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
        //         By.xpath("//form[contains(@action, 'register')]//*[@name='name']")));
        // nameInputField.sendKeys(username);
        registrationPage.fillUsernameInputField(username);

        // var emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
        //         By.xpath("//form[contains(@action, 'register')]//*[@name='email']")));
        // emailInputField.sendKeys(email);
        registrationPage.fillEmailInputField(email);

        // var passwordInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
        //         By.xpath("//form[contains(@action, 'register')]//*[@name='password']")));
        // passwordInputField.sendKeys(password);
        registrationPage.fillPasswordInputField(password);

        // var registerButton = wait.until(ExpectedConditions.elementToBeClickable(
        //         By.xpath("//form[contains(@action, 'register')]//*[@name='act_register_now']")));
        // registerButton.click();
        registrationPage.clickRegisterButton();

        // var userMenuDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
        //         By.cssSelector("#fat-menu > a")));
        // Assert.assertEquals(userMenuDropdown.getText().toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
        UsersBugRedUsersPage usersPage = new UsersBugRedUsersPage(driver);
        var userMenuDropdown = usersPage.getUsernameFromDropdown();
        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }

    @Test
    public void registerUserWithoutCommentsTest() {
        UsersBugRedLoginRegistrationPage registrationPage = new UsersBugRedLoginRegistrationPage(driver);
        registrationPage.open();

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        registrationPage.fillUsernameInputField(username);
        registrationPage.fillEmailInputField(email);
        registrationPage.fillPasswordInputField(password);
        registrationPage.clickRegisterButton();

        UsersBugRedUsersPage usersPage = new UsersBugRedUsersPage(driver);
        var userMenuDropdown = usersPage.getUsernameFromDropdown();
        assertEquals(userMenuDropdown.toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }
}
