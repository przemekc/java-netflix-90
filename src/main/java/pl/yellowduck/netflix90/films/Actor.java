package pl.yellowduck.netflix90.films;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table (name = "actor")
public class Actor  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column (name = "last_name")
  private String lastname;
  @Column (name = "first_name")
  private String firstname;
  @Column (name = "gender")
  private Gender gender;
  //List<VideoCassette> videoCassettes = new ArrayList<>();

  private Actor() {
  }

  public Actor(String firstname, String lastname, Gender gender) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
  }

//  @Override
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
