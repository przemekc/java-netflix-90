package pl.yellowduck.netflix90.resources;

import java.math.BigDecimal;
import java.util.Set;

public class VideoCassette {

  private String id;
  private BigDecimal price;
  private String title;
  private Director director;
  private Category category;
  private Set<Actor> actors;

  public VideoCassette(String id, BigDecimal price, String title, Director director, Category category, Set<Actor> actors) {
    this.id = id;
    this.price = price;
    this.title = title;
    this.director = director;
    this.category = category;
    this.actors = actors;
  }

  public void printOut() {
    // print casette data with below pattern
    //    | ID | Title | Category | Price | Director | Actors |
    StringBuilder builder = new StringBuilder();
    builder.append("|")
        .append(this.id)
        .append("|")
        .append(this.title)
        .append("|")
        .append(this.category)
        .append("|")
        .append(this.price)
        .append("|")
        .append(this.director.toString())
        .append("|")
        .append(this.actors)
        .append("|");
    System.out.println(builder.toString());
  }
}
