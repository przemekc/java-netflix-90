package pl.yellowduck.netflix90.films;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
public class VideoCassette {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private BigDecimal price;
  private String title;
  @ManyToOne(fetch = FetchType.LAZY)
  private Director director;
  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;
  @OneToMany(fetch = FetchType.LAZY)
  private Set<Actor> actors;

  public VideoCassette() {
  }


  public VideoCassette( BigDecimal price, String title, Director director, Category category, Set<Actor> actors) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    VideoCassette that = (VideoCassette) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
