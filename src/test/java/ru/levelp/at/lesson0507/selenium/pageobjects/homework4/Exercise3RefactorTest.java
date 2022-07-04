package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Exercise3RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise3Test() {
        postPage.waitUntilVisibilityOfNewLetterButton();
        assertTrue(postPage.getCurrentURL().contains(inboxURL));

        postPage.clickNewLetterButton();
        postPage.switchToActiveElement();
        postPage.insertReceiver(receiver3);
        postPage.insertSubject(subject3);
        postPage.insertBody(letterBody3);
        postPage.clickSendLetterButton();
        postPage.clickCrossButton();

        postPage.clickSelfMessagesInInboxPage();
        postPage.waitUntilVisibilityOfMarkUnreadButton();
        var lastInboxMessageReceiver = postPage.getReceiverOfLastMessage();
        var lastInboxMessageSubject = postPage.getSubjectOfLastMessage();
        var lastInboxMessageBody = postPage.getBodyOfLastMessage();
        assertTrue(lastInboxMessageReceiver.contains(receiverInbox3));
        assertTrue(lastInboxMessageSubject.contains(subject3));
        assertTrue(lastInboxMessageBody.contains(letterBody3));
        postPage.clickOpenLastMessage();

        postPage.clickDeleteButton();
        postPage.clickReturnButton();

        postPage.clickOpenTrashBinPage();
        postPage.waitUntilURLContains(trashURL);
        postPage.waitUntilLastLetterIsClickable();
        var lastTrashMessageSubject = postPage.getSubjectOfLastMessage();
        assertTrue(lastTrashMessageSubject.contains(subject3));
    }
}
