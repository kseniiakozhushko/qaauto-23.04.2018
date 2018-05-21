import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage {
    private WebElement emailField;
    private WebElement inputPassword;
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements(){
        emailField = webDriver.findElement(By.id("login-email"));
        inputPassword = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }

    public void login(String email, String password){
        emailField.sendKeys(email);
        inputPassword.sendKeys(password);
        signInButton.click();
    }

    public boolean isSignInButtonDisplayed() {
            return signInButton.isDisplayed();
    }
}



