package com.epam.atm.test;

import com.epam.atm.driver.DriverSingleton;

import com.epam.atm.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
@Listeners ({TestListener.class})
public class CommonConditions {
    protected static WebDriver driver;


    public  void setUp () throws MalformedURLException {
        driver = DriverSingleton.getDriver ();
    }
  //  @AfterEach
  //  public void stopBrowser () {DriverSingleton.closeDriver();}
}
