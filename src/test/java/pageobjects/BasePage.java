package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// here we put selectors and methods common to all subpages of our test application
// we do that we can see in automationpractice.com that footer and headers are the same on all subpages

public class BasePage {
    // @FindBy to Page Factory and expands Page Object
    @FindBy(id="search_query_top") // it's the same as driver.findElement(By.id("search_query_top"))
            WebElement searchBox;          // it's the same as driver.findElement(By.id("search_query_top"))

    @FindBy(css = ".menu-content>li>a")
    List<WebElement> productCategories; // List <WebElement> productCategories = driver.findElements (By.cssSelector (". Menu-content> li> a"));

    @FindBy(css = ".shopping_cart .ajax_cart_quantity")
    WebElement cartQuantity;

    @FindBy(className = "login")
    WebElement signInButton;

    WebDriver driver; // because our diver is here so every other class inherits this driver
    WebDriverWait wait;

    static final String BASE_URL = "http://automationpractice.com/";

    public BasePage(WebDriver driverIn, WebDriverWait waitIn) { // we need create constructor to give 'static' WebDriver diver;' from tests / java / tests / BaseTests
        this.driver = driverIn; // driverIn is driver with comes from our method executed
        this.wait = waitIn;
        // we must say in constructor that InteliJ IDEA should initialize and find elements @FindBy
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        // write searching keyword in search box and enter
        searchBox.sendKeys("dress"); // in search pool we type dress
        searchBox.sendKeys(Keys.ENTER); // confirm searching phrase with enter
    }

    // Menu: WOMEN | DRESSES | T-SHIRTS is available in all subpages we can put method
    // opening selected category in our BasePage class:
    public void goToProductCategoryByIndex(int productCategoryIndex) { // depending with we choose (WOMEN, DRESSES, T-SHIRTS) method will click on this what we choose
        // we created locator to three elements on menu bar in @FindBy
        productCategories.get(productCategoryIndex).click(); // we click on forwarded "productCategoryIndex" in menu
    }

    public int getCartSize() {
        String cartQuantityText = cartQuantity.getText();
        return Integer.parseInt(cartQuantityText);
    }

    public void clickSignIn() {
        signInButton.click();
    }

}
