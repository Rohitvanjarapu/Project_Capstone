package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class DriverFactoryTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver("chrome"); // Start Chrome
    }

    @Test
    public void openSauceDemo() {
        System.out.println("Title is: " + driver.getTitle()); // Just print title
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver(); // Close browser
    }
}