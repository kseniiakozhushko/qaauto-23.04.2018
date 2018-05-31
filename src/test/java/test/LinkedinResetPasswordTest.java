package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinRequestPasswordResetPage;

public class LinkedinResetPasswordTest extends LinkedinBaseTest{

    @Test
    public void successfullPasswordResetTest(){
        String userEmail = "ksko.ksko1996@gmail.com";
        String newUserPassword = "P@ssword12345";

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(), "RequestPasswordResetPage is not loaded");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(), "RequestPasswordResetSubmitPage is not loaded");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(), "SetNewPasswordPage is not loaded");

        linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);

        LinkedinSuccessfullPasswordResetPage linkedinSuccessfullPasswordResetPage = linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(LinkedinSuccessfullPasswordResetPage.isPageLoaded(), "SuccessfullPasswordResetPage is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinSuccessfullPasswordResetPage.clickOnGoToHomeButton();
        Assert.assertTrue(LinkedinHomePage.isPageLoaded(), "HomePage is not loaded");

    }

}
