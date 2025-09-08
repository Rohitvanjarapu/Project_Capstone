Feature: Login functionality on SauceDemo

  Scenario: Valid login with standard user
    Given I am on the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the inventory page

  Scenario: Invalid login with wrong username and password
    Given I am on the SauceDemo login page
    When I login with username "wrong_user" and password "wrong_pass"
    Then I should see an error message "Username and password do not match"

  Scenario: Valid login with problem_user
    Given I am on the SauceDemo login page
    When I login with username "problem_user" and password "secret_sauce"
    Then I should be redirected to the inventory page

  Scenario: Login with correct username and wrong password
    Given I am on the SauceDemo login page
    When I login with username "standard_user" and password "wrong_pass"
    Then I should see an error message "Username and password do not match"

  Scenario: Login with wrong username and correct password
    Given I am on the SauceDemo login page
    When I login with username "wrong_user" and password "secret_sauce"
    Then I should see an error message "Username and password do not match"

  Scenario: Login with locked_out_user
    Given I am on the SauceDemo login page
    When I login with username "locked_out_user" and password "secret_sauce"
    Then I should see an error message "Sorry, this user has been locked out"