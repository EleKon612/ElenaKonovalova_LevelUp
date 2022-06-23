package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.*;
import static ru.levelp.at.lesson0507.selenium.page.objects.homework4.Exercise1Refactor.MAILRU_URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Exercise1Refactor;
import ru.levelp.at.utils.SleepUtils;

public class Exercise1RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise1Test() {
        Exercise1Refactor mailRu = new Exercise1Refactor(driver);
        driver.navigate().to(MAILRU_URL);

        mailRu.clickLoginButton();
        mailRu.switchToLoginFrame();
        mailRu.insertUsername(username);
        mailRu.clickEnterPasswordButton();
        mailRu.insertPassword(password);
        mailRu.clickSignInButton();

        SleepUtils.sleep(3000);
        // mailRu.wait.until(ExpectedConditions.visibilityOf(inboxPage));
        assertTrue(driver.getCurrentUrl().contains(inboxURL));

        mailRu.clickNewLetterButton();
        driver.switchTo().activeElement();
        mailRu.insertReceiver(receiver);
        mailRu.insertSubject(subject);
        mailRu.insertBody(letterBody);
        mailRu.clickSaveDraftButton();
        mailRu.clickCloseDraftButton();

        mailRu.clickOpenDraftsButton();
        SleepUtils.sleep(3000);
        // mailRu.wait.until(ExpectedConditions.visibilityOf(draftsPage));
        // assertTrue(lastDraftMessage.getText().contains(subject));

        mailRu.tapLastDraftMessage();
        SleepUtils.sleep(3000);
        // mailRu.wait.until(ExpectedConditions.visibilityOf(sendDraftButton));
        // assertTrue(ourDraftMessageReceiver.isDisplayed());
        // assertTrue(ourDraftMessageSubject.isDisplayed());
        // assertTrue(ourDraftMessageBody.isDisplayed());

        mailRu.clickSendDraftButton();
        mailRu.clickCrossButton();
        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='New TestLetter Subject']")));
        // assertFalse(lastDraftMessage.getText().contains(subject));

        
    }
}
