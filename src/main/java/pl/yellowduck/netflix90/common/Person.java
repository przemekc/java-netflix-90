package pl.yellowduck.netflix90.resources;

import lombok.Getter;
import lombok.ToString;

@Getter
public abstract class Person {

  private String firstname;
  private String lastname;
  protected final Gender gender;

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
