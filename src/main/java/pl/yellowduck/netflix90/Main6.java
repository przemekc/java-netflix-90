package pl.yellowduck.netflix90;

import java.sql.SQLException;
import java.util.IllegalFormatException;

// checked exceptions (Exception)
public class Main6 {

  // error handled with try catch
  public static void main(String[] args) {
    try {
      test();
    } catch (IllegalAccessError | IllegalFormatException e) {
      System.out.println("error handler !!! " + e.getMessage());
    } catch (SQLException e) {
      System.out.println("error handler ### " + e.getMessage());
    } finally {
      System.out.println("Finally always call");
    }
  }

  private static void test() throws SQLException {
    if(true) {
      throw new SQLException("Żródłowy problem. Błąd wywołania zapytania");
    }
    System.out.println("successfull call test method");
  }
}
