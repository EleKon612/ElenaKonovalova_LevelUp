package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodsAndElements;

public class Exercise1RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise1Test() {
        final String receiver = "elekon612@yahoo.com";
        final String subject = "New TestLetter Subject";
        final String letterBody = "New TestLetter Body";

        Homework4RefactorMethodsAndElements mailRuMain = new Homework4RefactorMethodsAndElements(driver);
        mailRuMain.openMailRu();
        mailRuMain.clickLoginButton();
        mailRuMain.switchToLoginFrame();

        Homework4RefactorMethodsAndElements signInFrame = new Homework4RefactorMethodsAndElements(driver);
        signInFrame.insertUsername(username);
        signInFrame.clickEnterPasswordButton();
        signInFrame.insertPassword(password);
        signInFrame.clickSignInButton();

        Homework4RefactorMethodsAndElements mailFolder = new Homework4RefactorMethodsAndElements(driver);
        mailFolder.waitUntilVisibilityOfNewLetterButton();
        assertTrue(mailFolder.getCurrentURL().contains(inboxURL));
        mailFolder.clickNewLetterButton();
        mailFolder.switchToActiveElement();

        Homework4RefactorMethodsAndElements letterFrame = new Homework4RefactorMethodsAndElements(driver);
        letterFrame.insertReceiver(receiver);
        letterFrame.insertSubject(subject);
        letterFrame.insertBody(letterBody);
        letterFrame.clickSaveDraftButton();
        letterFrame.clickCloseDraftButton();

        mailFolder.clickOpenDraftsPage();
        mailFolder.waitUntilURLContainsDrafts();
        var lastMessageReceiver = mailFolder.getReceiverOfLastMessage();
        var lastMessageSubject = mailFolder.getSubjectOfLastMessage();
        var lastMessageBody = mailFolder.getBodyOfLastMessage();
        assertTrue(lastMessageReceiver.contains(receiver));
        assertTrue(lastMessageSubject.contains(subject));
        assertTrue(lastMessageBody.contains(letterBody));
        mailFolder.clickOpenLastMessage();

        letterFrame.clickSendLetterButton();
        letterFrame.clickCrossButton();

        mailFolder.waitUntilInvisibilityOfTestMessage1();
        var lastSentNonTestMessageSubject = mailFolder.getSubjectOfLastMessage();
        assertFalse(lastSentNonTestMessageSubject.contentEquals(subject));
        mailFolder.clickOpenSentPage();
        mailFolder.waitUntilURLContainsSent();
        mailFolder.waitUntilLastLetterIsClickable();
        var lastSentMessageReceiver = mailFolder.getReceiverOfLastMessage();
        var lastSentMessageSubject = mailFolder.getSubjectOfLastMessage();
        var lastSentMessageBody = mailFolder.getBodyOfLastMessage();
        assertTrue(lastSentMessageReceiver.contains(receiver));
        assertTrue(lastSentMessageSubject.contains(subject));
        assertTrue(lastSentMessageBody.contains(letterBody));
        mailFolder.clickPhDropdown();
        mailFolder.clickLogoutButton();
    }
}
