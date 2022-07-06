package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Exercise1RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise1Test() {
        postPage.waitUntilVisibilityOfNewLetterButton();
        assertTrue(postPage.getCurrentURL().contains(inboxURL));
        postPage.clickNewLetterButton();
        postPage.switchToActiveElement();
        postPage.insertReceiver(receiver1);
        postPage.insertSubject(subject1);
        postPage.insertBody(letterBody1);
        postPage.clickSaveDraftButton();
        postPage.clickCloseDraftButton();

        postPage.clickOpenDraftsPage();
        postPage.waitUntilURLContains(draftsURL);
        assertTrue(postPage.getReceiverOfLastMessage().contains(receiver1));
        assertTrue(postPage.getSubjectOfLastMessage().contains(subject1));
        assertTrue(postPage.getBodyOfLastMessage().contains(letterBody1));
        postPage.clickOpenLastMessage();

        postPage.clickSendLetterButton();
        postPage.clickCrossButton();

        postPage.waitUntilTheListOfMessagesIsEmpty();
        postPage.confirmThatListOfMessagesIsEmpty();
        postPage.clickOpenSentPage();
        postPage.waitUntilURLContains(sentURL);
        postPage.waitUntilLastLetterIsClickable();
        assertTrue(postPage.getReceiverOfLastMessage().contains(receiver1));
        assertTrue(postPage.getSubjectOfLastMessage().contains(subject1));
        assertTrue(postPage.getBodyOfLastMessage().contains(letterBody1));
    }
}
