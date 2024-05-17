package src;

import components.RoundRobin.RoundRobinScreen;
import components.Sjf.Sjf;
import components.Fcfs.Fcfs;

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
    @Components: 'Fcfs' 
  */
  // to get the number of process 
  Screen.clearScreen();
  int numberOfProcess = Fcfs.NumOfprocess();
  int[] burstT = Fcfs.BurstT(numberOfProcess);
  int[] WaitingT = Fcfs.WaitingT(burstT, numberOfProcess);
  Fcfs.print(burstT, WaitingT, numberOfProcess);
  }

  private static void shortestJob() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'hussain lohmadi'
    @Components: 'shortest job first' 
  */
  Screen.clearScreen();
  Sjf.call();
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
    Screen.clearScreen();
    RoundRobinScreen.showScreen();
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
}
