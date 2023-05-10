package com.epam.atm.tests.featuretest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;


    protected enum Driver {Chrome, ChromeRemote, EdgeRemote };

    public void setupDriver(Driver driverType) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (driverType) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
              //  options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case ChromeRemote:
                ChromeOptions optionsRemote = new ChromeOptions();
                optionsRemote.addArguments("--incognito");
                caps.setBrowserName("chrome");
                caps.setPlatform(Platform.WIN10);
                caps.setCapability(ChromeOptions.CAPABILITY, optionsRemote);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                break;
            case EdgeRemote:
                EdgeOptions optionsEdge = new EdgeOptions();
                optionsEdge.addArguments("--incognito");
                caps.setBrowserName("edge");
                caps.setPlatform(Platform.WIN10);
                caps.setCapability(EdgeOptions.CAPABILITY, optionsEdge);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
    }


    public void waitExplicit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
     /*   @AfterAll
    void teardown() {
        driver.quit();
    }*/
}
