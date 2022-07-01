package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMainPage;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorPostPage;

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
        var lastMessageReceiver = postPage.getReceiverOfLastMessage();
        var lastMessageSubject = postPage.getSubjectOfLastMessage();
        var lastMessageBody = postPage.getBodyOfLastMessage();
        assertTrue(lastMessageReceiver.contains(receiver1));
        assertTrue(lastMessageSubject.contains(subject1));
        assertTrue(lastMessageBody.contains(letterBody1));
        postPage.clickOpenLastMessage();

        postPage.clickSendLetterButton();
        postPage.clickCrossButton();

        postPage.waitUntilInvisibilityOfTestMessage1();
        var lastSentNonTestMessageSubject = postPage.getSubjectOfLastMessage();
        assertFalse(lastSentNonTestMessageSubject.contentEquals(subject1));
        postPage.clickOpenSentPage();
        postPage.waitUntilURLContains(sentURL);
        postPage.waitUntilLastLetterIsClickable();
        var lastSentMessageReceiver = postPage.getReceiverOfLastMessage();
        var lastSentMessageSubject = postPage.getSubjectOfLastMessage();
        var lastSentMessageBody = postPage.getBodyOfLastMessage();
        assertTrue(lastSentMessageReceiver.contains(receiver1));
        assertTrue(lastSentMessageSubject.contains(subject1));
        assertTrue(lastSentMessageBody.contains(letterBody1));
    }
}
