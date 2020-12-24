package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecutionOfOrdersPage extends BasePage {
    @FindBy(how = How.NAME, using = "processAddress")
    WebElement proceedToCheckout;

    @FindBy(id = "uniform-cgv")
    WebElement termsOfServiceCheckBox;

    @FindBy(how = How.NAME, using = "processCarrier")
    WebElement proceedToCheckoutAgain;

    @FindBy(className = "bankwire")
    WebElement payByBankWireButton;

    @FindBy(className = "cheque")
    WebElement payByCheckButton;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'confirm ' )]")
    WebElement confirmMyOrderButton;

    public ExecutionOfOrdersPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void completionOfTheOrder() {
        proceedToCheckout.click();
        termsOfServiceCheckBox.click();
        proceedToCheckoutAgain.click();
        payByBankWireButton.click();
        confirmMyOrderButton.click();
    }

}
