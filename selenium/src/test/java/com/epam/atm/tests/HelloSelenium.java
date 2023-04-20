package com.epam.atm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HelloSelenium {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--headless=new","--start-maximized");
        options.setExperimentalOption("detach", true);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String title = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        textBox.sendKeys("Selenium");
        submitButton.click();
        boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
        boolean value = driver.findElement(By.name("btnK")).isEnabled();
        boolean value1 = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();
        String value2 = driver.findElement(By.cssSelector("h1")).getTagName();
        String cssValue = driver.findElement(By.linkText("More information...")).getCssValue("color");
        String text = driver.findElement(By.cssSelector("h1")).getText();
        WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));
        WebElement emailTxt = driver.findElement(By.name(("email_input")));
        String valueInfo = emailTxt.getAttribute("value");
        driver.quit();
    }
}

