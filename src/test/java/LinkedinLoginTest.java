import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

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
    public void successfulLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In Button is not displayed");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),"https://www.linkedin.com/feed/", "Home Page URL is wrong.");
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"), "Home page Title is wrong" );
    }

    @Test(dataProvider = "invalidDataProvider")
    public void negativeReturnedToLoginSubmitTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In Button is not displayed");
        linkedinLoginPage.login(email, password);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Wrong error message text displayed");
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(), "Login-Submit page is not loaded");

    }

    @Test(dataProvider = "emptyFieldsDataProvider")
    public void emptyFieldsLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In Button is not displayed");
        linkedinLoginPage.login(email, password);

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(), "https://www.linkedin.com/", "Login Page Url is wrong");
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(), "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
    }

}
