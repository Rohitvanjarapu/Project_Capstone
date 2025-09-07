// src/test/java/com/swag/pages/LoginPage.java
package com.swag.pages;

import com.swag.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By error = By.cssSelector("[data-test='error']");

    public static final String BASE_URL = "https://www.saucedemo.com/";

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String pass) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getErrorText() {
        return driver.findElement(error).getText().trim();
    }
}
