package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Login Page Object class
 */
public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement inputPassword;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    /**
     * Constructor of LoginPage
     * @param webDriver - webDriver Object
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    /**
     * @param email - email object
     * @param password - password object
     * @param <T> - generic type
     */
    public <T> T login(String email, String password){
        emailField.sendKeys(email);
        inputPassword.sendKeys(password);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")){
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")){
            return (T) new LinkedinLoginSubmitPage(webDriver);
        }
        else {
            return (T) this;
        }
    }

    /**
     * clickOnForgotPasswordLink navigate to LinkedinRequestPasswordResetPage
     */
    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return new LinkedinRequestPasswordResetPage(webDriver);
    }
}
