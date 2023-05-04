package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentFolderPage extends PageObject {

    private By checkDraftBy = By.xpath("//*[text()[contains(.,'Saving')]]");
    private By sentEmailBy = By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']");
    private By sentFolderBy = By.xpath("//*[text()='Sent']");
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
        return new LogOutPage(driver);
    }
}
