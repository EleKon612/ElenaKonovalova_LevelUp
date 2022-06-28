package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodsAndElements;

public class Exercise3RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise3Test() {
        final String receiver = "elekon612@mail.ru";
        final String receiverInbox = "Elena Konovalova";
        final String subject = "This is a perfect letter";
        final String letterBody = "London is the capital of Great Britain";

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
        letterFrame.clickSendLetterButton();
        letterFrame.clickCrossButton();

        mailFolder.clickSelfMessagesInInboxPage();
        mailFolder.waitUntilVisibilityOfMarkUnreadButton();
        mailFolder.waitUntilVisibilityOfTestMessageSubjectExercise3();
        var lastInboxMessageReceiver = mailFolder.getReceiverOfLastMessage();
        var lastInboxMessageSubject = mailFolder.getSubjectOfLastMessage();
        var lastInboxMessageBody = mailFolder.getBodyOfLastMessage();
        assertTrue(lastInboxMessageReceiver.contains(receiverInbox));
        assertTrue(lastInboxMessageSubject.contains(subject));
        assertTrue(lastInboxMessageBody.contains(letterBody));
        mailFolder.clickOpenLastMessage();

        Homework4RefactorMethodsAndElements letterPage = new Homework4RefactorMethodsAndElements(driver);
        letterPage.clickDeleteButton();
        letterPage.clickReturnButton();

        mailFolder.clickOpenTrashBinPage();
        mailFolder.waitUntilURLContainsTrash();
        mailFolder.waitUntilLastLetterIsClickable();
        var lastTrashMessageSubject = mailFolder.getSubjectOfLastMessage();
        assertTrue(lastTrashMessageSubject.contains(subject));

        mailFolder.clickPhDropdown();
        mailFolder.clickLogoutButton();
    }
}
