package com.epam.atm.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static WebDriver driver;


    public static WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    //  options.addArguments("--incognito");
                    driver = new ChromeDriver(options);
                    break;
                case "chromeRemote":
                    ChromeOptions optionsRemote = new ChromeOptions();
                    optionsRemote.addArguments("--incognito");
                    caps.setBrowserName("chrome");
                    caps.setPlatform(Platform.WIN10);
                    caps.setCapability(ChromeOptions.CAPABILITY, optionsRemote);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                    break;
                case "edgeRemote":
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

        }
            driver.manage().window().maximize();
        return driver;
        }


    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
