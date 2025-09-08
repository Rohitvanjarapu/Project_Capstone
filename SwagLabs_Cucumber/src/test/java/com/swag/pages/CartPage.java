// src/test/java/com/swag/pages/CartPage.java
package com.swag.pages;

import com.swag.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;

    private final By cartItemsNames = By.cssSelector(".cart_item .inventory_item_name");

    public CartPage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean isProductPresent(String productName) {
        return driver.findElements(cartItemsNames)
                .stream()
                .anyMatch(el -> el.getText().trim().equalsIgnoreCase(productName));
    }

    public void removeFromCart(String productName) {
        String slug = productName.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("-+", "-");
        By removeBtn = By.cssSelector(String.format("[data-test='remove-%s']", slug));
        driver.findElement(removeBtn).click();
    }
}
