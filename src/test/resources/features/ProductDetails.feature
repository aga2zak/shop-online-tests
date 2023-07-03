@Smoke @ProductDetails
Feature: Main Page
  As an unauthenticated
  Viewing product details

  Background:
    Given Online store address
    When the page finishes loading
    Then I see title, email address of online shop
    And the navigation menu on the online shop page

#  Scenario: Viewing product details
#    When I click on a specific product's name or image
#    Then the page should navigate to the product details page for that product
#    And the user should see the product's name, price, description, and other relevant information


