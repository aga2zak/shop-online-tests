package zaka.shop.online.entities;

import java.util.List;

public record Item(
    List<String> category,
    List<String> tags,
    String name,
    Double price,
    String description,
    List<Review> reviews) {}
