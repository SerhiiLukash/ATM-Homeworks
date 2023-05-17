package com.epam.atm.tests.maintests;

import com.epam.atm.tests.driver.DriverSingleton;
import org.junit.jupiter.api.BeforeEach;
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
