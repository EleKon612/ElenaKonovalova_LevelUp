package ru.levelp.at.lesson0507.selenium.pageobjects.homework5.tests;

import org.testng.annotations.Test;

public class Exercise1RefactorStepsTest extends Homework5RefactorBaseStepsTest {

    @Test
    public void exercise1Test() {
        steps.openMailruMainPage(mailRuURL);
        steps.loginToMailru(username, password);
        steps.assertThatInboxPageIsOpened(inboxURL);
        steps.createAndFillNewLetter(receiver1, subject1, letterBody1);
        steps.saveAndCloseDraftLetter();
        steps.openDraftsPage(draftsURL);
        steps.assertLastLetterContainsCorrectData(receiver1, subject1, letterBody1);
        steps.openLastMessageFromTheList();
        steps.sendLetter();
        steps.confirmThatListOfMessagesIsEmpty();
        steps.openSentPage(sentURL);
        steps.assertLastLetterContainsCorrectData(receiver1, subject1, letterBody1);
        steps.logoutFromMailru();
    }
}
