// src/test/java/com/swag/steps/SortingSteps.java
package com.swag.steps;

import com.swag.pages.InventoryPage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingSteps {
    private InventoryPage inventoryPage;

    @When("I sort products by {string}")
    public void i_sort_products_by(String visibleText) {
        inventoryPage = new InventoryPage();
        inventoryPage.sortBy(visibleText);
    }

    @Then("products should be displayed in alphabetical order A to Z")
    public void products_should_be_displayed_in_alphabetical_order_a_to_z() {
        List<String> actual = inventoryPage.getAllProductNames();
        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected, String.CASE_INSENSITIVE_ORDER);
        Assertions.assertEquals(expected, actual, "Products are not sorted A→Z.");
    }

    @Then("products should be displayed in alphabetical order Z to A")
    public void products_should_be_displayed_in_alphabetical_order_z_to_a() {
        List<String> actual = inventoryPage.getAllProductNames();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(expected);
        Assertions.assertEquals(expected, actual, "Products are not sorted Z→A.");
    }

    @Then("products should be displayed from lowest price to highest price")
    public void products_should_be_displayed_from_lowest_price_to_highest_price() {
        List<Double> actual = inventoryPage.getAllProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        Assertions.assertEquals(expected, actual, "Prices are not sorted low→high.");
    }

    @Then("products should be displayed from highest price to lowest price")
    public void products_should_be_displayed_from_highest_price_to_lowest_price() {
        List<Double> actual = inventoryPage.getAllProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        Assertions.assertEquals(expected, actual, "Prices are not sorted high→low.");
    }
}
