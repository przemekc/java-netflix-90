package pl.yellowduck.netflix90.films;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

@Getter
public class Actor extends Person {

  @JsonCreator
  public Actor(@JsonProperty("firstname") String firstname,
               @JsonProperty("lastname") String lastname,
               @JsonProperty("gender") Gender gender) {
    super(firstname, lastname, gender);
  }

  @Override
  public void introduce() {
    // like this
//    if(Gender.MALE.equals(gender)) {
//      System.out.println("My name is " + firstname + " " + lastname + ". I am actor.");
//    } else {
//      System.out.println("My name is " + firstname + " " + lastname + ". I am actress.");
//    }

    switch (this.gender) {
      case MALE:
        System.out.println("My name is " + getFirstname() + " " + getLastname() + ". I am actor.");
        break;
      case FEMALE:
        System.out.println("My name is " + getFirstname() + " " + getLastname() + ". I am actress.");
        break;
    }
  }

  @Override
  public String toString() {
    return "Actor: " + getFirstname() + " " + getLastname();
  }
}
