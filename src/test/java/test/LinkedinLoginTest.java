package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinLoginSubmitPage;

/**
 * Login Test Class
 */
public class LinkedinLoginTest extends LinkedinBaseTest {
    /**
     * valid credentials, invalid credentials and empty fields for login
     * @return
     */
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "ksko.ksko1996@gmail.com", "reckless1" },
                { "KSKO.KSKO1996@GMAIL.COM", "reckless1" },
        };
    }

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "ksko.ksko1996@gmail.com", "1" },
                { "KSKO.KSKO1996@GMAIL.COM", "reckless2" },
                { "ksko.ksko1996@gmail.com", "RECKLESS1" },
                { "KSKO.KSKO1996@GMAIL.COM", "RECKLESS1" },
                { "ksko.ksko@gmail.com", "reckless1" },
        };
    }

    @DataProvider
    public Object[][] emptyFieldsDataProvider() {
        return new Object[][]{
                { "ksko.ksko1996@gmail.com", "" },
                { "", "reckless1" },
                { "", "" },
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password)  {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Login Page is not loaded");

    }

    @Test(dataProvider = "invalidDataProvider")
    public void negativeReturnedToLoginSubmitTest(String email, String password) {

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.login(email, password);
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(), "Login-Submit page is not loaded");
    }

    @Test(dataProvider = "emptyFieldsDataProvider")
    public void emptyFieldsLoginTest(String email, String password) {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page is not loaded");
        LinkedinLoginPage linkedinLoginPage1 = linkedinLoginPage.login(email, password);

    }



}
