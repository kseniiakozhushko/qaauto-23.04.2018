import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),"LinkedIn: Log In or Sign Up", "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In Button is not displayed");
        linkedinLoginPage.login("ksko.ksko1996@gmail.com", "reckless1");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),"https://www.linkedin.com/feed/", "Home Page URL is wrong.");
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"), "Home page Title is wrong" );
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(actualLoginPageTitle,"LinkedIn: Log In or Sign Up", "Login page Title is wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In Button is not displayed");
        linkedinLoginPage.login("ksko.ksko1996@gmail.com", "1");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "Login-Submit Page Url is wrong");
        Assert.assertEquals(currentPageTitle, "Войти в LinkedIn", "Login-Submit Page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Wrong error message text displayed");

    }

    @AfterMethod
    public void after(){
        webDriver.close();
    }





}
