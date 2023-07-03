package zaka.shop.online.entities;

import java.util.ArrayList;
import java.util.List;

public class Category {
  public static final Category SHIRTS = new Category("Shirts");
  public static final Category FEATURED = new Category("Featured");
  public static final Category TRENDS = new Category("Trends");
  public static final Category SCARFS = new Category("Scarfs");
  public static final Category SHOES = new Category("Shoes");
  public static final Category TOP = new Category("Top");
  public static final Category BLOUSE = new Category("Blouse");
  public static final Category JEANS = new Category("Jeans");
  private final String name;

  private Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static List<Category> convertTermForCategory(String term) {
    List<Category> simplifiedCategories;
    switch (term) {
      case "shi", "shir", "shirt", "Shirt", "shirts" -> simplifiedCategories = List.of(SHIRTS);
      case "sho", "shoe", "shoes" -> simplifiedCategories = List.of(SHOES);
      case "sh" -> simplifiedCategories = List.of(SHIRTS, SHOES);
      default -> simplifiedCategories = new ArrayList<>();
    }
    return simplifiedCategories;
  }
}
