package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    @FindBy(id="search_query_top")
    WebElement searchBox;

    @FindBy(css = ".menu-content>li>a")
    List<WebElement> productCategories;

    @FindBy(css = ".shopping_cart .ajax_cart_quantity")
    WebElement cartQuantity;

    WebDriver driver;
    WebDriverWait wait;

    static final String BASE_URL = "http://automationpractice.com/";

    public BasePage(WebDriver driverIn, WebDriverWait waitIn) {
        this.driver = driverIn;

        this.wait = waitIn;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);
    }

    public void goToProductCategoryByIndex(int productCategoryIndex) {
        productCategories.get(productCategoryIndex).click();
    }

    public int getCartSize() {
        String cartQuantityText = cartQuantity.getText();
        return Integer.parseInt(cartQuantityText);
    }
}
