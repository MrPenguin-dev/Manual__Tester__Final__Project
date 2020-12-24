package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    WebElement emailAddressField;

    @FindBy(id = "passwd")
    WebElement passwdField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(className = "logout")
    WebElement signOutButton;

    @FindBy(id = "email_create")
    WebElement createNewAccountField;

    @FindBy(id = "SubmitCreate")
    WebElement createNewAccountButton;

    public LoginPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void goToRegisterForm() throws InterruptedException {
        RandomUser user = new RandomUser();
        clickSignIn();
        createNewAccountField.sendKeys(user.email);
        createNewAccountButton.click();
    }

    public void signInToRegisteredAccount() {
        emailAddressField.sendKeys("test@autotest.pl"); // registered
        passwdField.sendKeys("autoTest_1234!"); // registered
        signInButton.click();
        Assertions.assertEquals(signOutButton.getText(), "Sign out");
    }

    public void signInToNotRegisteredAccount() {
        RandomUser user = new RandomUser();
        emailAddressField.sendKeys(user.email); // not registered
        passwdField.sendKeys(user.password); // not registered
        signInButton.click();
        // Assertions.assertEquals
    }

    public void continueOrderShouldAddProductToTheBasketAndBuyThroughRegisterForm() {
        RandomUser user = new RandomUser();
        createNewAccountField.sendKeys(user.email);
        createNewAccountButton.click();
    }

}
