package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

import java.util.List;
import java.util.Random;

public class RegisterPage extends BasePage {
    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "id_gender1")
    WebElement customerGender1;

    @FindBy(id = "id_gender2")
    WebElement customerGender2;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement daysSelect;
    Select selectDays = new Select(daysSelect);

    @FindBy(id = "month")
    WebElement monthsSelect;
    Select selectMonths = new Select(monthsSelect);

    @FindBy(id = "years")
    WebElement yearsSelect;
    Select selectYears = new Select(yearsSelect);

    @FindBy(id = "address1")
    WebElement customerAddress;

    @FindBy(id = "city")
    WebElement customerCity;

    @FindBy(id = "id_state")
    WebElement customerStateSelect;
    Select stateSelect = new Select(customerStateSelect);

    @FindBy(id ="postcode")
    WebElement postCode;

    @FindBy(id = "phone_mobile")
    WebElement customerPhoneMobile;

    @FindBy(id = "alias")
    WebElement customerAlias;

    @FindBy(id = "submitAccount")
    WebElement submitAccountButton;

    @FindBy(id = "logout")
    WebElement signOutButton;

    public RegisterPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void registerUser(RandomUser user) throws InterruptedException {
        RandomGender();
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
        password.sendKeys(user.password);
        selectDays.selectByIndex(1);
        selectMonths.selectByIndex(1);
        selectYears.selectByIndex(1);
        customerAddress.sendKeys(user.address1);
        customerCity.sendKeys(user.city); // we don't have city generator in faker so we type anything
        stateSelect.selectByIndex(1);
        postCode.sendKeys(user.zipCode);
        customerPhoneMobile.sendKeys(user.phoneNumber);
        customerAlias.sendKeys(user.firstName);
        submitAccountButton.click();
        Assertions.assertEquals(signOutButton.getText(), "Sign out");
    }

    private void RandomGender() {
        Random random = new Random();
        int gender = random.nextInt(2);
        if (gender == 0) {
            customerGender1.click();
        } else {
            customerGender2.click();
        }
    }
}