package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class Exercise1StepsAllureTest extends Homework5BaseStepsAllureTest {

    @Test(description = "Тест на Mailru - Создание, сохранение и отправка черновика")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("MOBQA-1234")
    @Description("Подробное описание теста")
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
