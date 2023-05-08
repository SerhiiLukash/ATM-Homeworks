package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    private final int WAITER_DURATION = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;


    }

    public void waitElementToBeClicable(By elementBy) {

        new WebDriverWait(driver, Duration.ofSeconds(WAITER_DURATION)).until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public String getAttributeBy(By elementBy, String attribute) {
        return driver.findElement(elementBy).getAttribute(attribute);
    }


    public Boolean ifElementIsDisplayed(By elementBy) {

        return driver.findElement(elementBy).isDisplayed();
    }
}
