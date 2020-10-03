package pl.yellowduck.netflix90.films;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

import javax.persistence.*;
import java.util.Set;

@Entity
//@DiscriminatorValue("D")
@Table(name = "directors")
//@EqualsAndHashCode
public class Director extends Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  // jezeli potrzeba a na razie nie ma potrzeby mapownia dwustronnego
//  @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
//  private Set<VideoCassette> films;

  public Director() {
  }

  public Director(String firstname, String lastname, Gender gender) {
    super(firstname, lastname, gender);
  }

  @Override
  public void introduce() {
    System.out.println("My name is " + getFirstname() + " " + getLastname() + ". I am director.");
  }


}
