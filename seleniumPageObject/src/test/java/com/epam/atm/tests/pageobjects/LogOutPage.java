package com.epam.atm.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage extends PageObject {

    //TODO: Again not good to hardcode URL domain. At some point company may decide to switch DNS or use some caching layer, security layer, replace with load balancer URL etc.
    private By menuButtonBy = By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com&service=mail']");
    private By logoutBy = By.xpath("//*[text()='Sign out']//parent::div//parent::span//parent::a");

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {

        driver.findElement(menuButtonBy).click();
        WebElement iframe = driver.findElement(By.cssSelector("//iframe[@name='account']"));
        driver.switchTo().frame(iframe);
        waitElementToBeClicable(logoutBy);
        driver.findElement(logoutBy).click();

    }
}
