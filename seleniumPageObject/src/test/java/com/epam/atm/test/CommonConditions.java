package com.epam.atm.test;

import com.epam.atm.driver.DriverSingleton;

import com.epam.atm.model.user.UserFactory;
import com.epam.atm.model.user.UserWithCredentialsCreator;
import com.epam.atm.model.user.UserWithoutCredentialsCreator;
import com.epam.atm.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class CommonConditions {
    protected static WebDriver driver;

    public UserFactory getUserFactory(boolean isUserValid) {

        if (isUserValid) {
            return new UserWithCredentialsCreator();
        } else {
            return new UserWithoutCredentialsCreator();
        }
    }


    public void setUp() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
    }
    //  @AfterEach
    //  public void stopBrowser () {DriverSingleton.closeDriver();}
}
