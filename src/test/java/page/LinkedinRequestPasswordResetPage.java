package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {


    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
     public boolean isPageLoaded() {
        return submitButton.isDisplayed() && userNameField.isDisplayed();
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement submitButton;

    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String userEmail) {
        gMailService.connect();
        userNameField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }
}
