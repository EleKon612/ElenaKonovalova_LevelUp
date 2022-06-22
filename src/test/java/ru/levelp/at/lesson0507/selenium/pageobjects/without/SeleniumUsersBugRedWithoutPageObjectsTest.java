package ru.levelp.at.lesson0507.selenium.pageobjects.without;

import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.pageobjects.AbstractSeleniumBaseTest;

public class SeleniumUsersBugRedWithoutPageObjectsTest extends AbstractSeleniumBaseTest {

    @Test
    public void registerUserTest() {
        driver.navigate().to(USERS_BUGRED_LOGIN_REG_PAGE_URL);

        var username = FAKER.name().fullName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var nameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form[contains(@action, 'register')]//*[@name='name']")));
        nameInputField.sendKeys(username);

        var emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form[contains(@action, 'register')]//*[@name='email']")));
        emailInputField.sendKeys(email);

        var passwordInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form[contains(@action, 'register')]//*[@name='password']")));
        passwordInputField.sendKeys(password);

        var registerButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//form[contains(@action, 'register')]//*[@name='act_register_now']")));
        registerButton.click();

        var userMenuDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#fat-menu > a")));
        Assert.assertEquals(userMenuDropdown.getText().toLowerCase(Locale.ROOT), username.toLowerCase(Locale.ROOT));
    }
}
