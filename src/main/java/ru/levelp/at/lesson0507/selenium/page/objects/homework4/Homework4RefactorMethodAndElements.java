package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homework4RefactorMethodAndElements extends Homework4RefactorBasePage {

    @FindBy(xpath = "//*[contains(@class, 'resplash-btn')]")
    private WebElement loginButton;
    @FindBy(xpath = "//div/iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement loginFrame;
    @FindBy(css = "[name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//*[text()='Enter password']")
    private WebElement enterPasswordButton;
    @FindBy(css = "[name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[text()='Sign in']")
    private WebElement signInButton;
    @FindBy(xpath = "//a[contains(@class, 'compose-button')]")
    private WebElement newLetterButton;
    @FindBy(xpath = "//*[@class='container--zU301']")
    private WebElement receiverField;
    @FindBy(xpath = "//*[@name='Subject']")
    private WebElement subjectField;
    @FindBy(css = ".cke_editable")
    private WebElement bodyField;
    @FindBy(xpath = "//button[@data-test-id='save']")
    private WebElement saveDraftButton;
    @FindBy(xpath = "//button[@tabindex='700']")
    private WebElement closeDraftButton;
    @FindBy(xpath = "//a[@href='/drafts/']")
    private WebElement draftsPage;
    @FindBy(xpath = "//div[contains(@class, 'llc__content')]")
    private WebElement lastMessage;
    @FindBy(xpath = "//div[contains(@class, 'mt-h-c__item_snippet')]")
    private WebElement selfMessagesInInbox;
    @FindBy(xpath = "//span[@class='ll-crpt']")
    private WebElement lastMessageReceiver;
    @FindBy(xpath = "//span[@class='ll-sj__normal']")
    private WebElement lastMessageSubject;
    @FindBy(xpath = "//*[text()='" + subject1 + "']")
    private WebElement testMessageSubjectExercise1;
    @FindBy(xpath = "//*[text()='" + subject2 + "']")
    private WebElement testMessageSubjectExercise2;
    @FindBy(xpath = "//*[text()='" + subject3 + "']")
    private WebElement testMessageSubjectExercise3;
    @FindBy(xpath = "//span[@class='llc__snippet']")
    private WebElement lastMessageBody;
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendLetterButton;
    @FindBy(xpath = "//*[contains(@class, 'button2_close')]")
    private WebElement crossButton;
    @FindBy(xpath = "//*[contains(@class, 'button2_delete')]")
    private WebElement deleteButton;
    @FindBy(xpath = "//*[contains(@class, 'button2_arrow-back')]")
    private WebElement returnButton;
    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentPage;
    @FindBy(xpath = "//a[@href='/1/']")
    private WebElement testPage;
    @FindBy(xpath = "//a[@href='/inbox/']")
    private WebElement inboxPage;
    @FindBy(xpath = "//a[@href='/trash/']")
    private WebElement trashBinPage;
    @FindBy(xpath = "//span[contains(@class, 'ph-dropdown-icon')]")
    private WebElement phDropdown;
    @FindBy(xpath = "//div[contains(@class, 'ph-item__hover-active')]")
    private WebElement logoutButton;

    public Homework4RefactorMethodAndElements(WebDriver driver) {
        super(driver);
    }

    public void openMailRu() {
        openURL(mailRuURL);
    }

    public void switchToLoginFrame() {
        switchToFrame(loginFrame);
    }

    public void insertUsername(final String username) {
        insertInputField(usernameField, username);
    }

    public void insertPassword(final String password) {
        insertInputField(passwordField, password);
    }

    public void insertReceiver(final CharSequence receiver) {
        insertInputField(receiverField, receiver);
    }

    public void insertSubject(final CharSequence subject) {
        insertInputField(subjectField, subject);
    }

    public void insertBody(final CharSequence letterBody) {
        insertInputField(bodyField, letterBody);
    }

    public void waitUntilVisibilityOfNewLetterButton() {
        waitUntilVisibilityOfElement(newLetterButton);
    }

    public void waitUntilVisibilityOfTestMessageSubjectExercise2() {
        waitUntilVisibilityOfElement(testMessageSubjectExercise2);
    }

    public void waitUntilVisibilityOfTestMessageSubjectExercise3() {
        waitUntilVisibilityOfElement(testMessageSubjectExercise3);
    }

    public void waitUntilInvisibilityOfTestMessage1() {
        waitUntilInvisibilityOfElement(testMessageSubjectExercise1);
    }

    public void waitUntilLastLetterIsClickable() {
        waitUntilElementToBeClickable(lastMessageSubject);
    }

    public void waitUntilURLContainsSent() {
        waitUntilUrlContains(sentURL);
    }

    public void waitUntilURLContainsDrafts() {
        waitUntilUrlContains(draftsURL);
    }

    public void waitUntilURLContainsTrash() {
        waitUntilUrlContains(trashURL);
    }

    public void waitUntilURLContainsTestFolderIndex() {
        waitUntilUrlContains(testFolderURL);
    }

    public void clickLoginButton() {
        clickButton(loginButton);
    }

    public void clickEnterPasswordButton() {
        clickButton(enterPasswordButton);
    }

    public void clickSignInButton() {
        clickButton(signInButton);
    }

    public void clickNewLetterButton() {
        clickButton(newLetterButton);
    }

    public void clickSaveDraftButton() {
        clickButton(saveDraftButton);
    }

    public void clickCloseDraftButton() {
        clickButton(closeDraftButton);
    }

    public void clickOpenDraftsPage() {
        clickButton(draftsPage);
    }

    public void clickOpenLastMessage() {
        clickButton(lastMessage);
    }

    public void clickSendLetterButton() {
        clickButton(sendLetterButton);
    }

    public void clickCrossButton() {
        clickButton(crossButton);
    }

    public void clickDeleteButton() {
        clickButton(deleteButton);
    }

    public void clickReturnButton() {
        clickButton(returnButton);
    }

    public void clickOpenSentPage() {
        clickButton(sentPage);
    }

    public void clickOpenTestFolderPage() {
        clickButton(testPage);
    }

    public void clickSelfMessagesInInboxPage() {
        clickButton(selfMessagesInInbox);
    }

    public void clickOpenTrashBinPage() {
        clickButton(trashBinPage);
    }

    public void clickPhDropdown() {
        clickButton(phDropdown);
    }

    public void clickLogoutButton() {
        clickButton(logoutButton);
    }

    public String getSubjectOfLastMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastMessageSubject)).getText();
    }

    public String getReceiverOfLastMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastMessageReceiver)).getText();
    }

    public String getBodyOfLastMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastMessageBody)).getText();
    }
}