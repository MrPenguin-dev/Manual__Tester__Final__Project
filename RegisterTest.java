package tests;

import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTest {
    @Test
    void shouldRegisterNewUserWhenAllMandatoryDataIsProvided() {

        RandomUser user = new RandomUser();
        System.out.println(user);

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToRegisterForm(user.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUser(user);
    }
}
