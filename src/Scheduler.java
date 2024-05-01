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

  public static void printScreen() {
    System.out.println("============\nCPU Scheduler\n============");
    System.out.println("Please Choose your algorithm: ");

    System.out.println("1.First Come First Serve");
    System.out.println("2.Shortest Job First");
    System.out.println("3.Priority");
    System.out.println("4.Round Robin");
  }
}
