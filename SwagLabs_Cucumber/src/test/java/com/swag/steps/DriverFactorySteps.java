// src/test/java/com/swag/steps/DriverFactorySteps.java
package com.swag.steps;

import com.swag.core.DriverFactory;
import com.swag.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class DriverFactorySteps {
    private WebDriver driver;

    @Given("I launch the browser {string}")
    public void i_launch_the_browser(String browser) {
        DriverFactory.launchBrowser(browser);
        driver = DriverFactory.getDriver();
    }

    @When("I open the SauceDemo homepage")
    public void i_open_the_sauce_demo_homepage() {
        new LoginPage().open();
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expected) {
        Assertions.assertTrue(driver.getTitle().contains(expected),
                "Title did not contain expected text. Actual: " + driver.getTitle());
    }
}
