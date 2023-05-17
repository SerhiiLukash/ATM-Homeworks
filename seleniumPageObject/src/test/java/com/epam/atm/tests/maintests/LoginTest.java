package com.epam.atm.tests.maintests;

import com.epam.atm.tests.maintests.CommonConditions;
import com.epam.atm.tests.pageobjects.BaseObjects.Email;
import com.epam.atm.tests.pageobjects.actions.*;
import com.epam.atm.tests.pageobjects.folders.DraftFolderPage;
import com.epam.atm.tests.pageobjects.folders.SentFolderPage;
import com.epam.atm.tests.service.UserCreator;
import com.epam.atm.tests.waiters.Waiter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.MalformedURLException;

import static com.epam.atm.tests.utils.LoginUtils.isUserLogin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends CommonConditions {

    private final static String textName = "serhii1testmail@gmail.com";
    private final static String password = "Password1#";


    private final static String body = "test body";

    private final static String subject = "test subject";

    private final static String recipient = "vasiliy.luk52@gmail.com";
    private final static String url = "https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";


   @Tag("smoke")
    @Test
    public void testLogin() throws Exception {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location =\"" + url + "\"");
        LoginPage loginPage = new LoginPage(driver);
        ComposePage composePage = loginPage.loginValidUser(UserCreator.withoutFile());
        Assert.assertTrue(isUserLogin(composePage)); // Check if user is logged in

    }


}
