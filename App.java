import java.util.Scanner;
import src.Screens;
import src.Scheduler;
/*
  Refrence: 
  clear terminal: https://www.javatpoint.com/how-to-clear-screen-in-java
 */

public class App {
  public static void main(String[] args) {

    /* Don't Write Your Code Here (Below) */
    char exit = 'n';
    int opCode = -1;
    String tempStr;
    Scanner scanner = new Scanner(System.in);

    do {
      Screens.clearScreen();

      Screens.mainScreen();

      System.out.println("\nChoose your operation: ");
      opCode = scanner.nextInt();
      
      Scheduler.dispatcher(opCode);

      System.out.println("\n\nDo you want to continue?: (y/n)");
      tempStr = scanner.next().toLowerCase();
      exit = tempStr.charAt(0);
    } while (exit != 'n');

    scanner.close();
  }
}