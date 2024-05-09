package src;

/*
  Guidelines:
  - Each person will be assign to a different operation
  - If you have a new class you want to add, add it to components
  - Don't modify core package

  
  Read Guide:
    @Author: 'author name'
    @Components: 'Component name';
*/


public class Scheduler {
  
  private static void firstCome() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'abdulrahman '
    @Components: 'Write your component names here' 
  */
    System.out.println("First come First Serve under work...");
  }

  private static void shortestJob() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'hussain lohmadi'
    @Components: 'shortest job first' 
  */
  }

  private static void priority() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'Write your name here'
    @Components: 'Write your component names here' 
  */
    System.out.println("priority under work...");
  }

  private static void roundRobin() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'Ziyad mohammed fallatah'
    @Components: 'RoundRobin' 
  */
    Screens.clearScreen();
    Screens.roundRobinScreen();
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
