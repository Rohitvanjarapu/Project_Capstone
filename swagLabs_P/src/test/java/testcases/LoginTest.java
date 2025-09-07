package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        System.out.println("✅ Valid login passed");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
        System.out.println("✅ Invalid login passed");
    }

    @Test
    public void testAnotherUserLogin() {
        loginPage.enterUsername("problem_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        System.out.println("✅ Another valid user login passed");
    }

    @Test
    public void testCorrectUsernameWrongPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
        System.out.println("✅ Correct username + wrong password tested");
    }

    @Test
    public void testWrongUsernameCorrectPassword() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
        System.out.println("✅ Wrong username + correct password tested");
    }
    
    @Test
    public void testLockedOutUserLogin() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out"));
        System.out.println("✅ Locked out user login test passed");
    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
