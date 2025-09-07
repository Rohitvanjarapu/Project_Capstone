
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import utils.DriverFactory;

public class CartTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        // login before each test
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        System.out.println("Logged in successfully");
    }

    @Test
    public void testAddSingleItem() {
        homePage.addBackpack();
        homePage.clickCart();
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));
        System.out.println("Add single item test passed");
    }

    @Test
    public void testRemoveSingleItem() {
        homePage.addBackpack();
        homePage.removeBackpack();
        homePage.clickCart();
        Assert.assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
        System.out.println("Remove single item test passed");
    }

    @Test
    public void testAddMultipleItems() {
        homePage.addBackpack();
        homePage.addBikeLight();
        homePage.addBoltShirt();
        homePage.clickCart();

        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Bike Light"));
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Bolt T-Shirt"));
        System.out.println("Add multiple items test passed");
    }
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
