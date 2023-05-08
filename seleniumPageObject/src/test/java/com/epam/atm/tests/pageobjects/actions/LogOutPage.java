package com.epam.atm.tests.pageobjects.actions;

import com.epam.atm.tests.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage extends BasePage {

    private By menuButtonBy = By.xpath("//a[contains(@href,'SignOutOptions')]");
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
