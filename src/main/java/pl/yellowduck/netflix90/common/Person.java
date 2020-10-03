package pl.yellowduck.netflix90.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
//@Table(name = "persons")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter
//@EqualsAndHashCode
@MappedSuperclass
public abstract class Person {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Integer id;
  private String firstname;
  private String lastname;
  protected Gender gender;

  public Person() {
  }

  public Person(String firstname, String lastname, Gender gender) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
  }

  public abstract void introduce();

  @Override
  public String toString() {
    return firstname + " " + lastname;
  }

  public String getFirstname() {
    return firstname.toUpperCase();
  }
}
