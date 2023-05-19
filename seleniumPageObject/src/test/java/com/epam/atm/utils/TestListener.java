package com.epam.atm.utils;

import com.epam.atm.driver.DriverSingleton;
import com.epam.atm.test.LoginTest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log =  LogManager.getRootLogger();


    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
    }

    public void onTestFailure(ITestResult iTestResult) { saveScreenshot(); }

    public void onTestSkipped(ITestResult iTestResult) {
   }

     public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onTestFailedWithTimeout(ITestResult iTestResult) {
         }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }
    private void saveScreenshot()  {

        File screenCapture = null;
        try {
            screenCapture = ((TakesScreenshot) LoginTest
                    .getDriver())
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/"
                    +getCurrenTimeAsString() +
                    ".png"));

        } catch (IOException e) {
            log.error("Failed to save screenshot" );
        }
       }

    private String getCurrenTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-DD_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
