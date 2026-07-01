Feature: Product Search and Add to Cart

  As a customer
  User should be able to search for a product and add it to the cart

  @Smoke
  Scenario Outline: Validate product search and add to cart

    Given the user navigates to Homepage
    When the user clicks and navigates to the Products page
    Then the user should be navigated to the Products page
    When the user searches for the product "<product>"
    Then the searched product should be displayed
    When the user adds the searched product to the cart
    And the user navigates to the Cart page
    Then the selected product "<product>" should be available in the cart

    Examples:
      | product    |
      | Men Tshirt |