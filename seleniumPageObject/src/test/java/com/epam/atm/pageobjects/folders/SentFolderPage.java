package com.epam.atm.pageobjects.folders;

import com.epam.atm.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentFolderPage extends BasePage {

    private By checkDraftBy = By.xpath("//*[text()[contains(.,'Saving')]]");
    private By sentEmailBy = By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']");
    private By sentFolderBy = By.xpath("//*[text()='Sent']");


    public SentFolderPage(WebDriver driver) {
        super(driver);
    }

    public By getCheckDraftBy() {
        return checkDraftBy;
    }


    public void sentEmail() {

        driver.findElement(sentEmailBy).click();
        waitElementToBeClicable(sentFolderBy);
        driver.findElement(sentFolderBy).click();

    }

}
