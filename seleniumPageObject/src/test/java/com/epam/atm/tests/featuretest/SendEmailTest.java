package com.epam.atm.tests.featuretest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SendEmailTest {
    WebDriver driver;

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

 /*   @AfterAll
    void teardown() {
        driver.quit();
    }*/

    @Test
    void test() {


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Compose']")));
        WebElement textCompose = driver.findElement(By.xpath("//div[text()='Compose']"));
        Assert.assertEquals(true, textCompose.isDisplayed()); // Check if user is logged in
        textCompose.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Message Body']")));
        WebElement textBody = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        textBody.sendKeys("test body");

        WebElement textSubject = driver.findElement(By.name("subjectbox"));
        textSubject.sendKeys("test subject");

        WebElement fieldRecipient = driver.findElement(By.xpath("//div[text()='Recipients']"));
        fieldRecipient.click();

        WebElement textRecipient = driver.findElement(By.xpath("//input[@aria-haspopup='listbox']"));
        textRecipient.sendKeys("vasiliy.luk52@gmail.com");

        WebElement crossSign = driver.findElement(By.xpath("//*[@aria-label='Save & close']"));
        crossSign.click();


        // new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("m//a[@href='https://mail.google.com/mail/u/0/#drafts']//parent::span")));
        WebElement draft = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#drafts']//parent::span"));
      /*  JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", draft);*/
        draft.click();


        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Drafts']")));
        WebElement draftFolder = driver.findElement(By.xpath("//*[text()='Drafts']"));
        draftFolder.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='bog']//span[text()='test subject']")));
        WebElement clickOnRow = driver.findElement(By.xpath("//*[@class='bog']//span[text()='test subject']"));
        clickOnRow.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement textSubject1 = driver.findElement(By.xpath("//*[@name='subjectbox']"));
        assertEquals("test subject", textSubject1.getAttribute("value"));

        //    WebElement textBody1 = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));  // Can't find this element
        //    assertEquals( "test body", textBody1.getAttribute("value"))  ;

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@email='vasiliy.luk52@gmail.com']")));
        WebElement email = driver.findElement(By.xpath("//*[@email='vasiliy.luk52@gmail.com']"));
        assertEquals("vasiliy.luk52@gmail.com", email.getAttribute("email"));

        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();

        WebElement checkDraft = driver.findElement(By.xpath("//*[text()[contains(.,'Saving')]]"));
        assertTrue(checkDraft.isDisplayed()); // check if the folder "draft" is empty

        WebElement sentEmail = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']"));
        sentEmail.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Drafts']")));
        WebElement sentFolder = driver.findElement(By.xpath("//*[text()='Sent']"));
        sentFolder.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='bog']//span[text()='test subject']")));
        WebElement checkSent = driver.findElement(By.xpath("//*[@class='bog']//span[text()='test subject']"));
        assertTrue(checkSent.isDisplayed());  // check if email in the "Sent" folder

        WebElement menuButton = driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com&service=mail']"));
        menuButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement iframe = driver.findElement(By.cssSelector("//iframe[@name='account']"));
        driver.switchTo().frame(iframe);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign out']//parent::div//parent::span//parent::a")));
        WebElement sinOut = driver.findElement(By.xpath("//*[text()='Sign out']//parent::div//parent::span//parent::a"));
        sinOut.click();

    }


}
