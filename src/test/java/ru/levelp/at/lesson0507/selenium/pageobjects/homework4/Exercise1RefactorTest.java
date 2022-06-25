package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Exercise1Refactor;

import static org.testng.Assert.*;

public class Exercise1RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise1Test() {
        Exercise1Refactor mailRu = new Exercise1Refactor(driver);
        mailRu.openMailru();

        mailRu.clickLoginButton();
        mailRu.switchToLoginFrame();
        mailRu.insertUsername(username);
        mailRu.clickEnterPasswordButton();
        mailRu.insertPassword(password);
        mailRu.clickSignInButton();

        mailRu.waitUntilVisibilityOfNewLetterButton();
        assertTrue(mailRu.getCurrentURL().contains(inboxURL));

        mailRu.clickNewLetterButton();
        mailRu.switchToActiveElement();
        mailRu.insertReceiver(receiver);
        mailRu.insertSubject(subject);
        mailRu.insertBody(letterBody);
        mailRu.clickSaveDraftButton();
        mailRu.clickCloseDraftButton();
        mailRu.clickOpenDraftsPage();

        // Проверить, что получатель,тема и тело последнего письма (первого найденного элемента "письмо") в черновиках совпадает
        // с нашими получателем, темой и телом
        var actualDraftMessageReceiver = mailRu.getReceiverOfLastDraftMessage();
        var actualDraftMessageSubject = mailRu.getSubjectOfLastDraftMessage();
        var actualDraftMessageBody = mailRu.getBodyOfLastDraftMessage();
        assertEquals(actualDraftMessageReceiver, receiver);
        assertEquals(actualDraftMessageSubject, subject);
        assertTrue(actualDraftMessageBody.contains(letterBody));

        mailRu.clickOpenLastDraftMessage();
        mailRu.waitUntilSendDraftButtonToBeClickable();
        mailRu.clickSendDraftButton();
        mailRu.clickCrossButton();
        mailRu.waitUntilInvisibilityOfTestMessageSubject();
        // assertFalse(lastDraftMessage.getText().contains(subject));

        mailRu.clickOpenSentPage();
        mailRu.waitUntilURLContainsSent();
        mailRu.waitUntilVisibilityOfTestMessageSubject();
        // assertTrue(lastSentMessage.getText().contains(subject));
        mailRu.clickOpenLastSentMessage();
        mailRu.waitUntilVisibilityOfTestMessageBody();
        // assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).isDisplayed());
        // assertTrue(driver.findElement(By.xpath("//span[text()='elena.volnova@mail.ru']")).isDisplayed());
        // assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Body']")).isDisplayed());

        mailRu.clickPhDropdown();
        mailRu.clickLogoutButton();
    }
}
