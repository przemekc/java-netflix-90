package pl.yellowduck.netflix90.resources;

public abstract class Person {

  protected String firstname;
  protected String lastname;

  public Person(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public abstract void introduce();
}
