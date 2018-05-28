import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement inputPassword;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LinkedinHomePage succesfullLogin(String email, String password){
        emailField.sendKeys(email);
        inputPassword.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class );
    }

    public LinkedinLoginSubmitPage unsuccesfullLogin(String email, String password){
        emailField.sendKeys(email);
        inputPassword.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinLoginSubmitPage.class );
    }

    public LinkedinLoginPage emptyFieldsLogin(String email, String password){
        emailField.sendKeys(email);
        inputPassword.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinLoginPage.class );
    }

    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
    }
}
