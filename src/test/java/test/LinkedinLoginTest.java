package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinLoginSubmitPage;

public class LinkedinLoginTest extends LinkedinBaseTest {
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
    public void successfulLoginTest(String email, String password) throws InterruptedException {
        //linkedinLoginPage.waitUntilElementIsClickable(, 30);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Login Page is not loaded");

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),"https://www.linkedin.com/feed/", "Home Page URL is wrong.");
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"), "Home page Title is wrong" );
    }

    @Test(dataProvider = "invalidDataProvider")
    public void negativeReturnedToLoginSubmitTest(String email, String password) {

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page is not loaded");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Wrong error message text displayed");
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(), "Login-Submit page is not loaded");
    }

    @Test(dataProvider = "emptyFieldsDataProvider")
    public void emptyFieldsLoginTest(String email, String password) {

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login Page is not loaded");

        LinkedinLoginPage linkedinLoginPage1 = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinLoginPage1.getCurrentUrl(), "https://www.linkedin.com/", "Login Page Url is wrong");
        Assert.assertEquals(linkedinLoginPage1.getCurrentTitle(), "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
    }



}