package zaka.shop.online.entities;

import java.util.List;
import java.util.stream.Collectors;

public class ItemGenerator {
  private static final Item alaniTShirt =
      new Item(
          List.of(Category.SHIRTS.getName()),
          List.of("pokemon", "print", "shirt", "white"),
          "Alani T-Shirt",
          10.00,
          DescriptionGenerator.createItemDescription().get("Alani T-Shirt"),
          null);
  private static final Item amariShirt =
      new Item(
          List.of(Category.SHIRTS.getName(), Category.SHOES.getName(), Category.TRENDS.getName()),
          List.of("amari", "shirt"),
          "Amari Shirt",
          25.00,
          DescriptionGenerator.createItemDescription().get("Amari Shirt"),
          null);
  private static final Item belkaTShirt =
      new Item(
          List.of(Category.SHIRTS.getName()),
          List.of("print", "shirt", "white"),
          "Belka T-Shirt",
          15.00,
          DescriptionGenerator.createItemDescription().get("Belka T-Shirt"),
          null);
  private static final Item managoShirt =
      new Item(
          List.of(Category.SHIRTS.getName(), Category.SHOES.getName(), Category.FEATURED.getName()),
          List.of("manago", "shirt"),
          "Manago Shirt",
          25.00,
          DescriptionGenerator.createItemDescription().get("Manago Shirt"),
          ReviewGenerator.createItemReviews().get("Manago Shirt"));
  private static final Item marinaStyle =
      new Item(
          List.of(Category.SHIRTS.getName(), Category.TRENDS.getName()),
          List.of("blouse", "shirt", "blue"),
          "Marina Style",
          35.00,
          DescriptionGenerator.createItemDescription().get("Marina Style"),
          null);
  private static final Item visualMTShirt =
      new Item(
          List.of(Category.SHIRTS.getName(), Category.TRENDS.getName()),
          List.of("blouse", "shirt", "blue"),
          "Visual M. T-Shirt",
          35.00,
          DescriptionGenerator.createItemDescription().get("Visual M. T-Shirt"),
          null);
  private static final List<Item> items;

  static {
    items = List.of(alaniTShirt, amariShirt, belkaTShirt, managoShirt, marinaStyle, visualMTShirt);
  }

  public static List<Item> getItemsByCategory(String category) {
    return items.stream()
        .filter(item -> item.category().contains(category))
        .collect(Collectors.toList());
  }
}
