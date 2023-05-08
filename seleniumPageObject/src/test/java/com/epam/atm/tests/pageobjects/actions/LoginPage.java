package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.pageobjects.BasePage;
import com.epam.atm.tests.pageobjects.actions.ComposePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {


    private By textNameBy = By.name("identifier");
    private By passwordBy = By.xpath("//input[@type='password']");
    private By nextNameBy = By.xpath("//span[text()='Next']//parent::button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public ComposePage loginValidUser(String textName, String password) {
        // TODO: I suggest to move navigation to upper logic and leave here only stuff related to actual login.
       // FIXED
        driver.findElement(textNameBy).sendKeys(textName);
        driver.findElement(nextNameBy).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(passwordBy));
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(nextNameBy).click();
        return new ComposePage(driver);

    }
}

