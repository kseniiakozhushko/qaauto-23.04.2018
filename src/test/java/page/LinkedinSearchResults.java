package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Search Result Page Object class
 */
public class LinkedinSearchResults extends LinkedinBasePage{

    @FindBy (xpath = "//h3[@class='search-results__total Sans-15px-black-55% mb2 mh5']")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//li[contains(@class, 'search-result search-result__occluded-item')]")
    private List<WebElement> searchResultElements;

    /**
     * Constructor of SearchResultsPage
     * @param webDriver - webDriver object
     */
    public LinkedinSearchResults(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchResultsCount, 5);
    }

    public boolean isPageLoaded() {

        return searchResultsCount.isDisplayed();
    }

    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
