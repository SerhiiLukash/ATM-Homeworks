package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// TODO: suggest to renaim to basePage or something similar.
public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        // TODO: Page factory need to be used when you use @FindBy annotations.
        PageFactory.initElements(driver, this);
    }

    public void waitElementToBeClicable(By elementBy) {
        // TODO: Number of seconds could be moved as a constant to separate class. It could be easily modified.
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public String getAttributeBy(By elementBy, String attribute) {
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    // TODO: name of method looks confusing. By the code seems like method check if any element is visible.
    public Boolean confirmationFolder(By elementBy) {

        return driver.findElement(elementBy).isDisplayed();
    }
}
