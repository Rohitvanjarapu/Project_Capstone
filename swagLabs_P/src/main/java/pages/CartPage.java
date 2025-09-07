package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // 🔒 Private locators
    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🌍 Public actions
    public boolean isItemInCart(String itemName) {
        return driver.getPageSource().contains(itemName);
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}

