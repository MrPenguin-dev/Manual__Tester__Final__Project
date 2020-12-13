package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    static final String BASE_URL = "http://automationpractice.com/";

    public void searchForProduct(String productName) {
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
    }

}
