package src;

import components.RoundRobin.RoundRobinScreen;
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
    @Author: 'abdulrahman  yateem'
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
  }

  private static void priority() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'Eyad Kamil Sughayyir'
    @Components: 'Write your component names here' 
  */
      Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int numProcesses = scanner.nextInt();
        int[] burstTimes = new int[numProcesses];
        int[] priorities = new int[numProcesses];
        String[] processNames = new String[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            processNames[i] = "P" + (i + 1);
            System.out.print("Enter burst time for process " + processNames[i] + ": ");
            burstTimes[i] = scanner.nextInt();
            System.out.print("Enter priority for process " + processNames[i] + ": ");
            priorities[i] = scanner.nextInt();
        }
        priority.rankp(burstTimes, priorities, processNames);
        int[] waitingTimes = new int[numProcesses];
        int[] turnAroundTimes = new int[numProcesses];
        priority.countingT(burstTimes, priorities, processNames, waitingTimes, turnAroundTimes);
        priority.finalprint(burstTimes, priorities, processNames, waitingTimes, turnAroundTimes);
        double averageWaitingTime = priority.AverageWaitingTime(waitingTimes);
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);  
        double averageTurnaroundTime = priority.AverageTurnaroundTime(turnAroundTimes);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
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
