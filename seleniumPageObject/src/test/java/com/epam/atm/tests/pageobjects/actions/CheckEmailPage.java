package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.pageobjects.BasePage;
import com.epam.atm.tests.pageobjects.folders.SentFolderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckEmailPage extends BasePage {


    private String emailBy = "//*[@email='%s']";
    private By sendButtonBy = By.xpath("//div[text()='Send']");

    public CheckEmailPage(WebDriver driver) {
        super(driver);
    }

    public By getEmailBy(String email) {
        By locator = By.xpath(String.format(emailBy, email));
        waitElementToBeClicable(locator);
        return locator;
    }

    public SentFolderPage send() {

        driver.findElement(sendButtonBy).click();
        return new SentFolderPage(driver);
    }
}
