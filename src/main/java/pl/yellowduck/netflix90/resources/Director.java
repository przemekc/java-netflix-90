package pl.yellowduck.netflix90.resources;

public class Director extends Person {

  public Director(String firstname, String lastname, Gender gender) {
    super(firstname, lastname, gender);
  }

  @Override
  public void introduce() {
    System.out.println("My name is " + firstname + " " + lastname + ". I am director.");
  }

}
