package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Exercise1Refactor extends Exercise1RefactorBasePage {

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

    @FindBy(xpath = "//*[text()='Sign in']")
    private WebElement inboxPage;

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

    @FindBy(xpath = "//*[@class='ll-sj__normal']")
    private WebElement lastDraftMessage;

    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendDraftButton;

    @FindBy(xpath = "//*[contains(@class, 'button2_close')]")
    private WebElement crossButton;

    @FindBy(xpath = "//span[text()='" + receiver + "']")
    private WebElement ourDraftMessageReceiver;

    @FindBy(xpath = "//*[text()='" + subject + "']")
    private WebElement ourDraftMessageSubject;

    @FindBy(xpath = "//*[text()='" + letterBody + "']")
    private WebElement ourDraftMessageBody;

    // llc__item_correspondent llc__content

    public Exercise1Refactor(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickButton(loginButton);
    }

    public void switchToLoginFrame() {
        switchToFrame(loginFrame);
    }

    public void insertUsername(final String username) {
        insertInputField(usernameField, username);
    }

    public void clickEnterPasswordButton() {
        clickButton(enterPasswordButton);
    }

    public void insertPassword(final String password) {
        insertInputField(passwordField, password);
    }

    public void clickSignInButton() {
        clickButton(signInButton);
    }

    public void clickNewLetterButton() {
        clickButton(newLetterButton);
    }

    public void insertReceiver(final String receiver) {
        insertInputField(receiverField, receiver);
    }

    public void insertSubject(final String subject) {
        insertInputField(subjectField, subject);
    }

    public void insertBody(final String letterBody) {
        insertInputField(bodyField, letterBody);
    }

    public void clickSaveDraftButton() {
        clickButton(saveDraftButton);
    }

    public void clickCloseDraftButton() {
        clickButton(closeDraftButton);
    }

    public void clickOpenDraftsButton() {
        clickButton(draftsPage);
    }

    public void tapLastDraftMessage() {
        clickButton(lastDraftMessage);
    }

    public void clickSendDraftButton() {
        clickButton(sendDraftButton);
    }

    public void clickCrossButton() {
        clickButton(crossButton);
    }
}