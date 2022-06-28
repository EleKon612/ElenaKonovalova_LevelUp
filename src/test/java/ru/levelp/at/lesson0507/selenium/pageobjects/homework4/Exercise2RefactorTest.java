package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodsAndElements;

public class Exercise2RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise2Test() {

        final String receiver = "elekon612@mail.ru";
        final String receiverInbox = "Elena Konovalova";
        final String subject = "Тест";
        final String letterBody = "Люблю тебя, Петра творенье";

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

        mailFolder.clickOpenSentPage();
        mailFolder.waitUntilURLContainsSent();
        mailFolder.waitUntilVisibilityOfTestMessageSubjectExercise2();
        var lastSentMessageReceiver = mailFolder.getReceiverOfLastMessage();
        var lastSentMessageSubject = mailFolder.getSubjectOfLastMessage();
        var lastSentMessageBody = mailFolder.getBodyOfLastMessage();
        assertTrue(lastSentMessageReceiver.contains(receiver));
        assertTrue(lastSentMessageSubject.contains(subject));
        assertTrue(lastSentMessageBody.contains(letterBody));

        mailFolder.clickOpenTestFolderPage();
        mailFolder.waitUntilURLContainsTestFolderIndex();
        mailFolder.waitUntilVisibilityOfTestMessageSubjectExercise2();
        var lastReceivedMessageReceiver = mailFolder.getReceiverOfLastMessage();
        var lastReceivedMessageSubject = mailFolder.getSubjectOfLastMessage();
        var lastReceivedMessageBody = mailFolder.getBodyOfLastMessage();
        assertTrue(lastReceivedMessageReceiver.contains(receiverInbox));
        assertTrue(lastReceivedMessageSubject.contains(subject));
        assertTrue(lastReceivedMessageBody.contains(letterBody));

        mailFolder.clickPhDropdown();
        mailFolder.clickLogoutButton();
    }
}
