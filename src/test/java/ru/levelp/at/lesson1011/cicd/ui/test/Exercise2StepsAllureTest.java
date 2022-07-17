package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class Exercise2StepsAllureTest extends Homework5BaseStepsAllureTest {

    @Test(description = "Тест на Mailru - Отправка нового письма в папку Test")
    @Severity(SeverityLevel.NORMAL)
    @Issue("BUG-1234")
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
