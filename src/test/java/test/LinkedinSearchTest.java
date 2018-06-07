package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResults;

import java.util.List;

/**
 * Search Test Class
 */
public class LinkedinSearchTest extends LinkedinBaseTest {

    @Test
    public void basicSearchTest(){
        String searchTerm = "HR";
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login("ksko.ksko1996@gmail.com", "P@ssword123");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home Page is not loaded");

        LinkedinSearchResults linkedinSearchResults = linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchResults.isPageLoaded(), "Login Page is not loaded");

        List<String> searchResultsList = linkedinSearchResults.getSearchResults();
        Assert.assertEquals(searchResultsList.size(),10, "Count of search result items is wrong.");

        for (String searchResult:searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "Searchterm "+searchResult+" was not found in:\n"+searchResult);

        }

    }
}
