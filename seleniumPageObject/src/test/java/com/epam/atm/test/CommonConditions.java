package com.epam.atm.test;

import com.epam.atm.driver.DriverSingleton;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class CommonConditions {
    protected WebDriver driver;


    public  void setUp () throws MalformedURLException {
        driver = DriverSingleton.getDriver ();
    }
  //  @AfterEach
  //  public void stopBrowser () {DriverSingleton.closeDriver();}
}