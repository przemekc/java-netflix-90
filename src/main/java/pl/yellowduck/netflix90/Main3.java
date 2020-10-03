package pl.yellowduck.netflix90;

import pl.yellowduck.netflix90.films.Category;

public class Main3 {

  public static void main(String[] args) {
    // detail desiption Enum

    Category category = new Category("Horror", "Scary movie");

    System.out.println("simple print " + category);
    System.out.println("print toString " + category.toString());
    System.out.println("print name " + category.getName());
    //System.out.println("print ordinal " + category.ordinal());



  }
}
