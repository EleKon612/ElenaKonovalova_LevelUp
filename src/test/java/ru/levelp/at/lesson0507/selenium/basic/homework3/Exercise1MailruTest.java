package ru.levelp.at.lesson0507.selenium.basic.homework3;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Exercise1MailruTest extends Homework3SeleniumBaseTest {

    @Test
    public void exercise1Test() {
        // Открыть сайт mail.ru и нажать кнопку "Войти"
        driver.navigate().to(MAILRU_URL);

        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@class, 'resplash-btn')]"));
        enterButton.click();

        // Переключиться на логин фрейм
        WebElement loginFrame = driver.findElement(By.xpath(
            "//div/iframe[@class='ag-popup__frame__layout__iframe']"));
        driver.switchTo().frame(loginFrame);

        // Ввести логин и пароль
        WebElement insertAccountName = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='username']")));
        insertAccountName.sendKeys("elekon612" + Keys.ENTER);
        WebElement insertPassword = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[name='password']")));
        insertPassword.sendKeys("Selenium2022" + Keys.ENTER);

        // Дождаться загрузки страницы "Входящие" убедиться, что она открылась, и нажать кнопку "Написать письмо"
        WebElement newLetterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='compose-button__wrapper']")));
        driver.getCurrentUrl();
        assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru/inbox"));
        newLetterButton.click();

        // Переключиться на окно создания письма
        driver.switchTo().activeElement();

        // Ввести адресата, тему и тело письма
        WebElement insertReceivers = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'container--H9L5q')]")));
        insertReceivers.sendKeys("elena.volnova@mail.ru");
        WebElement insertSubject = driver.findElement(By.xpath("//*[@name='Subject']"));
        insertSubject.sendKeys("New TestLetter Subject");
        WebElement insertBody = driver.findElement(By.cssSelector(".cke_editable"));
        insertBody.sendKeys("New TestLetter Body");

        // Сохранить и закрыть черновик
        WebElement saveDraft = driver.findElement(By.xpath("//button[@data-test-id='save']"));
        saveDraft.click();
        WebElement closeDraft = driver.findElement(By.xpath("//button[@tabindex='700']"));
        closeDraft.click();

        // Открыть черновики
        WebElement openDrafts = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[@href='/drafts/']")));
        openDrafts.click();

        // Проверить, что письмо сохранилось в черновиках
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='New TestLetter Subject']")));
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).click();

        // Проверить контент, адресата и тему письма
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@data-test-id='send']")));
        assertTrue(driver.findElement(By.xpath("//*[@value='New TestLetter Subject']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[text()='elena.volnova@mail.ru']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div[text()='New TestLetter Body']")).isDisplayed());

        // Отправить сохраненный черновик
        driver.findElement(By.xpath("//button[@data-test-id='send']")).click();

        // Закрыть окно "Сообщение отправлено"
        WebElement crossButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@class, 'button2_close')]")));
        crossButton.click();

        // Проверить, что письмо изчезло из черновиков (assert проходит, если в черновиках есть последнее письмо с отличной от тестового письма темой)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[text()='New TestLetter Subject']")));
        WebElement lastDraftLetter = driver.findElement(By.xpath("//*[@class='ll-sj__normal']"));
        assertFalse(lastDraftLetter.getText().contains("New TestLetter Subject"));

        // Перейти в "Отправленные"
        WebElement openSent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='/sent/']")));
        openSent.click();
        wait.until(ExpectedConditions.urlContains("sent"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New TestLetter Subject']")));

        // Verify, что письмо появилось в папке отправленные, открыть его и проверить содержимое
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'letter__body')]")));
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Subject']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[text()='elena.volnova@mail.ru']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[text()='New TestLetter Body']")).isDisplayed());

        //  Выйти из учетной записи
        WebElement dropDown = driver.findElement(By.xpath(
                "//span[contains(@class, 'ph-dropdown-icon')]"));
        dropDown.click();
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'ph-item__hover-active')]")));
        logout.click();
    }
}
