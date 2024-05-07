package src;
/*
  This class is resposible of displaying and printing at terminal
  
  Refrence: 
  clear terminal: https://www.javatpoint.com/how-to-clear-screen-in-java

*/

class ListItem {
  private int generator = 1;

  public static ListItem createMenu() {
    return new ListItem();
  }

  public void addItem(String itemStr) {
    System.out.println(generator + "."+ itemStr);
    generator++;
  }
}


public class Screens {
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }

  public static void preemptiveScreen(String source) {
    System.out.println("============\n"+ source +"\n============");
    System.out.println("Choose how to execute " + source + ": ");

    ListItem list = ListItem.createMenu();
    list.addItem("Preemptive");
    list.addItem("non-Preemptive");
  }

  public static void mainScreen() {
    System.out.println("============\nCPU Scheduler\n============");
    System.out.println("Please Choose your algorithm: ");

    System.out.println("1.First Come First Serve");
    System.out.println("2.Shortest Job First");
    System.out.println("3.Priority");
    System.out.println("4.Round Robin");
  }
}
