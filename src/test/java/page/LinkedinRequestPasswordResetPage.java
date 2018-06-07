package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Request Password Reset Page Object class
 */
public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {


    /**
     * Constructor of RequstPasswordResetPage
     * @param webDriver - webDriver Object
     */
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

    /**
     * method to add user email to get link
     * @param userEmail - user email to send link
     */
    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String userEmail) {
        gMailService.connect();
        userNameField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }
}
