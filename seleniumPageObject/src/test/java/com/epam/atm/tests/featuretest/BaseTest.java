package com.epam.atm.tests.featuretest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    // TODO: Seems never used. - FIXED

    // TODO: seems setup could be mark with some Before annotations. - FIXED
    @BeforeAll
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // TODO: Why do we need incognito mode? - Because, I have a lot of google accounts and without
        // incognito mode there are auto login or other issues appear
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
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
