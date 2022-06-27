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
    @FindBy(xpath = "//span[@class='ll-crpt']")
    private WebElement lastMessageReceiver;
    @FindBy(xpath = "//span[@class='ll-sj__normal']")
    private WebElement lastMessageSubject;
    @FindBy(xpath = "//span[@class='llc__snippet']")
    private WebElement lastMessageBody;
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendLetterButton;
    @FindBy(xpath = "//*[contains(@class, 'button2_close')]")
    private WebElement crossButton;
    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentPage;
    @FindBy(xpath = "//span[contains(@class, 'ph-dropdown-icon')]")
    private WebElement phDropdown;
    @FindBy(xpath = "//div[contains(@class, 'ph-item__hover-active')]")
    private WebElement logoutButton;

    public Homework4RefactorMethodAndElements(WebDriver driver) {
        super(driver);
    }

    public void openMailru() {
        driver.navigate().to(mailruURL);
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

    public void waitUntilVisibilityOfTestMessageSubject(WebElement subjectWebElement) {
        waitUntilVisibilityOfElement(subjectWebElement);
    }

    public void waitUntilVisibilityOfTestMessageBody(final WebElement bodyWebElement) {
        waitUntilVisibilityOfElement(bodyWebElement);
    }

    public void waitUntilVisibilityOfLastMessageSubject() {
        waitUntilVisibilityOfElement(lastMessageSubject);
    }

    public void waitUntilLastMessageSubjectToBeClickable() {
        waitUntilElementToBeClickable(lastMessageSubject);
    }

    public void waitUntilInvisibilityOfTestMessageSubject(final WebElement subjectWebElement) {
        waitUntilInvisibilityOfElement(subjectWebElement);
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

    public void clickOpenSentPage() {
        clickButton(sentPage);
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

    public String getSubjectOfLastSentMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastMessageSubject)).getText();
    }

    public String getReceiverOfLastMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastMessageReceiver)).getText();
    }

    public String getBodyOfLastMessage() {
        return wait.until(ExpectedConditions.visibilityOf(lastMessageBody)).getText();
    }
}