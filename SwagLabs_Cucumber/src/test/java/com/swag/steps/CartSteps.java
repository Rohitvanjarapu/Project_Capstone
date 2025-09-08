// src/test/java/com/swag/steps/CartSteps.java
package com.swag.steps;

import com.swag.pages.CartPage;
import com.swag.pages.InventoryPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class CartSteps {
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String product) {
        inventoryPage = new InventoryPage();
        inventoryPage.addToCart(product);
    }

    @When("I remove {string} from the cart")
    public void i_remove_from_the_cart(String product) {
        // You can remove from inventory list or open cart and remove
        cartPage = new CartPage();
        try {
            // try to remove from inventory (if still on inventory)
            inventoryPage = new InventoryPage();
            inventoryPage.removeFromCartFromInventory(product);
        } catch (Exception e) {
            // fallback: remove from cart page
            cartPage.removeFromCart(product);
        }
    }

    @When("I navigate to the cart")
    public void i_navigate_to_the_cart() {
        inventoryPage = new InventoryPage();
        inventoryPage.openCart();
        cartPage = new CartPage();
    }

    @Then("I should see {string} in the cart")
    public void i_should_see_in_the_cart(String product) {
        Assertions.assertTrue(cartPage.isProductPresent(product),
                "Expected product not found in cart: " + product);
    }

    @Then("I should not see {string} in the cart")
    public void i_should_not_see_in_the_cart(String product) {
        Assertions.assertFalse(cartPage.isProductPresent(product),
                "Unexpectedly found product in cart: " + product);
    }
}
