package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchTest extends BaseTest {
    @Test
    void shouldReturnCorrectProductListWhenPositiveSearchPhraseIsUsed() {

        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.searchForProduct("dress");

        SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        Assertions.assertTrue(searchResultPage.isProductWithNameVisible("dress"));
        Assertions.assertEquals("7 results have been found.", searchResultPage.getSearchSummary());
    }
}
