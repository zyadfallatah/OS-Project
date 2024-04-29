package src;

import java.util.Scanner;

public class Test {
  
  /* Open the program and tests if it works in your device */

  /*
    sendMsg():
    - Uses the java class Scanner to read input from the reader and return what the user wrote
    - App.java is responsible of calling the method
  */
  public static String sendMsg() {
    try (Scanner scanner = new Scanner(System.in)) {
      return scanner.nextLine();
    }
  }
}
