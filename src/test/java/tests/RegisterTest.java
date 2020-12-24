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

    @Test
    void shouldNoRegisterNewUserWhenNotAllMandatoryDataIsProvided() {
        // nie należy rejestrować nowego użytkownika, gdy nie podano wszystkich obowiązkowych danych
        // implementacja testu (korzystamy z imilementacji RandomUser, z LoginPage oraz z RegisterPage)
    }

    @Test
    void shouldNoRegisterNewUserWhenIncorrectValueOfMandatoryDataIsProvided() {
        // nie należy rejestrować nowego użytkownika w przypadku podania nieprawidłowej wartości obowiązkowych danych
        // implementacja testu (korzystamy z implementacji RandomUser, z LoginPage oraz z RegisterPage)
    }
}