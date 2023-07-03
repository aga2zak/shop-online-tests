package zaka.shop.online.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  private static final SelenideElement STORE_NAME = $(".site-title");
  private static final SelenideElement STORE_EMAIL_ADDRESS =
      $(byXpath("//a[normalize-space()='skleptestarmy@gmail.com']"));
  private static final SelenideElement MENU = $("#desktop-menu");
  private static final SelenideElement SEARCH_BAR = $("#search-field-top-bar");
  private static final SelenideElement SEARCH_BUTTON = $("#search-top-bar-submit");
  private static final SelenideElement SLIDER_IMAGE =
      $(
          "div[class='owl-item active'] img[class='attachment-tyche-slider-image size-tyche-slider-image']");

  private MainPage() {}

  public static String getSiteTitle() {
    return STORE_NAME.getText();
  }

  public static String getStoreEmailAddress() {
    return STORE_EMAIL_ADDRESS.getText();
  }

  public static Boolean checkIsMenuVisible() {
    return MENU.exists();
  }

  public static Boolean checkIsSliderImageVisible() {
    return SLIDER_IMAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
  }

  public static void scrollDownToGivenFeaturedCategory(String category) {
    actions().scrollToElement($(byXpath("//span[normalize-space()='" + category + "']"))).perform();
  }

  public static Integer checkQuantityItemInFeaturedCategory() {
    return $$(byXpath("//div[@id='tyche_products-6']//div[@class='owl-item active']")).size();
  }

  public static void searchForPhrase(String phrase) {
    SEARCH_BAR.click();
    SEARCH_BAR.setValue(phrase);
  }

  public static void clickOnSearchButton() {
    SEARCH_BUTTON.click();
  }
}
