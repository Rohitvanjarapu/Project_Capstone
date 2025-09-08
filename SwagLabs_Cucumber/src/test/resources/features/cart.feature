Feature: Cart functionality on SauceDemo

  Background:
    Given I am logged in as "standard_user" with password "secret_sauce"

  Scenario: Add single item to cart
    When I add "Sauce Labs Backpack" to the cart
    And I navigate to the cart
    Then I should see "Sauce Labs Backpack" in the cart

  Scenario: Remove single item from cart
    When I add "Sauce Labs Backpack" to the cart
    And I remove "Sauce Labs Backpack" from the cart
    And I navigate to the cart
    Then I should not see "Sauce Labs Backpack" in the cart

  Scenario: Add multiple items to cart
    When I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bike Light" to the cart
    And I add "Sauce Labs Bolt T-Shirt" to the cart
    And I navigate to the cart
    Then I should see "Sauce Labs Backpack" in the cart
    And I should see "Sauce Labs Bike Light" in the cart
    And I should see "Sauce Labs Bolt T-Shirt" in the cart