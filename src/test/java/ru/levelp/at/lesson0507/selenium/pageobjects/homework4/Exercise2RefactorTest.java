package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodAndElements;

public class Exercise2RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise2Test() {

        final String receiver = "elekon612@mail.ru";
        final String receiverInbox = "Elena Konovalova";
        final String subject = "Тест";
        final String letterBody = "Люблю тебя, Петра творенье";

        Homework4RefactorMethodAndElements mailRu = new Homework4RefactorMethodAndElements(driver);
        mailRu.openMailRu();
        // SleepUtils.sleep(2000);
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
        mailRu.clickSendLetterButton();
        mailRu.clickCrossButton();

        mailRu.clickOpenSentPage();
        mailRu.waitUntilURLContainsSent();
        // mailRu.waitUntilLastLetterIsClickable();
        mailRu.waitUntilVisibilityOfTestMessageSubjectExercise2();
        var lastSentMessageReceiver = mailRu.getReceiverOfLastMessage();
        var lastSentMessageSubject = mailRu.getSubjectOfLastMessage();
        var lastSentMessageBody = mailRu.getBodyOfLastMessage();
        assertTrue(lastSentMessageReceiver.contains(receiver));
        assertTrue(lastSentMessageSubject.contains(subject));
        assertTrue(lastSentMessageBody.contains(letterBody));

        mailRu.clickOpenTestFolderPage();
        mailRu.waitUntilURLContainsTestFolderIndex();
        // mailRu.waitUntilLastLetterIsClickable();
        mailRu.waitUntilVisibilityOfTestMessageSubjectExercise2();
        var lastReceivedMessageReceiver = mailRu.getReceiverOfLastMessage();
        var lastReceivedMessageSubject = mailRu.getSubjectOfLastMessage();
        var lastReceivedMessageBody = mailRu.getBodyOfLastMessage();
        assertTrue(lastReceivedMessageReceiver.contains(receiverInbox));
        assertTrue(lastReceivedMessageSubject.contains(subject));
        assertTrue(lastReceivedMessageBody.contains(letterBody));

        mailRu.clickPhDropdown();
        mailRu.clickLogoutButton();
    }
}
