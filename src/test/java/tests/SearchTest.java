package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchTest extends BaseTest {

    @Test
    void shouldReturnCorrectProductListWhenPositiveSearchPhraseIsUsed() {
        // powinien zwrócić poprawną listę produktów, gdy użyto pozytywnej frazy wyszukiwania

        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.searchForProduct("dress");

        SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        Assertions.assertTrue(searchResultPage.isProductWithNameVisible("dress"));
        Assertions.assertEquals("7 results have been found.", searchResultPage.getSearchSummary());
    }

    @Test
    void shouldNotReturnCorrectProductListWhenNegativeSearchPhraseIsUsed() {
        // nie powinien zwracać prawidłowej listy produktów, gdy używana jest wykluczająca fraza wyszukiwania
    }
}