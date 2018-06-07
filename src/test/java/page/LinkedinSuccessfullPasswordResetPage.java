package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Successful Password Reset Page Object class
 */
public class LinkedinSuccessfullPasswordResetPage extends LinkedinBasePage{
    /**
     * Constructor of SuccessfulPasswordResetPage
     * @param webDriver - webDriver object
     */
    public LinkedinSuccessfullPasswordResetPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return goToHomeButton.isDisplayed();
    }

    @FindBy(id = "reset-password-submit-button")
    private WebElement goToHomeButton ;

    /**
     * clickOnGoToHomeButton - method to return to HomePage
     */
    public LinkedinHomePage clickOnGoToHomeButton() {
         goToHomeButton.click();
         return new LinkedinHomePage(webDriver);
    }
}
