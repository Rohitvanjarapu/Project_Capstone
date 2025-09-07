Feature: Sorting products on SauceDemo

  Background:
    Given I am logged in as "standard_user" with password "secret_sauce"

  Scenario: Sort products A to Z
    When I sort products by "Name (A to Z)"
    Then products should be displayed in alphabetical order A to Z

  Scenario: Sort products Z to A
    When I sort products by "Name (Z to A)"
    Then products should be displayed in alphabetical order Z to A

  Scenario: Sort products by price low to high
    When I sort products by "Price (low to high)"
    Then products should be displayed from lowest price to highest price

  Scenario: Sort products by price high to low
    When I sort products by "Price (high to low)"
    Then products should be displayed from highest price to lowest price