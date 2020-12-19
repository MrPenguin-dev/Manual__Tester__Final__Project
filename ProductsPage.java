package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {
    @FindBy(css = ".product_list .product-container")
    List<WebElement> productsContainers;

    @FindBy(css = ".ajax_add_to_cart_button")
    List<WebElement> addToCartButtons;

    @FindBy(className = "continue")
    WebElement continueShoppingButton;

    public ProductsPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public void moveMouseToProductContainer(int productIndex) {
        Actions builder = new Actions(driver);
        builder.moveToElement(productsContainers.get(productIndex)).build().perform();
    }

    public void addProductToTheBasket(int productIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(productIndex)));
        addToCartButtons.get(productIndex).click();

        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public void addRandomProductToCart() {
        Random rnd = new Random();
        int productIndex = rnd.nextInt(productsContainers.size());

        moveMouseToProductContainer(productIndex);

        addProductToTheBasket(productIndex);
    }
}
