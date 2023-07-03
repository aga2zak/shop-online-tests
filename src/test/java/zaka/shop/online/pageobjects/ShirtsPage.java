package zaka.shop.online.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class ShirtsPage {
  private static final SelenideElement TITLE = $(".woocommerce-products-header__title.page-title");
  private static final List<SelenideElement> ITEMS_NAME = $$(".products > li  h2");

  private ShirtsPage() {}

  public static String getTitleOfShirtPage() {
    return TITLE.shouldBe(Condition.visible, Duration.ofSeconds(3)).getText();
  }

  public static List<String> getItemsName() {
    return ITEMS_NAME.stream().map(SelenideElement::getText).collect(Collectors.toList());
  }
}
