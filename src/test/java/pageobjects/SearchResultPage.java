package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends BasePage {
    @FindBy(id = ".product_list .product-name")
    List<WebElement> productsNames;

    @FindBy(css = ".heading-counter")
    WebElement searchSummary;

    public SearchResultPage(WebDriver driverIn, WebDriverWait waitIn) {
        super(driverIn, waitIn);
    }

    public boolean isProductWithNameVisible(String expectedProductName) {
        // findElements return List of elements so we must create variable to use found elements after in our code. cssSelector(String)
        // List<WebElement> productsNames = driver.findElements(By.cssSelector(".product_list .product-name"));

        // Now we must create method to check every find element if it have 'expectedProductName'. We use foreach loop:
        // First we tell what is kind of element (WebElement), next give him a name (productName), and in with collection are these productsName ? (productsNames)

        for (WebElement productName : productsNames) {
            System.out.println(productName.getText()); // in console view we type what is find
            if (productName.getText().toLowerCase().contains(expectedProductName.toLowerCase())) {
                return true; // if is return true
            }
        }
        return false; // when loop end find nothing
    }

    public String getSearchSummary() {
        // WebElement searchSummary = driver.findElement(By.cssSelector(".heading-counter"));

        return searchSummary.getText(); // we must return text we found
    }
}
