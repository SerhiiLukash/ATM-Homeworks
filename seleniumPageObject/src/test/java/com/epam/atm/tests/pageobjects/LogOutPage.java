package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage extends PageObject {

    private By menuButtonBy = By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com&service=mail']");
    private By logoutBy = By.xpath("//*[text()='Sign out']//parent::div//parent::span//parent::a");

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {

        driver.findElement(menuButtonBy).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("//iframe[@name='account']")));
        waitElementToBeClicable(logoutBy);
        driver.findElement(logoutBy).click();

    }
}
