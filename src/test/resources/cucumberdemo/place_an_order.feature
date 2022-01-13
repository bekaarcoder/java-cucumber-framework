Feature: Place an order

  @skip
  Scenario: Using default payment option
    Given I am a guest customer
    And My billing details are
      | firstname | lastname | country            | address_line1 | city    | state | zip   | email             |
      | john      | doe      | United States (US) | 6300 street   | Chicago | Texas | 60606 | johndoe@gmail.com |
    And I have a product in the cart
    And I am on the checkout page
    When I provide billing details
    And I place an order
    Then Order is placed successfully