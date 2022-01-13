Feature: Add to cart

  Scenario Outline: Add one quantity from store
    Given I am on store page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name |
      | Blue Shoes   |
      | Redo Tshirt  |