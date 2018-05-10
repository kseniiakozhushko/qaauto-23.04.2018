import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        //Assert.assertEquals( "a","b", "Probably 'a' is not equal to 'b'");
        Assert.assertEquals(actualLoginPageTitle,"LinkedIn: Log In or Sign Up", "Login page Title is wrong");

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement inputPassword = webDriver.findElement(By.id("login-password"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        Assert.assertFalse(signInButton.isDisplayed(), "Sign In button is not Displayed.");

        emailField.sendKeys("ksko.ksko1996@gmail.com");
        inputPassword.sendKeys("reckless1");
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.linkedin.com/feed/", "Home Page URL is wrong.");

        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle, "Page title did not change after Sign In");

        //Assert.assertEquals(webDriver.getTitle(),"LinkedIn", "Home page Title is wrong" );
        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"), "Home page Title is wrong" );





    }





}
