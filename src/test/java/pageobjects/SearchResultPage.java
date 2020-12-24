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
        for (WebElement productName : productsNames) {
            System.out.println(productName.getText());
            if (productName.getText().toLowerCase().contains(expectedProductName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public String getSearchSummary() {
        return searchSummary.getText();
    }
}