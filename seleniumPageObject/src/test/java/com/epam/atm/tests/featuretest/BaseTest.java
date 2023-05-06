package com.epam.atm.tests.featuretest;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    private By elementBy;

    public void setupClassEdge() throws MalformedURLException {
        //  WebDriverManager.chromedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WIN10);
        caps.setBrowserName("edge");
        caps.setCapability(EdgeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        // driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    public void setupClassChrome() throws MalformedURLException {
        //  WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WIN10);
        caps.setBrowserName("chrome");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        // driver = new ChromeDriver(options);
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
