package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.ProductsPage;

public class CartTests extends BaseTests {
    @Test
    void shouldBeAbleAddProductToTheCart() {
        // create a Product page using the "goToProductCategoryPage()" method through which we go to any page
        ProductsPage productsPage = goToProductCategoryPage(0); // it's a result of goToProductCategoryPage(); method
        productsPage.addRandomProductToCart(); // order random product
        // Assertions.assertTrue(product in the basket);
        Assertions.assertEquals(1, productsPage.getCartSize()); // check if we have one product in the basket. Get how many products is in the basket and check if there is as many as we excepted (1)
    }

    @Test
    void shouldBeAbleAddMultipleProductsToTheCart() {
        ProductsPage productsPage = goToProductCategoryPage(1);
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        Assertions.assertEquals(2, productsPage.getCartSize());
    }

    private ProductsPage goToProductCategoryPage(int i) {
        HomePage homePage = new HomePage(driver, wait); // we sent to this Page Object class driver and wait
        homePage.openPage(); // Open main Page
        // on homepage we click on first element '0' from the menu list "productCategories" (WOMEN, DRESSES, T-SHIRTS)
        homePage.goToProductCategoryByIndex(0); // go to MENU > WOMEN
        // Then we want to simulate mouse move on products from the showed list on the page
        ProductsPage productsPage = new ProductsPage(driver, wait);
        return productsPage;
    }
}