package com.epam.atm.tests.pageobjects;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
   protected WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        }

        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin");


    WebElement textName = driver.findElement(By.name("identifier"));
        textName.sendKeys("serhii1testmail@gmail.com");

    WebElement nextName = driver.findElement(By.xpath("//span[text()='Next']//parent::button"));
        nextName.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));

    WebElement textPassword = driver.findElement(By.xpath("//input[@type='password']"));
        textPassword.sendKeys("Password1#");

    WebElement nextPassword = driver.findElement(By.xpath("//span[text()='Next']//parent::button"));
        nextPassword.click();

}

