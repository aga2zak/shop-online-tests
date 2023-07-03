@Smoke @ShoppingCart
Feature: Main Page
  As an unauthenticated
  Adding a product to the shopping cart

  Background:
    Given Online store address
    When the page finishes loading
    Then I see title, email address of online shop
    And the navigation menu on the online shop page

#  Scenario: Adding a product to the shopping cart
#    When I click on the "Add to Cart" button for a specific product
#    Then the product should be added to the user's shopping cart
#    And the shopping cart icon should update to show the number of items in the cart


