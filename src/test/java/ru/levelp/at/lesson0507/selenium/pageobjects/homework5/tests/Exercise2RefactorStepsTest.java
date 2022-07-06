package ru.levelp.at.lesson0507.selenium.pageobjects.homework5.tests;

import org.testng.annotations.Test;

public class Exercise2RefactorStepsTest extends Homework5RefactorBaseStepsTest {

    @Test
    public void exercise2Test() {
        steps.openMailruMainPage(mailRuURL);
        steps.loginToMailru(username, password);
        steps.assertThatInboxPageIsOpened(inboxURL);
        steps.createAndFillNewLetter(receiver2, subject2, letterBody2);
        steps.sendLetter();
        steps.openSentPage(sentURL);
        steps.assertLastLetterContainsCorrectData(receiver2, subject2, letterBody2);
        steps.openTestFolderPage(testFolderURL);
        steps.assertLastLetterContainsCorrectData(receiverInbox2, subject2, letterBody2);
        steps.logoutFromMailru();
    }
}
