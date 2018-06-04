package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import java.util.concurrent.TimeUnit;

public class LinkedinResetPasswordTest extends LinkedinBaseTest{

    @Test
    public void successfullPasswordResetTest() {
        String userEmail = "ksko.ksko1996@gmail.com";
        String newUserPassword = "P@ssword123";

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(), "RequestPasswordResetPage is not loaded");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        webDriver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(), "RequestPasswordResetSubmitPage is not loaded");


        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(), "SetNewPasswordPage is not loaded");

        LinkedinSuccessfullPasswordResetPage linkedinSuccessfullPasswordResetPage = linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(linkedinSuccessfullPasswordResetPage.isPageLoaded(), "SuccessfullPasswordResetPage is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinSuccessfullPasswordResetPage.clickOnGoToHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "HomePage is not loaded");

    }

}
