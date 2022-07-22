package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Тестирование Mailru")
@Feature("Создание, отправка письма, удаление")
public class Exercise3StepsAllureTest extends Homework5BaseStepsAllureTest {

    @Test(description = "Тест на Mailru - Отправка нового письма себе с последующим удалением")
    @Severity(SeverityLevel.MINOR)
    @Story("Вход, создание письма, отправка письма себе, удаление, выход")
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
