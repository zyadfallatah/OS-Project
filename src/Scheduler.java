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

import java.util.Scanner;
import java.util.Arrays;


public class Scheduler {
  
  private static void firstCome() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'Write your name here'
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
   Scanner sjf = new Scanner(System.in);
   int [] burst;
   int [] turnarray;
   int Turnaround = 0;
   System.out.println("please enter how many procceses do ypu have: ");
   int procces = sjf.nextInt();
   burst = new int [procces];
   turnarray = new int [procces];
   int arrival = 0;
   System.out.println("please enter the burst time");

   for (int i = 0; i < burst.length; i++){
    burst[i] = sjf.nextInt();
    arrival ++;
   }
   Arrays.sort(burst);
   for (int i = 0; i < burst.length; i++){
    System.out.print("["+  burst[i] +"]" );
    System.out.println("");
   }
   int choose = sjf.nextInt();
   switch (choose) {

  case 1:{
  /*turnaround time*/
   for (int i = 0 ; i < burst.length ; i++){
    Turnaround = burst[i] + Turnaround;
    turnarray[i] = Turnaround;
    System.out.println(Turnaround);
   }
   int turntemp2 = 0;
   for (int i = 0 ; i < burst.length ; i++){
    turntemp2 = turnarray[i] + turntemp2;
   }
   Turnaround = turntemp2/procces;
   System.out.println("the terunaround is = " + Turnaround);
  /*waitnig time */
}
      
    break;
   
    case 2:{

    }
      break;
   }
   System.out.println("Shortest job first under work...");
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
    @Author: 'Write your name here'
    @Components: 'Write your component names here' 
  */
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
