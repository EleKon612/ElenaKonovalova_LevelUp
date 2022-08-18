package ru.levelp.at.lesson1011.cicd.ui.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.ui.listener.AllureListener;

@Epic("Тестирование Mailru")
@Feature("Создание и отправка письма в папку Test")
@Listeners({AllureListener.class})
public class Exercise2StepsAllureTest extends Homework5BaseStepsAllureTest {

    @Test(description = "Тест на Mailru - Отправка нового письма в папку Test")
    @Severity(SeverityLevel.NORMAL)
    @Issue("BUG-1234")
    @Story("Вход, создание письма, отправка письма в папку Test, выход")
    public void exercise2Test() {
        steps.openMailruMainPage(mailRuURL);
        steps.loginToMailru(username, password);
        steps.assertThatInboxPageIsOpened(inboxURL);
        steps.createAndFillNewLetter(receiver2, subject2, letterBody2);
        steps.sendLetter();
        steps.openSentPage(sentURL);
        steps.assertLastLetterContainsCorrectData(receiver1, subject2, letterBody2);
        steps.openTestFolderPage(testFolderURL);
        steps.assertLastLetterContainsCorrectData(receiverInbox2, subject2, letterBody2);
        steps.logoutFromMailru();
    }
}
