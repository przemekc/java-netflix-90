package pl.yellowduck.netflix90.films;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category {

  @Column
  private String name;
  @Column
  private String description;
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;



  private Category() {
  }

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
  }
}

