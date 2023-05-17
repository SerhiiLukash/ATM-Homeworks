package com.epam.atm.test;

import com.epam.atm.pageobjects.BaseObjects.Email;
import com.epam.atm.pageobjects.actions.*;
import com.epam.atm.service.UserCreator;

import com.epam.atm.pageobjects.folders.DraftFolderPage;
import com.epam.atm.pageobjects.folders.SentFolderPage;
import com.epam.atm.waiters.Waiter;

import com.epam.atm.utils.LoginUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public class SendEmailTest extends CommonConditions {




    private static final String BODY = "test body";

    private static final String SUBJECT = "test subject";

    private static final String RECIPIENT = "vasiliy.luk52@gmail.com";
    private static final String URL = "https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    // Complex actions are used in fillInEmail class and LoginPage class,
    // JavaScript Executor is used in CheckEmailPage class and @Test


    @Test
    public void testAllFlow() throws MalformedURLException {
        setUp();
        Email email = new Email(RECIPIENT, SUBJECT, BODY);
        //   driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location =\"" + URL + "\"");
        LoginPage loginPage = new LoginPage(driver);
        ComposePage composePage = loginPage.loginValidUser(UserCreator.withCredentials());
        Assert.assertTrue(LoginUtils.isUserLogin(composePage)); // Check if user is logged in
        FillEmailPage fillEmailPage = composePage.compose();
        fillEmailPage.fillInEmail(email);
        GoToDraftFolderPage goToDraftFolderPage = fillEmailPage.close();
        DraftFolderPage draftFolderPage = goToDraftFolderPage.goToDraftFolder();
        CheckEmailPage checkEmailPage = draftFolderPage.openMailInDrafts(SUBJECT);
        Waiter.waitExplicit();
        assertEquals(SUBJECT, fillEmailPage.getAttributeBy(fillEmailPage.getTextSubjectBy(), "value"));
        //  assertEquals( "test body",fillEmailPage.getAttributeBy(fillEmailPage.getTextBodyBy(),"value"));// Can't find right locator
        assertEquals(RECIPIENT, checkEmailPage.getAttributeBy(checkEmailPage.getEmailBy(RECIPIENT), "email"));
        SentFolderPage sentFolderPage = checkEmailPage.send();
        Assert.assertTrue(sentFolderPage.ifElementIsDisplayed(sentFolderPage.getCheckDraftBy())); // check if the folder "draft" is empty
        sentFolderPage.sentEmail();
        LogOutPage logOutPage = new LogOutPage(driver);
        Assert.assertTrue(sentFolderPage.ifElementIsDisplayed(draftFolderPage.getCheckBySubject(SUBJECT))); // check if email in the "Sent" folder using locator of subject
        logOutPage.logOut();
    }




}
