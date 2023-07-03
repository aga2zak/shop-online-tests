package zaka.shop.online.tests.stepsdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.hamcrest.MatcherAssert;
import zaka.shop.online.entities.Category;
import zaka.shop.online.entities.Item;
import zaka.shop.online.entities.ItemGenerator;
import zaka.shop.online.pageobjects.MainPage;
import zaka.shop.online.pageobjects.MenuPanel;
import zaka.shop.online.pageobjects.SearchResultsPage;
import zaka.shop.online.pageobjects.ShirtsPage;

public class FeaturedProductsSteps {
  @When("I scroll down to {string} products")
  public void iScrollDownToFeaturedProducts(String category) {
    MainPage.scrollDownToGivenFeaturedCategory(category);
  }

  @Then("I should see at least {int} featured products displayed with their names and prices")
  public void iShouldSeeAtLeastFeaturedProductsDisplayedWithTheirNamesAndPrices(Integer quantity) {
    assertThat(
        "Least "
            + quantity
            + " items should be visible but there are "
            + MainPage.checkQuantityItemInFeaturedCategory()
            + " items!",
        MainPage.checkQuantityItemInFeaturedCategory() >= quantity);
  }

  @When("I select a specific {string} from the navigation menu")
  public void iSelectASpecificFromTheNavigationMenu(String category) {
    MenuPanel.clickOnCategories();
    MenuPanel.clickOnCategory(category);
  }

  @Then("the page of {string} should refresh")
  public void thePageOfShouldRefresh(String category) {
    MatcherAssert.assertThat(
        "The title '" + category + "' isn't visible!",
        ShirtsPage.getTitleOfShirtPage().equalsIgnoreCase(category));
  }

  @And("I should see only the products belonging to the selected {string}")
  public void iShouldSeeOnlyTheProductsBelongingToTheSelected(String category) {
    List<String> itemsByCategory =
        ItemGenerator.getItemsByCategory(category).stream().map(Item::name).toList();

    assertThat(
        "All items with names: "
            + itemsByCategory
            + " from "
            + category
            + " category should be visible!",
        itemsByCategory.containsAll(ShirtsPage.getItemsName()));
  }

  @When("I enter a search {string} in the search bar")
  public void iEnterASearchInTheSearchBar(String term) {
    MainPage.searchForPhrase(term);
  }

  @And("click on the search button")
  public void clickOnTheSearchButton() {
    MainPage.clickOnSearchButton();
  }

  @Then("the search page for {string} should refresh")
  public void theSearchPageForShouldRefresh(String term) {
    MatcherAssert.assertThat(
        "The title 'SEARCH RESULTS FOR: " + term.toUpperCase() + "' isn't visible!",
        SearchResultsPage.getTitleOfSearchResultsPage()
            .equals("SEARCH RESULTS FOR: " + term.toUpperCase()));
  }

  @And("I should see a list of products related to the search {string}")
  public void iShouldSeeAListOfProductsRelatedToTheSearch(String term) {
    List<Category> categories = Category.convertTermForCategory(term);
    List<String> itemsByCategory =
        categories.stream()
            .flatMap(category -> ItemGenerator.getItemsByCategory(category.getName()).stream())
            .map(Item::name)
            .toList();
    assertThat(
        "All items for " + term + " should be visible!",
        itemsByCategory.containsAll(SearchResultsPage.getSearchItemsName()));
  }

  @And("the product names should contain the search {string}")
  public void theProductNamesShouldContainTheSearch(String arg0) {}
}
