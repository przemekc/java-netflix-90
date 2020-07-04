package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.resources.Actor;
import pl.yellowduck.netflix90.resources.Director;
import pl.yellowduck.netflix90.resources.Gender;
import pl.yellowduck.netflix90.resources.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
      person.introduce();
    }

    // or
//    for (Person person : persons) {
//      person.introduce();
//    }
  }
}





