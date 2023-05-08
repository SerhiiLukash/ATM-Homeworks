package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.pageobjects.BasePage;
import com.epam.atm.tests.pageobjects.folders.SentFolderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckEmailPage extends BasePage {

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
