Feature: WebDriver setup validation

  Scenario: Open SauceDemo homepage
    Given I launch the browser "chrome"
    When I open the SauceDemo homepage
    Then the page title should contain "Swag Labs"