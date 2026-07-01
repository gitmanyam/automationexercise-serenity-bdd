Feature: Product Checkout

  As a registered customer
  User should be able to place an order successfully

  @Smoke
  Scenario Outline: Validate product checkout

    Given the user logs into the application using email "<email>" and password "<password>"
    And the user searches and adds product "<product>" to the cart
    When the user proceeds to checkout
    Then the user should be navigated to the Checkout page
    When the user reviews the delivery address
    And the user enters payment details
    And the user confirms the order
    Then the order should be placed successfully

    Examples:
      | email           | password | product    |
      | johnny@test.com | Test@123 | Blue Top   |