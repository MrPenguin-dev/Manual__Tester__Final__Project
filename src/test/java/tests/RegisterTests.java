package tests;

import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTests extends BaseTests {
    @Test
    void shouldRegisterNewUserWhenAllMandatoryDataIsProvided() throws InterruptedException { // positive registration
        RandomUser user = new RandomUser();
        System.out.println(user); // we print used user to test. It's needed as log for tests

        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage(); // Open main Page

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToRegisterForm();

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUser(user);
    }
}