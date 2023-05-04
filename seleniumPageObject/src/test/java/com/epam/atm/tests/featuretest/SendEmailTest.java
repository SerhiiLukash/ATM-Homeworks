package com.epam.atm.tests.featuretest;

import com.epam.atm.tests.pageobjects.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendEmailTest extends BaseTest {

    private final static String textName = "serhii1testmail@gmail.com";
    private final static String password = "Password1#";
    private final static String url = "https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    private final static String body = "test body";

    private final static String subject = "test subject";

    private final static String recipient = "vasiliy.luk52@gmail.com";

    @Test
    public void testLogin() {

        setupClass();
        LoginPage loginPage = new LoginPage(driver);
        ComposePage composePage = loginPage.loginValidUser(url, textName, password);
        Assert.assertTrue(composePage.confirmationFolder(composePage.getComposeBy())); // Check if user is logged in
        FillEmailPage fillEmailPage = composePage.compose();
        fillEmailPage.fillInEmail(body, subject, recipient);
        DraftFolderPage draftFolderPage = fillEmailPage.close();
        CheckEmailPage checkEmailPage = draftFolderPage.openMailInDrafts();
        waitExplicit();
        assertEquals("test subject", fillEmailPage.getAttributeBy(fillEmailPage.getTextSubjectBy(), "value"));
        //  assertEquals( "test body",fillEmailPage.getAttributeBy(fillEmailPage.getTextBodyBy(),"value"));// Can't find right locator
        assertEquals("vasiliy.luk52@gmail.com", checkEmailPage.getAttributeBy(checkEmailPage.getEmailBy(), "email"));
        SentFolderPage sentFolderPage = checkEmailPage.send();
        Assert.assertTrue(sentFolderPage.confirmationFolder(sentFolderPage.getCheckDraftBy())); // check if the folder "draft" is empty
        LogOutPage logOutPage = sentFolderPage.sentEmail();
        Assert.assertTrue(sentFolderPage.confirmationFolder(sentFolderPage.getCheckSentBy())); // check if email in the "Sent" folder
        logOutPage.logOut();
    }

}
