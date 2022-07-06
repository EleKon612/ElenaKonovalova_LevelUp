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
        assertTrue(postPage.getReceiverOfLastMessage().contains(receiver2));
        assertTrue(postPage.getSubjectOfLastMessage().contains(subject2));
        assertTrue(postPage.getBodyOfLastMessage().contains(letterBody2));

        postPage.clickOpenTestFolderPage();
        postPage.waitUntilURLContains(testFolderURL);
        assertTrue(postPage.getReceiverOfLastMessage().contains(receiverInbox2));
        assertTrue(postPage.getSubjectOfLastMessage().contains(subject2));
        assertTrue(postPage.getBodyOfLastMessage().contains(letterBody2));
    }
}
