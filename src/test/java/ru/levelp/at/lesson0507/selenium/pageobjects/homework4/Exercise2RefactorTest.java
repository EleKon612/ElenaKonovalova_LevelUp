package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Exercise2RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise2Test() {
        postPage.waitUntilVisibilityOfNewLetterButton();
        assertTrue(postPage.getCurrentURL().contains(inboxURL));
        postPage.clickNewLetterButton();
        postPage.switchToActiveElement();
        postPage.insertReceiver(receiver2);
        postPage.insertSubject(subject2);
        postPage.insertBody(letterBody2);
        postPage.clickSendLetterButton();
        postPage.clickCrossButton();

        postPage.clickOpenSentPage();
        postPage.waitUntilURLContains(sentURL);
        var lastSentMessageReceiver = postPage.getReceiverOfLastMessage();
        var lastSentMessageSubject = postPage.getSubjectOfLastMessage();
        var lastSentMessageBody = postPage.getBodyOfLastMessage();
        assertTrue(lastSentMessageReceiver.contains(receiver2));
        assertTrue(lastSentMessageSubject.contains(subject2));
        assertTrue(lastSentMessageBody.contains(letterBody2));

        postPage.clickOpenTestFolderPage();
        postPage.waitUntilURLContains(testFolderURL);
        var lastReceivedMessageReceiver = postPage.getReceiverOfLastMessage();
        var lastReceivedMessageSubject = postPage.getSubjectOfLastMessage();
        var lastReceivedMessageBody = postPage.getBodyOfLastMessage();
        assertTrue(lastReceivedMessageReceiver.contains(receiverInbox2));
        assertTrue(lastReceivedMessageSubject.contains(subject2));
        assertTrue(lastReceivedMessageBody.contains(letterBody2));
    }
}
