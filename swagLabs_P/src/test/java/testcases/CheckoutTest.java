package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.DriverFactory;

import java.time.Duration;

public class CheckoutTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        System.out.println("✅ Logged in");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000); // pause for viewing
        DriverFactory.quitDriver();
    }
}
