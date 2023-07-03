package zaka.shop.online.pageobjects;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage {
  private static final SelenideElement TITLE = $(".page-title");
  private static final List<SelenideElement> RESULTS_ITEMS_NAME =
      $$(".site-main .entry-header .title");

  private SearchResultsPage() {}

  public static String getTitleOfSearchResultsPage() {
    return TITLE.shouldBe(Condition.visible, Duration.ofSeconds(3)).getText();
  }

  public static List<String> getSearchItemsName() {
    return RESULTS_ITEMS_NAME.stream().map(SelenideElement::getText).collect(Collectors.toList());
  }
}
