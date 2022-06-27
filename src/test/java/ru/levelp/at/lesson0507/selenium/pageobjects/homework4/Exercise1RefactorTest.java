package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodAndElements;

public class Exercise1RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise1Test() {
        final String receiver = "elekon612@yahoo.com";
        final String subject = "New TestLetter Subject";
        final String letterBody = "New TestLetter Body";

        Homework4RefactorMethodAndElements mailRu = new Homework4RefactorMethodAndElements(driver);
        mailRu.openMailRu();
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
        mailRu.waitUntilURLContainsDrafts();
        var lastMessageReceiver = mailRu.getReceiverOfLastMessage();
        var lastMessageSubject = mailRu.getSubjectOfLastMessage();
        var lastMessageBody = mailRu.getBodyOfLastMessage();
        assertTrue(lastMessageReceiver.contains(receiver));
        assertTrue(lastMessageSubject.contains(subject));
        assertTrue(lastMessageBody.contains(letterBody));

        mailRu.clickOpenLastMessage();
        mailRu.clickSendLetterButton();
        mailRu.clickCrossButton();
        mailRu.waitUntilInvisibilityOfTestMessage1();
        var lastSentNonTestMessageSubject = mailRu.getSubjectOfLastMessage();
        assertFalse(lastSentNonTestMessageSubject.contentEquals(subject));

        mailRu.clickOpenSentPage();
        mailRu.waitUntilURLContainsSent();
        mailRu.waitUntilLastLetterIsClickable();
        var lastSentMessageReceiver = mailRu.getReceiverOfLastMessage();
        var lastSentMessageSubject = mailRu.getSubjectOfLastMessage();
        var lastSentMessageBody = mailRu.getBodyOfLastMessage();
        assertTrue(lastSentMessageReceiver.contains(receiver));
        assertTrue(lastSentMessageSubject.contains(subject));
        assertTrue(lastSentMessageBody.contains(letterBody));

        mailRu.clickPhDropdown();
        mailRu.clickLogoutButton();
    }
}
