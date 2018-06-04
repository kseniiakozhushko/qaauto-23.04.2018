package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage{
    public LinkedinSetNewPasswordPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed() ;
    }

    @FindBy(xpath = "//input[@type='password' and contains(@name, 'newPassword')]")
    private WebElement inputNewPasswordField;

    @FindBy(xpath = "//input[@type='password' and contains(@name, 'confirmPassword')]")
    private WebElement confirmNewPasswordField;

    @FindBy(id= "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    public LinkedinSuccessfullPasswordResetPage submitNewPassword(String newUserPassword) {
        inputNewPasswordField.sendKeys(newUserPassword);
        confirmNewPasswordField.sendKeys(newUserPassword);
        resetPasswordSubmitButton.click();
        return new LinkedinSuccessfullPasswordResetPage(webDriver);
    }
}
