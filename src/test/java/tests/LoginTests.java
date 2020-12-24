package tests;

import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTests extends BaseTests {
   @Test
   void clickSignInButtonAndGoLoginForm() {
       HomePage homePage = new HomePage(driver, wait);
       homePage.openPage(); // Open main Page

       BasePage basePage = new BasePage(driver, wait);
       basePage.clickSignIn();

       LoginPage loginPage = new LoginPage(driver, wait);
       loginPage.signInToRegisteredAccount();

       loginPage.signInToNotRegisteredAccount();
   }

   // negative test: signInToNotRegisteredAccount
    @Test
    void clickSignInButtonAndGoToLoginFormNegative() {
       HomePage homePage = new HomePage(driver, wait);
       homePage.openPage(); // Open main Page

       BasePage basePage = new BasePage(driver, wait);
       basePage.clickSignIn();

       LoginPage loginPage = new LoginPage(driver, wait);
       loginPage.signInToNotRegisteredAccount();
       // assertion
    }
}
