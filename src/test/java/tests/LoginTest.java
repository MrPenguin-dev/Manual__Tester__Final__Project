package tests;

import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void shouldRedirectToMyAccountPageWhenCorrectCredentialsAreUsed() {
        // powinno przekierować do strony Moje konto kiedy używane są prawidłowe poświadczenia
        // implementacja testu (korzystamy z LoginPage oraz z MyAccountPage)
    }

    @Test
    void shouldRedirectToTheReLoginPageWhenCredentialsAreNotUsed() {
        // powinien przekierować do ponownego logowania strony, kiedy poświadczenia nie są używane
        // implementacja testu (korzystamy z LoginPage oraz z MyAccountPage)
    }
}
