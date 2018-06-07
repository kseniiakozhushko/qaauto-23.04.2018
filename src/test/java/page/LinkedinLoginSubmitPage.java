package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Login Submit Page Object class
 */
public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    @FindBy(xpath = "//div[@role='alert']" )
    private WebElement errorMessage;

    @FindBy(id = "session_key-login" )
    private WebElement emailField;


    /**
     * Constructor of LoginSubmitPage
     * @param webDriver - webDriver Object
     */
    public LinkedinLoginSubmitPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }

    public boolean isPageLoaded(){
        return emailField.isDisplayed();
    }
}

