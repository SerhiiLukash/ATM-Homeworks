package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftFolderPage extends PageObject {

    //TODO: Not good idea to hardcode URL in locators. On the real project you could have several envs like qa.mail.google, dev.mail.google, etc.
    private By draftBy = By.xpath("//a[@href='https://mail.google.com/mail/u/0/#drafts']//parent::span");
    private By draftFolderBy = By.xpath("//*[text()='Drafts']");
    private By clickOnRowBy = By.xpath("//*[@class='bog']//span[text()='test subject']");

    public DraftFolderPage(WebDriver driver) {
        super(driver);
    }

    public CheckEmailPage openMailInDrafts() {

        driver.findElement(draftBy).click();
        waitElementToBeClicable(draftFolderBy);
        driver.findElement(draftFolderBy).click();
        waitElementToBeClicable(clickOnRowBy);
        driver.findElement(clickOnRowBy).click();
        return new CheckEmailPage(driver);
    }
}

