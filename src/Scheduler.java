package src;

public class Scheduler {
  
  private static void firstCome() {
    System.out.println("First come First Serve under work...");
  }

  private static void shortestJob() {
    System.out.println("Shortest job first under work...");
  }

  private static void priority() {
    System.out.println("priority under work...");
  }

  private static void roundRobin() {
    System.out.println("Round Robin under work...");
  }

  public static void dispatcher(int opCode) {
    switch (opCode) {
      case 1:
        // First Come First Serve function
        firstCome();
        break;
      case 2:
        // Shortest job First function
        shortestJob();
        Screens.preemptiveScreen("Shortest Job First");
        break;
      case 3:
        // Priority
        priority();
        break;
      case 4:
        // Round Robin
        roundRobin();
        break;
      default:
        System.out.println("\n\nSorry There's no operation with this number!!");
        break;
    }
  }
}
