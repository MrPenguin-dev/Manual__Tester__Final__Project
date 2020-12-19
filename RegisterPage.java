package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

public class RegisterPage extends BasePage{
    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    public RegisterPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void registerUser(RandomUser user) {
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
    }
}
