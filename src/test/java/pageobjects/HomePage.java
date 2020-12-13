package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

        public HomePage(WebDriver driverIn) {
            this.driver = driverIn;
        }

        public void openPage() {
            driver.get(BASE_URL + "index.php");
        }

}
