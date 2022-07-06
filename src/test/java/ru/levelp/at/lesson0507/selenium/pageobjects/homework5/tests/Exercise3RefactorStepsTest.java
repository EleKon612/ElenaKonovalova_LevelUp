package ru.levelp.at.lesson0507.selenium.pageobjects.homework5.tests;

import org.testng.annotations.Test;

public class Exercise3RefactorStepsTest extends Homework5RefactorBaseStepsTest {

    @Test
    public void exercise3Test() {
        steps.openMailruMainPage(mailRuURL);
        steps.loginToMailru(username, password);
        steps.assertThatInboxPageIsOpened(inboxURL);
        steps.createAndFillNewLetter(receiver3, subject3, letterBody3);
        steps.sendLetter();
        steps.openSelfMessagesFolder();
        steps.assertLastLetterContainsCorrectData(receiverInbox3, subject3, letterBody3);
        steps.openLastMessageFromTheList();
        steps.deleteLetterAndReturn();
        steps.openTrashFolder(trashURL);
        steps.assertLastLetterContainsCorrectData(receiverInbox3, subject3, letterBody3);
        steps.logoutFromMailru();
    }
}
