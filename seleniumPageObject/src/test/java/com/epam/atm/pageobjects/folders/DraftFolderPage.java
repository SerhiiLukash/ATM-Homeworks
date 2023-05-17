package com.epam.atm.pageobjects.folders;

import com.epam.atm.pageobjects.BasePage;
import com.epam.atm.pageobjects.actions.CheckEmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftFolderPage extends BasePage {

    private By draftBy = By.xpath("//a[contains(@href,'drafts')]//parent::span");
    private By draftFolderBy = By.xpath("//*[text()='Drafts']");
    private By clickOnRowBy = By.xpath("//*[@class='bog']//span[text()='test subject']");

    private String subjectString = "//*[@class='bog']//span[text()='%s']";

    public DraftFolderPage(WebDriver driver) {
        super(driver);
    }

    public CheckEmailPage openMailInDrafts(String subject) {

        By locator = getCheckBySubject(subject);
        waitElementToBeClicable(locator);
        driver.findElement(locator).click();
        return new CheckEmailPage(driver);
    }

    public By getCheckBySubject(String subject) {
        By locator = By.xpath(String.format(subjectString, subject));
        waitElementToBeClicable(locator);
        return locator;
    }
}

