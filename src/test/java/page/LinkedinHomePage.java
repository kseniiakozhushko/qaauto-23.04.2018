package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Home Page Object class
 */
public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchField;

    /**
     * Constructor of HomePage
     * @param webDriver - webDriver object
     */
    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {

        return profileNavItem.isDisplayed();
    }

    /**
     * Search method
     * @param searchTerm - search parameter
     */
    public LinkedinSearchResults search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new LinkedinSearchResults(webDriver);
    }
}
