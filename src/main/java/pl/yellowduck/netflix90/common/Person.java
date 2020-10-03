package pl.yellowduck.netflix90.common;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
//@Entity
//@Table(name="persons")
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn (name = "type", discriminatorType = DiscriminatorType.CHAR)
//@Generated
@MappedSuperclass
public abstract class Person {


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
}
