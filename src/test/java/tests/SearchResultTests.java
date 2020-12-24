package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

// extends mean that we load every elements from class BaseTests to class SearchTests
public class SearchResultTests extends BaseTests {
    @Test
    void shouldReturnCorrectProductListWhenPositiveSearchPhraseIsUsed() {
        // because our method from class HomePage are not static so we must create object
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage(); // Open main Page
        homePage.searchForProduct("dress"); // give searching keyword in search box
        // every open new page we need to create new object of this page SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        // here we have object from class SearchResultPage so now we can execute on this object some methods
        // adding assertion to check if search result is correct (shown find product names)

        Assertions.assertTrue(searchResultPage.isProductWithNameVisible("dress"));
        Assertions.assertEquals("7 results have been found.", searchResultPage.getSearchSummary());
    }
}