package pl.yellowduck.netflix90.common;

public enum Gender {

  FEMALE ("female"), MALE("male");
  private String name;

  private Gender (String theGender){
    this.name=theGender;
  }
}
