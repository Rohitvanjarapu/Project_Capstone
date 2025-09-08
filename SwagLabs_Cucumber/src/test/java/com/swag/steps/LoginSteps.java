// src/test/java/com/swag/steps/LoginSteps.java
package com.swag.steps;

import com.swag.core.DriverFactory;
import com.swag.pages.InventoryPage;
import com.swag.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_login_page() {
        DriverFactory.launchBrowser("chrome"); // default for scenarios that don't explicitly launch
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_inventory_page() {
        Assertions.assertTrue(inventoryPage.isLoaded(), "Inventory page did not load.");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expected) {
        String actual = loginPage.getErrorText();
        // SauceDemo messages can include prefix like "Epic sadface: ...", so contains check is safer
        Assertions.assertTrue(actual.contains(expected), 
                "Expected error to contain: " + expected + " but was: " + actual);
    }

    // Background support for other features:
    @Given("I am logged in as {string} with password {string}")
    public void i_am_logged_in_as_with_password(String user, String pass) {
        DriverFactory.launchBrowser("chrome");
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        loginPage.open();
        loginPage.login(user, pass);
        Assertions.assertTrue(inventoryPage.isLoaded(), "Failed to login and reach inventory.");
    }
}
