package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodAndElements;
import ru.levelp.at.utils.SleepUtils;

public class Exercise3RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise3Test() {
        final String receiver = "elekon612@mail.ru";
        final String receiverInbox = "Elena Konovalova";
        final String subject = "This is a perfect letter";
        final String letterBody = "London is the capital of Great Britain";

        Homework4RefactorMethodAndElements mailRu = new Homework4RefactorMethodAndElements(driver);
        mailRu.openMailRu();
        SleepUtils.sleep(3000);
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

        mailRu.clickSelfMessagesInInboxPage();
        mailRu.waitUntilLastLetterIsClickable();
        var lastInboxMessageReceiver = mailRu.getReceiverOfLastMessage();
        var lastInboxMessageSubject = mailRu.getSubjectOfLastMessage();
        var lastInboxMessageBody = mailRu.getBodyOfLastMessage();
        assertTrue(lastInboxMessageReceiver.contains(receiverInbox));
        assertTrue(lastInboxMessageSubject.contains(subject));
        assertTrue(lastInboxMessageBody.contains(letterBody));
        mailRu.clickOpenLastMessage();

        mailRu.clickDeleteButton();
        mailRu.clickReturnButton();
        mailRu.clickOpenTrashBinPage();
        mailRu.waitUntilLastLetterIsClickable();
        var lastTrashMessageSubject = mailRu.getSubjectOfLastMessage();
        assertTrue(lastTrashMessageSubject.contains(subject));

        mailRu.clickPhDropdown();
        mailRu.clickLogoutButton();
    }
}
