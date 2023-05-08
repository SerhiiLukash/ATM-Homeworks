package com.epam.atm.tests.pageobjects.folders;

import com.epam.atm.tests.pageobjects.BasePage;
import com.epam.atm.tests.pageobjects.actions.LogOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentFolderPage extends BasePage {

    private By checkDraftBy = By.xpath("//*[text()[contains(.,'Saving')]]");
    private By sentEmailBy = By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']");
    private By sentFolderBy = By.xpath("//*[text()='Sent']");

    // TODO: locators are done in the way you are limited with specific subject of email "test subject" that is not very convinient.
    private By checkSentBy = By.xpath("//*[@class='bog']//span[text()='test subject']");

    public SentFolderPage(WebDriver driver) {
        super(driver);
    }

    public By getCheckDraftBy() {
        return checkDraftBy;
    }

    public By getCheckSentBy() {
        waitElementToBeClicable(checkSentBy);
        return checkSentBy;
    }

    public LogOutPage sentEmail() {

        driver.findElement(sentEmailBy).click();
        waitElementToBeClicable(sentFolderBy);
        driver.findElement(sentFolderBy).click();
        // TODO: is sentEmail always return logout page.
        return new LogOutPage(driver);
    }
}
