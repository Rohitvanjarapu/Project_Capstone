package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // 🔒 Private locators
    private By cartIcon = By.className("shopping_cart_link");

    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpack = By.id("remove-sauce-labs-backpack");

    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBikeLight = By.id("remove-sauce-labs-bike-light");

    private By addBoltShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By removeBoltShirt = By.id("remove-sauce-labs-bolt-t-shirt");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // 🌍 Public actions
    public void addBackpack() { driver.findElement(addBackpack).click(); }
    public void removeBackpack() { driver.findElement(removeBackpack).click(); }

    public void addBikeLight() { driver.findElement(addBikeLight).click(); }
    public void removeBikeLight() { driver.findElement(removeBikeLight).click(); }

    public void addBoltShirt() { driver.findElement(addBoltShirt).click(); }
    public void removeBoltShirt() { driver.findElement(removeBoltShirt).click(); }

    public void clickCart() {
        driver.findElement(cartIcon).click();
        System.out.println(" Navigated to Cart: " + driver.getCurrentUrl());
    }
}
