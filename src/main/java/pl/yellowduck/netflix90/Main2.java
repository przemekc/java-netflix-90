package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.resources.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static pl.yellowduck.netflix90.resources.Gender.FEMALE;
import static pl.yellowduck.netflix90.resources.Gender.MALE;

public class Main2 {

  public static void main(String[] args) {
    Director tommy = new Director("Tommy", "Wiseau", MALE);
    Actor tommyActor = new Actor("Tommy", "Wiseau", MALE);
    Actor julitette = new Actor("Juliette", "Danielle", FEMALE);
    Actor greg = new Actor("Greg", "Sestero", MALE);

    Set<Actor> actors = new HashSet<>();
    actors.add(tommyActor);
    actors.add(julitette);
    actors.add(greg);

    VideoCassete theRoom = new VideoCassete(
        "VID001",
        BigDecimal.valueOf(20),
        "The Room",
        tommy,
        Category.DRAMA,
        actors);

    theRoom.printOut();
  }
}





