package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.resources.Actor;
import pl.yellowduck.netflix90.resources.Director;
import pl.yellowduck.netflix90.resources.Person;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Director tommy = new Director("Tommy", "Wiseau");
    Actor tommyActor = new Actor("Tommy", "Wiseau");
    Actor julitette = new Actor("Juliette", "Danielle");
    Actor greg = new Actor("Greg", "Sestero");

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





