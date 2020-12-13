package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driverIn) {
        this.driver = driverIn;
    }

    public boolean isProductWithNameVisible(String expectedProductName) {
        List<WebElement> productsNames = driver.findElements(By.cssSelector(".product_list .product-name"));
        int counter = 0;
        for (WebElement productName : productsNames) {
            System.out.println(productName.getText());
            if (productName.getText().toLowerCase().contains(expectedProductName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public String getSearchSummary() {
        WebElement searchSummary = driver.findElement(By.cssSelector(".heading-counter"));
        return searchSummary.getText();
    }
}
