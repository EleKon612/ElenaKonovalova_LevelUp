package ru.levelp.at.lesson1011.allure;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homework4PostPageAllureSteps extends Homework4BasePageAllureSteps {

    protected WebDriver driver;

    public Homework4PostPageAllureSteps(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

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
    @FindBy(xpath = "//div[contains(@class, 'llc__content')]")
    private List<WebElement> lastMessageSubjectList;
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
    @FindBy(xpath = "//*[contains(@class, 'button2_status_read')]")
    private WebElement markAllUnreadButton;
    @FindBy(xpath = "//a[@href='/sent/']")
    private WebElement sentPage;
    @FindBy(xpath = "//a[@href='/1/']")
    private WebElement testPage;
    @FindBy(xpath = "//a[@href='/trash/']")
    private WebElement trashBinPage;
    @FindBy(xpath = "//span[contains(@class, 'ph-dropdown-icon')]")
    private WebElement phDropdown;
    @FindBy(xpath = "//div[contains(@class, 'ph-item__hover-active')]")
    private WebElement logoutButton;

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

    public void waitUntilVisibilityOfMarkUnreadButton() {
        waitUntilVisibilityOfElement(markAllUnreadButton);
    }

    public void waitUntilTheListOfMessagesIsEmpty() {
        wait.until(ExpectedConditions.invisibilityOfAllElements((lastMessageSubjectList)));
    }

    public boolean confirmThatListOfMessagesIsEmpty() {
        invisibilityOfElements(lastMessageSubjectList);
        return true;
    }

    public void waitUntilLastLetterIsClickable() {
        waitUntilElementToBeClickable(lastMessageSubject);
    }

    public void waitUntilURLContains(final String pageURL) {
        waitUntilUrlContains(pageURL);
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

    public void clickOpenDraftsPage() {
        clickButton(draftsPage);
    }

    public void clickOpenSentPage() {
        clickButton(sentPage);
    }

    public void clickOpenTestFolderPage() {
        clickButton(testPage);
    }

    public void clickOpenTrashBinPage() {
        clickButton(trashBinPage);
    }

    public void clickSelfMessagesInInboxPage() {
        clickButton(selfMessagesInInbox);
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