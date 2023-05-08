package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComposePage extends BasePage {

    private By composeBy = By.xpath("//div[text()='Compose']");

    public ComposePage(WebDriver driver) {
        super(driver);
    }

    public By getComposeBy() {
        waitElementToBeClicable(composeBy);
        return composeBy;
    }

    public FillEmailPage compose() {

        driver.findElement(composeBy).click();
        return new FillEmailPage(driver);
    }
}
