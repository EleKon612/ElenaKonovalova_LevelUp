package ru.levelp.at.lesson0507.selenium.page.objects.homework4;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private WebElement lastDraftMessage;

    @FindBy(xpath = "//span[@class='ll-crpt']")
    private WebElement lastDraftMessageReceiver;

    @FindBy(xpath = "//span[@class='ll-sj__normal']")
    private WebElement lastDraftMessageSubject;

    @FindBy(xpath = "//span[@class='llc__snippet']")
    private WebElement lastDraftMessageBody;

    @FindBy(xpath = "//*[text()='" + receiver + "']")
    private WebElement testDraftMessageReceiver;

    @FindBy(xpath = "//*[text()='" + subject + "']")
    private WebElement testDraftMessageSubject;

    @FindBy(xpath = "//*[text()='" + letterBody + "']")
    private WebElement testDraftMessageBody;

    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendDraftButton;

    @FindBy(xpath = "//*[contains(@class, 'button2_close')]")
    private WebElement crossButton;

    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentPage;

    @FindBy(xpath = "//div[contains(@class, 'llc__content')]")
    private WebElement lastSentMessage;

    @FindBy(xpath = "//span[contains(@class, 'ph-dropdown-icon')]")
    private WebElement phDropdown;

    @FindBy(xpath = "//div[contains(@class, 'ph-item__hover-active')]")
    private WebElement logoutButton;

    public Exercise1Refactor(WebDriver driver) {
        super(driver);
    }

    public void openMailru() {
        driver.navigate().to(MAILRU_URL);
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

    public void waitUntilVisibilityOfNewLetterButton() {
        waitUntilVisibilityOfElement(newLetterButton);
    }

    public void clickNewLetterButton() {
        clickButton(newLetterButton);
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

    public void clickSaveDraftButton() {
        clickButton(saveDraftButton);
    }

    public void clickCloseDraftButton() {
        clickButton(closeDraftButton);
    }

    public void waitUntilVisibilityOfTestMessageSubject() {
        waitUntilVisibilityOfElement(testDraftMessageSubject);
    }

    public void waitUntilVisibilityOfTestMessageBody() {
        waitUntilVisibilityOfElement(testDraftMessageBody);
    }

    public void waitUntilInvisibilityOfTestMessageSubject() {
        waitUntilInvisibilityOfElement(testDraftMessageSubject);
    }

    public void clickOpenDraftsPage() {
        clickButton(draftsPage);
    }

    public void clickOpenLastDraftMessage() {
        clickButton(lastDraftMessage);
    }

    public void waitUntilSendDraftButtonToBeClickable() {
        waitUntilElementToBeClickable(sendDraftButton);
    }

    public void clickSendDraftButton() {
        clickButton(sendDraftButton);
    }

    public void clickCrossButton() {
        clickButton(crossButton);
    }

    public void waitUntilURLContainsSent() {
        waitUntilUrlContains(sentURL);
    }

    public void clickOpenSentPage() {
        clickButton(sentPage);
    }

    public void clickOpenLastSentMessage() {
        clickButton(lastSentMessage);
    }

    public void clickPhDropdown() {
        clickButton(phDropdown);
    }

    public void clickLogoutButton() {
        clickButton(logoutButton);
    }

    public String getSubjectOfLastDraftMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastDraftMessageSubject)).getText();
    }

    public String getReceiverOfLastDraftMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastDraftMessageReceiver)).getText();
    }

    public String getBodyOfLastDraftMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastDraftMessageBody)).getText();
    }
}