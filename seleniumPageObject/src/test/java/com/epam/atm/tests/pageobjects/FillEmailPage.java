package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillEmailPage extends PageObject {

    private By textBodyBy = By.xpath("//div[@aria-label='Message Body']");
    private By textSubjectBy = By.name("subjectbox");
    private By fieldRecipientBy = By.xpath("//div[text()='Recipients']");
    private By textRecipientBy = By.xpath("//input[@aria-haspopup='listbox']");
    private By crossSignBy = By.xpath("//*[@aria-label='Save & close']");

    public FillEmailPage(WebDriver driver) {
        super(driver);
    }

    public void fillInEmail(String body, String subject, String recipient) {

        waitElementToBeClicable(textBodyBy);
        driver.findElement(textBodyBy).sendKeys(body);
        driver.findElement(textSubjectBy).sendKeys(subject);
        driver.findElement(fieldRecipientBy).click();
        driver.findElement(textRecipientBy).sendKeys(recipient);

    }

    public DraftFolderPage close() {
        driver.findElement(crossSignBy).click();
        return new DraftFolderPage(driver);
    }

    public By getTextBodyBy() {
        return textBodyBy;
    }

    public By getTextSubjectBy() {
        return textSubjectBy;
    }
}
