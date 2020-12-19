package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void goToRegisterForm(String email) {
        // wpisz email w pole CREATE AN ACCOUNT > email address
        // wciśnij enter
    }
}
