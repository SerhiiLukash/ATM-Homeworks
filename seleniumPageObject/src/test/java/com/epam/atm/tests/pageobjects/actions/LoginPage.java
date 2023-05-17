package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.model.User;
import com.epam.atm.tests.pageobjects.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
    private final Logger logger = LogManager.getRootLogger();

    public ComposePage loginValidUser(User user) {

    /*    driver.findElement(textNameBy).sendKeys(textName);
        driver.findElement(nextNameBy).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(passwordBy));
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(nextNameBy).click();
        return new ComposePage(driver);*/

        //actions usage
        new Actions(driver)
                .clickAndHold(driver.findElement(textNameBy))
                .sendKeys(user.getUsername())
                .click(driver.findElement(nextNameBy))
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(passwordBy));


       new Actions(driver)
                .clickAndHold(driver.findElement(passwordBy))
                .sendKeys(user.getPassword())
                .click(driver.findElement(nextNameBy))
                .perform();

        logger.info("User " + user.getUsername() + " is logged in");
        return new ComposePage(driver);
    }
}

