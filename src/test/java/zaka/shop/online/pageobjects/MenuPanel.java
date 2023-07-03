package zaka.shop.online.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MenuPanel {

  private static final SelenideElement CATEGORIES = $("a[title='Catergries']");

  private MenuPanel() {}

  public static void clickOnCategories() {
    actions().moveToElement(CATEGORIES).perform();
  }

  public static void clickOnCategory(String category) {
    SelenideElement manuItem = $("a[title='" + category + "']");
    actions().moveToElement(manuItem.shouldBe(Condition.exist, Duration.ofSeconds(1))).perform();
    manuItem.shouldBe(Condition.enabled).click();
  }
}
