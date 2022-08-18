package ru.levelp.at.lesson1011.cicd.ui.step;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.allure.Homework4MainPageAllureSteps;
import ru.levelp.at.lesson1011.allure.Homework4PostPageAllureSteps;

public class Homework5AllureSteps {

    private WebDriver driver;
    private Homework4MainPageAllureSteps mainPageSteps;
    private Homework4PostPageAllureSteps postPageSteps;

    public Homework5AllureSteps(WebDriver driver) {
        this.driver = driver;
        this.mainPageSteps = new Homework4MainPageAllureSteps(driver);
        this.postPageSteps = new Homework4PostPageAllureSteps(driver);
    }

    @Step("Открываем сайт Mailru")
    public void openMailruMainPage(final String url) {
        mainPageSteps.openURL(url);
    }

    @Step("Авторизуемся на сайте с username: '{0}', password: '{1}'")
    public void loginToMailru(final String username, final String password) {
        mainPageSteps.insertUsername(username);
        mainPageSteps.clickEnterPasswordButton();
        mainPageSteps.insertPassword(password);
        mainPageSteps.clickSignInButton();
    }

    @Step("Проверяем, что вход выполнен успешно и открыта страница Входящие")
    public void assertThatInboxPageIsOpened(final String url) {
        postPageSteps.waitUntilVisibilityOfNewLetterButton();
        assertTrue(postPageSteps.getCurrentURL().contains(url));
    }

    @Step("Создаем новое письмо с получателем: '{0}', темой: '{1}', телом письма: '{2}'")
    public void createAndFillNewLetter(final String receiver, final String subject, final String body) {
        postPageSteps.clickNewLetterButton();
        postPageSteps.switchToActiveElement();
        postPageSteps.insertReceiver(receiver);
        postPageSteps.insertSubject(subject);
        postPageSteps.insertBody(body);
    }

    @Step("Сохраняем и закрываем черновик")
    public void saveAndCloseDraftLetter() {
        postPageSteps.clickSaveDraftButton();
        postPageSteps.clickCloseDraftButton();
    }

    @Step("Открываем папку Черновики")
    public void openDraftsPage(final String url) {
        postPageSteps.clickOpenDraftsPage();
        postPageSteps.waitUntilURLContains(url);
    }

    @Step("Проверяем, что письмо сохранено в Черновиках")
    public void assertLastLetterContainsCorrectData(final String receiver, final String subject, final String body) {
        assertTrue(postPageSteps.getReceiverOfLastMessage().contains(receiver));
        assertTrue(postPageSteps.getSubjectOfLastMessage().contains(subject));
        assertTrue(postPageSteps.getBodyOfLastMessage().contains(body));
    }

    @Step("Открываем последнее письмо из списка")
    public void openLastMessageFromTheList() {
        postPageSteps.clickOpenLastMessage();
    }

    @Step("Отправляем письмо")
    public void sendLetter() {
        postPageSteps.clickSendLetterButton();
        postPageSteps.clickCrossButton();
    }

    @Step("Проверяем, что список черновиков пуст")
    public void confirmThatListOfMessagesIsEmpty() {
        postPageSteps.waitUntilTheListOfMessagesIsEmpty();
        postPageSteps.confirmThatListOfMessagesIsEmpty();
    }

    @Step("Открываем папку Отправленные")
    public void openSentPage(final String url) {
        postPageSteps.clickOpenSentPage();
        postPageSteps.waitUntilURLContains(url);
        postPageSteps.waitUntilLastLetterIsClickable();
    }

    @Step("Открываем папку Тест")
    public void openTestFolderPage(final String url) {
        postPageSteps.clickOpenTestFolderPage();
        postPageSteps.waitUntilURLContains(url);
        postPageSteps.waitUntilLastLetterIsClickable();
    }

    @Step("Открываем папку Письма себе")
    public void openSelfMessagesFolder() {
        postPageSteps.clickSelfMessagesInInboxPage();
        postPageSteps.waitUntilVisibilityOfMarkUnreadButton();
    }

    @Step("Выходим из аккаунта")
    public void logoutFromMailru() {
        postPageSteps.clickPhDropdown();
        postPageSteps.clickLogoutButton();
    }

    @Step("Удаляем письмо и нажимаем Вернуться")
    public void deleteLetterAndReturn() {
        postPageSteps.clickDeleteButton();
        postPageSteps.clickReturnButton();
    }

    @Step("Открываем папку Корзина")
    public void openTrashFolder(final String url) {
        postPageSteps.clickOpenTrashBinPage();
        postPageSteps.waitUntilURLContains(url);
        postPageSteps.waitUntilLastLetterIsClickable();
    }
}
