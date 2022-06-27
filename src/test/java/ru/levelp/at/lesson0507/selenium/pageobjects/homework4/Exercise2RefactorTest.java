package ru.levelp.at.lesson0507.selenium.pageobjects.homework4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.homework4.Homework4RefactorMethodAndElements;

public class Exercise2RefactorTest extends Homework4RefactorBaseTest {

    @Test
    public void exercise2Test() {

        final String receiver = "elekon612@mail.ru";
        final String subject = "Test";
        final String letterBody = "Люблю тебя, Петра творенье";

        Homework4RefactorMethodAndElements mailRu = new Homework4RefactorMethodAndElements(driver);
        mailRu.openMailru();
        mailRu.clickLoginButton();
        mailRu.switchToLoginFrame();
        mailRu.insertUsername(username);
        mailRu.clickEnterPasswordButton();
        mailRu.insertPassword(password);
        mailRu.clickSignInButton();
        mailRu.waitUntilVisibilityOfNewLetterButton();
        assertTrue(mailRu.getCurrentURL().contains(inboxURL));

        mailRu.clickNewLetterButton();
        mailRu.switchToActiveElement();
        mailRu.insertReceiver(receiver);
        mailRu.insertSubject(subject);
        mailRu.insertBody(letterBody);
        mailRu.clickSendLetterButton();
        mailRu.clickCrossButton();

        // Verify, что письмо появилось в папке отправленные
        WebElement openSent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Отправленные']")));
        openSent.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Self: Тест']")));
        assertTrue(driver.findElement(By.xpath("//*[text()='Self: Тест']")).isDisplayed());

        // Verify, что письмо появилось в папке «Тест»
        WebElement openSaved = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Тест']")));
        openSaved.click();
        WebElement sentLetterInTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//span[text()='Тест']")));
        assertTrue(driver.findElement(By.xpath("//span[text()='Тест']")).isDisplayed());

        // Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        sentLetterInTest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/h2[text()='Тест']")));
        assertTrue(driver.findElement(By.xpath("//div/h2[text()='Тест']")).isEnabled());
        assertTrue(driver.findElement(By.xpath("//*[@title='elekon612@mail.ru']")).isEnabled());
        assertTrue(driver.findElement(By.xpath("//div[text()='Я помню чудное мгновенье']")).isEnabled());

        //  Выйти из учетной записи
        WebElement dropDown = driver.findElement(By.xpath(
                "//span[contains(@class, 'ph-dropdown-icon')]"));
        dropDown.click();
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Выйти']")));
        logout.click();
    }
}
