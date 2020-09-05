package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Director tommy = new Director("Tommy", "Wiseau", Gender.MALE);
    Actor tommyActor = new Actor("Tommy", "Wiseau", Gender.MALE);
    Actor julitette = new Actor("Juliette", "Danielle", Gender.FEMALE);
    Actor greg = new Actor("Greg", "Sestero", Gender.MALE);

    List<Person> persons = new ArrayList<>();
    persons.add(tommy);
    persons.add(tommyActor);
    persons.add(julitette);
    persons.add(greg);

    for (int i = 0; i < persons.size() - 1; i++) {
      Person person = persons.get(i);
      System.out.println(person.toString());
    }

    // or
//    for (Person person : persons) {
//      person.introduce();
//    }
  }
}





