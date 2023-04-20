package com.epam.atm.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

import static org.junit.Assert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChromeTest {

    WebDriver driver;

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
    }

    @AfterAll
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {

        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement textBox = driver.findElement(By.name("identifier"));
        textBox.sendKeys("serhii1testmail@gmail.com");
        WebElement submitButton = driver.findElement(By.xpath("//span[text()='Next']//parent::button"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

}