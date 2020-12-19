package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.ProductsPage;

public class CartTest extends BaseTest {
    @Test
    void shouldBeAbleAddProductToTheCart() {
        ProductsPage productsPage = goToProductCategoryPage(0);
        productsPage.addRandomProductToCart();
        Assertions.assertEquals(1, productsPage.getCartSize());
    }

    @Test
    void shouldBeAbleAddMultipleProductsToTheCart() {
        ProductsPage productsPage = goToProductCategoryPage(1);
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        Assertions.assertEquals(2, productsPage.getCartSize());
    }

    private ProductsPage goToProductCategoryPage(int i) {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToProductCategoryByIndex(0);
        return new ProductsPage(driver, wait);
    }
}
