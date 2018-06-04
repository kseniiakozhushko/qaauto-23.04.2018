package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccessfullPasswordResetPage extends LinkedinBasePage{
    public LinkedinSuccessfullPasswordResetPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return goToHomeButton.isDisplayed();
    }

    @FindBy(id = "reset-password-submit-button")
    private WebElement goToHomeButton ;

    public LinkedinHomePage clickOnGoToHomeButton() {
         goToHomeButton.click();
         return new LinkedinHomePage(webDriver);
    }
}
