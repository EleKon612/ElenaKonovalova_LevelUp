package ru.levelp.at.lesson0507.selenium.page.objects.voids;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersBugRedUsersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#fat-menu > a")
    private WebElement userMenuDropdown;

    public UsersBugRedUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getUsernameFromDropdown() {
        return wait.until(ExpectedConditions.visibilityOf(userMenuDropdown)).getText();
    }
}
