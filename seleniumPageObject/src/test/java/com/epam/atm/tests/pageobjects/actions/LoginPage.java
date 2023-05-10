package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public ComposePage loginValidUser(String textName, String password) {

    /*    driver.findElement(textNameBy).sendKeys(textName);
        driver.findElement(nextNameBy).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(passwordBy));
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(nextNameBy).click();
        return new ComposePage(driver);*/

        //actions usage
        new Actions(driver)
                .clickAndHold(driver.findElement(textNameBy))
                .sendKeys(textName)
                .click(driver.findElement(nextNameBy))
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(passwordBy));


       new Actions(driver)
                .clickAndHold(driver.findElement(passwordBy))
                .sendKeys(password)
                .click(driver.findElement(nextNameBy))
                .perform();
        return new ComposePage(driver);
    }
}

