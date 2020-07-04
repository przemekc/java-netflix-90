package pl.yellowduck.netflix90.resources;

public class Actor extends Person {

  public Actor(String firstname, String lastname) {
    super(firstname, lastname);
  }

  @Override
  public void introduce() {
    System.out.println("My name is " + firstname + " " + lastname + ". I am actor.");
  }
}
