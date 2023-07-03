package zaka.shop.online.entities;

import java.util.List;
import java.util.Map;

public class ReviewGenerator {

  private ReviewGenerator() {}

  public static Map<String, List<Review>> createItemReviews() {
    return Map.of("Manago Shirt", List.of(new Review(5, null)));
  }
}
