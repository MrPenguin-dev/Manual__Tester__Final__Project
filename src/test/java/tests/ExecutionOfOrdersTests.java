package tests;

import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomUser;

public class ExecutionOfOrdersTests extends BaseTests {
    @Test
    void shouldAddProductToTheBasketAndBuyThroughRegisterForm() throws InterruptedException {
        RandomUser user = new RandomUser();
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.addRandomProductToCartAndProceedCheckout();

        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.continueOrderShouldAddProductToTheBasketAndBuyThroughRegisterForm();

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUser(user);

        ExecutionOfOrdersPage executionOfOrdersPage = new ExecutionOfOrdersPage(driver, wait);
        executionOfOrdersPage.completionOfTheOrder();
    }
}