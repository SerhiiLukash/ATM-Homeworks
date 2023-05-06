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
        // TODO: Seems URL is extra in this case. It is login page, so assumption that you already get to the right URL in previous actions.
        ComposePage composePage = loginPage.loginValidUser(url, textName, password);
        // TODO: we could create separate method on the page and call it isUserLogin
        Assert.assertTrue(composePage.confirmationFolder(composePage.getComposeBy())); // Check if user is logged in
        // TODO: as you return page from class you could use chain of invocations composePage.compose().fillInEmail(body, subject, recipient);
        FillEmailPage fillEmailPage = composePage.compose();
        // TODO: we could introduce some Business objects like email, user and use them intead of 3 strings.
        fillEmailPage.fillInEmail(body, subject, recipient);
        // TODO: is draft page olways shown when we close compose?
        DraftFolderPage draftFolderPage = fillEmailPage.close();
        CheckEmailPage checkEmailPage = draftFolderPage.openMailInDrafts();
        waitExplicit();
        // TODO: you declared those things as veriable subject, recipient, I suggest you them instead of strings.
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
