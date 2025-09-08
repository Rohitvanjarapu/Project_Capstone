// src/test/java/com/swag/pages/InventoryPage.java
package com.swag.pages;

import com.swag.core.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private final WebDriver driver;

    private final By inventoryContainer = By.id("inventory_container");
    private final By productNames = By.cssSelector(".inventory_item_name");
    private final By productPrices = By.cssSelector(".inventory_item_price");
    private final By sortSelect = By.cssSelector("select[data-test='product_sort_container']");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public InventoryPage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("/inventory.html") &&
               !driver.findElements(inventoryContainer).isEmpty();
    }

    public void sortBy(String visibleText) {
        new Select(driver.findElement(sortSelect)).selectByVisibleText(visibleText);
    }

    public List<String> getAllProductNames() {
        List<String> list = new ArrayList<>();
        driver.findElements(productNames).forEach(el -> list.add(el.getText().trim()));
        return list;
    }

    public List<Double> getAllProductPrices() {
        List<Double> list = new ArrayList<>();
        driver.findElements(productPrices).forEach(el -> {
            String txt = el.getText().replace("$", "").trim();
            list.add(Double.parseDouble(txt));
        });
        return list;
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    // Uses Sauce demo data-test ids (robust and stable)
    private String toDataTestId(String productName, boolean add) {
        // e.g., "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack"
        String slug = productName.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("-+", "-");
        return (add ? "add-to-cart-" : "remove-") + slug;
    }

    public void addToCart(String productName) {
        By addBtn = By.cssSelector(String.format("[data-test='%s']", toDataTestId(productName, true)));
        driver.findElement(addBtn).click();
    }

    public void removeFromCartFromInventory(String productName) {
        By removeBtn = By.cssSelector(String.format("[data-test='%s']", toDataTestId(productName, false)));
        driver.findElement(removeBtn).click();
    }
}
