package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodAndElements;

public class Exercise3RefactorTest extends Homework4RefactorBaseTest {

    private final String receiver = "elekon612@mail.ru";
    private final String subject = "This is a cool letter";
    private final String letterBody = "Перемен требуют наши сердца";

    @Test
    public void exercise3Test() {
        Homework4RefactorMethodAndElements mailRu = new Homework4RefactorMethodAndElements(driver);
        mailRu.openMailru();

        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, 'resplash-btn')]"));
        enterButton.click();
        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);
        WebElement insertAccountName = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='username']")));
        insertAccountName.sendKeys("elekon612" + Keys.ENTER);
        WebElement insertPassword = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='password']")));
        insertPassword.sendKeys("Selenium2022" + Keys.ENTER);

        // Assert, что вход выполнен успешно,
        WebElement newLetterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='compose-button__wrapper']")));
        driver.getCurrentUrl();
        assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru/inbox"));

        // Создать новое письмо (заполнить адресата (самого себя), тему письма и тело)
        newLetterButton.click();
        driver.switchTo().activeElement();
        WebElement insertReceivers = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'container--H9L5q')]")));
        insertReceivers.sendKeys(receiver);
        WebElement insertSubject = driver.findElement(By.xpath("//*[@name='Subject']"));
        insertSubject.sendKeys(subject);
        WebElement insertBody = driver.findElement(By.cssSelector(".cke_editable"));
        insertBody.sendKeys(letterBody);

        // Отправить письмо
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()='Отправить']")));
        WebElement sentWindow = driver.switchTo().activeElement();
        sentWindow.sendKeys(Keys.COMMAND, Keys.ENTER);

        // Закрыть окно "Сообщение отправлено"
        WebElement crossButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@class, 'button2_close')]")));
        crossButton.click();

        // Verify, что письмо появилось в папке входящие
        WebElement openInbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Входящие']")));
        openInbox.click();
        WebElement expandSaved = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Exercise3 Subject']")));
        expandSaved.click();
        WebElement sentLetterInInbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Exercise3 Subject']")));
        assertTrue(driver.findElement(By.xpath("//span[text()='Exercise3 Subject']")).isDisplayed());

        // Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        sentLetterInInbox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/h2[text()='Exercise3 Subject']")));
        assertTrue(driver.findElement(By.xpath("//div/h2[text()='Exercise3 Subject']")).isEnabled());
        assertTrue(driver.findElement(By.xpath("//*[@title='elekon612@mail.ru']")).isEnabled());
        assertTrue(driver.findElement(By.xpath("//div[text()='Exercise3 Body']")).isEnabled());

        // Удалить письмо
        WebElement deleteCurrentLetter = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Удалить']")));
        deleteCurrentLetter.click();

        // Verify что письмо появилось в папке Корзина
        WebElement returnTo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Вернуться']")));
        returnTo.click();
        WebElement openTrashBin = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='Корзина']")));
        openTrashBin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Exercise3 Subject']")));
        assertTrue(driver.findElement(By.xpath("//span[text()='Exercise3 Subject']")).isDisplayed());

        //  Выйти из учетной записи
        WebElement dropDown = driver.findElement(By.xpath(
                "//span[contains(@class, 'ph-dropdown-icon')]"));
        dropDown.click();
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Выйти']")));
        logout.click();
    }
}
