package com.epam.atm.pageobjects.actions;

import com.epam.atm.pageobjects.BaseObjects.Email;
import com.epam.atm.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FillEmailPage extends BasePage {

    private By textBodyBy = By.xpath("//div[@aria-label='Message Body']");
    private By textSubjectBy = By.name("subjectbox");
    private By fieldRecipientBy = By.xpath("//div[text()='Recipients']");
    private By textRecipientBy = By.xpath("//input[@aria-haspopup='listbox']");
    private By crossSignBy = By.xpath("//*[@aria-label='Save & close']");

    public FillEmailPage(WebDriver driver) {
        super(driver);
    }


    public void fillInEmail(Email email) {

       waitElementToBeClicable(textBodyBy);
     /*    driver.findElement(textBodyBy).sendKeys(email.getBody());
        driver.findElement(textSubjectBy).sendKeys(email.getSubject());
        driver.findElement(fieldRecipientBy).click();
        driver.findElement(textRecipientBy).sendKeys(email.getRecipient()); */

        new Actions(driver)
                .clickAndHold(driver.findElement(textBodyBy))
                .sendKeys(email.getBody())
                .clickAndHold(driver.findElement(textSubjectBy))
                .sendKeys(email.getSubject())
                .pause(Duration.ofSeconds(1))
                .click(driver.findElement(fieldRecipientBy))
                .clickAndHold(driver.findElement(textRecipientBy))
                .sendKeys(email.getRecipient())
                .perform();
    }

    public GoToDraftFolderPage close() {
        driver.findElement(crossSignBy).click();
        return new GoToDraftFolderPage(driver);
    }

    public By getTextBodyBy() {
        return textBodyBy;
    }

    public By getTextSubjectBy() {
        return textSubjectBy;
    }
}
