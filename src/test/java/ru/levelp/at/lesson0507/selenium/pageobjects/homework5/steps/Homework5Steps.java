package ru.levelp.at.lesson0507.selenium.pageobjects.homework5.steps;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.page.objects.homework5.Homework4RefactorMainPageSteps;
import ru.levelp.at.lesson0507.selenium.page.objects.homework5.Homework4RefactorPostPageSteps;

public class Homework5Steps {

    private WebDriver driver;
    private Homework4RefactorMainPageSteps mainPageSteps;
    private Homework4RefactorPostPageSteps postPageSteps;

    public Homework5Steps(WebDriver driver) {
        this.driver = driver;
        this.mainPageSteps = new Homework4RefactorMainPageSteps(driver);
        this.postPageSteps = new Homework4RefactorPostPageSteps(driver);
    }

    public void openMailruMainPage(final String url) {
        mainPageSteps.openURL(url);
    }

    public void loginToMailru(final String username, final String password) {
        mainPageSteps.insertUsername(username);
        mainPageSteps.clickEnterPasswordButton();
        mainPageSteps.insertPassword(password);
        mainPageSteps.clickSignInButton();
    }

    public void assertThatInboxPageIsOpened(final String url) {
        postPageSteps.waitUntilVisibilityOfNewLetterButton();
        assertTrue(postPageSteps.getCurrentURL().contains(url));
    }

    public void createAndFillNewLetter(final String receiver, final String subject, final String body) {
        postPageSteps.clickNewLetterButton();
        postPageSteps.switchToActiveElement();
        postPageSteps.insertReceiver(receiver);
        postPageSteps.insertSubject(subject);
        postPageSteps.insertBody(body);
    }

    public void saveAndCloseDraftLetter() {
        postPageSteps.clickSaveDraftButton();
        postPageSteps.clickCloseDraftButton();
    }

    public void openDraftsPage(final String url) {
        postPageSteps.clickOpenDraftsPage();
        postPageSteps.waitUntilURLContains(url);
    }

    public void assertLastLetterContainsCorrectData(final String receiver, final String subject, final String body) {
        assertTrue(postPageSteps.getReceiverOfLastMessage().contains(receiver));
        assertTrue(postPageSteps.getSubjectOfLastMessage().contains(subject));
        assertTrue(postPageSteps.getBodyOfLastMessage().contains(body));
    }

    public void openLastMessageFromTheList() {
        postPageSteps.clickOpenLastMessage();
    }

    public void sendLetter() {
        postPageSteps.clickSendLetterButton();
        postPageSteps.clickCrossButton();
    }

    public void confirmThatListOfMessagesIsEmpty() {
        postPageSteps.waitUntilTheListOfMessagesIsEmpty();
        postPageSteps.confirmThatListOfMessagesIsEmpty();
    }

    public void openSentPage(final String url) {
        postPageSteps.clickOpenSentPage();
        postPageSteps.waitUntilURLContains(url);
        postPageSteps.waitUntilLastLetterIsClickable();
    }

    public void openTestFolderPage(final String url) {
        postPageSteps.clickOpenTestFolderPage();
        postPageSteps.waitUntilURLContains(url);
        postPageSteps.waitUntilLastLetterIsClickable();
    }

    public void openSelfMessagesFolder() {
        postPageSteps.clickSelfMessagesInInboxPage();
        postPageSteps.waitUntilVisibilityOfMarkUnreadButton();
    }

    public void logoutFromMailru() {
        postPageSteps.clickPhDropdown();
        postPageSteps.clickLogoutButton();
    }

    public void deleteLetterAndReturn() {
        postPageSteps.clickDeleteButton();
        postPageSteps.clickReturnButton();
    }

    public void openTrashFolder(final String url) {
        postPageSteps.clickOpenTrashBinPage();
        postPageSteps.waitUntilURLContains(url);
        postPageSteps.waitUntilLastLetterIsClickable();
    }
}
