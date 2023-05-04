package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageObject {


    private By textNameBy = By.name("identifier");
    private By passwordBy = By.xpath("//input[@type='password']");
    private By nextNameBy = By.xpath("//span[text()='Next']//parent::button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public ComposePage loginValidUser(String url, String textName, String password) {
        driver.get(url);
        driver.findElement(textNameBy).sendKeys(textName);
        driver.findElement(nextNameBy).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(passwordBy));
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(nextNameBy).click();
        return new ComposePage(driver);

    }
}

