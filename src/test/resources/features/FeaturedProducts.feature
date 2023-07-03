@Smoke @FeaturedProducts
Feature: Main Page
  As an unauthenticated
  Displaying featured products
  Filtering products by category
  Searching for a product

  Background:
    Given Online store address
    When the page finishes loading
    Then I see title, email address of online shop
    And the navigation menu on the online shop page

  Scenario: Displaying featured products
    When I scroll down to "FEATURED" products
    Then  I should see at least 3 featured products displayed with their names and prices

  Scenario Outline: Filtering products by category
    When I select a specific "<category>" from the navigation menu
    Then the page of "<category>" should refresh
    And I should see only the products belonging to the selected "<category>"
    Examples:
      | category |
      | Shirts   |

  Scenario Outline: Searching for a product
    When I enter a search "<term>" in the search bar
    And click on the search button
    Then the search page for "<term>" should refresh
    And I should see a list of products related to the search "<term>"
    And the product names should contain the search "<term>"
    Examples:
      | term  |
      | Shirt |




