package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckEmailPage extends PageObject {

    // TODO: it is not good idea to hardcode email in locators. It should be dynamic.
    private By emailBy = By.xpath("//*[@email='vasiliy.luk52@gmail.com']");
    private By sendButtonBy = By.xpath("//div[text()='Send']");

    public CheckEmailPage(WebDriver driver) {
        super(driver);
    }

    public By getEmailBy() {
        waitElementToBeClicable(emailBy);
        return emailBy;
    }

    public SentFolderPage send() {

        driver.findElement(sendButtonBy).click();
        return new SentFolderPage(driver);
    }
}
