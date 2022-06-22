package ru.levelp.at.lesson0507.selenium.page.objects.voids.refactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsersBugRedUsersPageRefactor extends UsersBugRedBasePageRefactor {

    @FindBy(css = "#fat-menu > a")
    private WebElement userMenuDropdown;

    public UsersBugRedUsersPageRefactor(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/");
    }

    public String getUsernameFromDropdown() {
        return wait.until(ExpectedConditions.visibilityOf(userMenuDropdown)).getText();
    }
}
