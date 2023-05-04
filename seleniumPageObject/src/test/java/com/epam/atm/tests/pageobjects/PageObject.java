package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitElementToBeClicable(By elementBy) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public String getAttributeBy(By elementBy, String attribute) {
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    public Boolean confirmationFolder(By elementBy) {

        return driver.findElement(elementBy).isDisplayed();
    }
}
