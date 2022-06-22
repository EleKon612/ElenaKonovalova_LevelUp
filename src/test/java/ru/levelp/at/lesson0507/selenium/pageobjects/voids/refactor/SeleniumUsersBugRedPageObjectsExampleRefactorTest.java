package ru.levelp.at.lesson0507.selenium.pageobjects.voids.refactor;

import static org.testng.Assert.assertEquals;

import java.util.Locale;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.voids.UsersBugRedLoginRegistrationPage;
import ru.levelp.at.lesson0507.selenium.page.objects.voids.UsersBugRedUsersPage;
import ru.levelp.at.lesson0507.selenium.pageobjects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedPageObjectsExampleRefactorTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
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
