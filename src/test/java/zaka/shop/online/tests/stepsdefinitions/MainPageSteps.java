package zaka.shop.online.tests.stepsdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zaka.shop.online.pageobjects.MainPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageSteps {
  @Given("Online store address")
  public void onlineStoreAddress() {
    Selenide.open(Configuration.baseUrl);
  }

  @When("the page finishes loading")
  public void thePageFinishesLoading() {
    assertThat("Image should be visible!", MainPage.checkIsSliderImageVisible(), is(true));
  }

  @Then("I see title, email address of online shop")
  public void iSeeTitleEmailAddressOfOnlineShop() {
    assertThat(
        "The title 'Generic Shop' isn't visible!", MainPage.getSiteTitle().equals("Generic Shop"));
    assertThat(
        "The email 'skleptestarmy@gmail.com' isn't visible!",
        MainPage.getStoreEmailAddress().equals("skleptestarmy@gmail.com"));
  }

  @And("the navigation menu on the online shop page")
  public void theNavigationMenuOnTheOnlineShopPage() {
    assertThat("Menu should be visible!", MainPage.checkIsMenuVisible(), is(true));
  }
}
