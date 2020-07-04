package pl.yellowduck.netflix90;

import java.util.IllegalFormatException;

// unchecked exception (RuntimeException)
public class Main5 {

  // error handled with try catch
  public static void main(String[] args) {
    try {
      test();
    } catch (IllegalAccessError | IllegalFormatException e) {
      System.out.println("error handler !!! " + e.getMessage());
    } catch (IllegalStateException e) {
      System.out.println("error handler ### " + e.getMessage());
    } finally {
      System.out.println("Finally always call");
    }
  }

  private static void test() throws IllegalStateException {
//    if(true) {
//      throw new IllegalStateException("Żródłowy problem. Błedny stan");
//    }
    System.out.println("successfull call test method");
  }
}
