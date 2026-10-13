Feature: Order Management on SauceDemo

  Background:
    Given I open SauceDemo

  @test
  Scenario: Place a single product order successfully
    When I login with username "standard_user" and password "secret_sauce"
    And I add product "Sauce Labs Backpack" to the cart
    And I proceed to checkout with first name "Johan" last name "Lee" postal code "411001"
    Then I should see order confirmation message

  @outline
  Scenario Outline: Place order for multiple products
    When I login with username "standard_user" and password "secret_sauce"
    And I add product "<product>" to the cart
    And I proceed to checkout with first name "Johan" last name "Lee" postal code "411001"
    Then I should see order confirmation message

    Examples:
      | product                    |
      | Sauce Labs Bike Light      |
      | Sauce Labs Bolt T-Shirt    |
