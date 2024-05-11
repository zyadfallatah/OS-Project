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
   int [] arrival;
   int [] waiting;
   int Turnaround = 0;
   System.out.println("please enter how many procceses do you have: ");
   int procces = sjf.nextInt();
   burst = new int [procces];
   turnarray = new int [procces];
   arrival = new int [procces];
   waiting = new int [procces-1];
   int arrivaltotal = 0;
   System.out.println("please enter the burst time");

   for (int i = 0; i < burst.length; i++){
    burst[i] = sjf.nextInt();
    arrival[i] = i;
    arrivaltotal ++;
   }
   System.out.println("procces    arrivel time");
   for (int i = 0; i < burst.length; i++){
    System.out.println(burst[i] + "                " + arrival[i]);
   }
   for (int i = 0 ; i < burst.length ; i++){
    Turnaround = burst[i] + Turnaround;
    turnarray[i] = Turnaround;
    //System.out.println(Turnaround);
   }
   Arrays.sort(burst);
   for (int i = 0; i < burst.length; i++){
    System.out.print("["+  burst[i] +"]" );
    System.out.print("");
   }
   System.out.println("please enter what type of SJF do you want to schedul");
   int choose = sjf.nextInt();
   switch (choose) {

  //non preemtive

  case 1:{
  /*turnaround time*/
   int turntemp2 = 0;
   for (int i = 0 ; i < burst.length ; i++){
    turnarray[i] = turnarray[i] - arrival[i];
   }
   for (int i = 0 ; i < burst.length;i++){
   turntemp2 = turnarray [i] + turntemp2;
   //System.out.println(turntemp2);
   }
   Turnaround = turntemp2/arrivaltotal;
   System.out.println("the turnaround is = " + Turnaround);
  /*waitnig time */
  int waitngForNon = 0;
  for (int i = 0 ; i < burst.length - 1 ; i++){
    waitngForNon = burst[i] + waitngForNon;
    waiting[i] = waitngForNon;
    //System.out.println(Turnaround);
   }
   for (int i = 0 ; i < burst.length - 1 ; i++){
    waiting[i] = waiting[i] - arrival[i];
   }
   waitngForNon = waitngForNon/arrivaltotal;
   System.out.println("the waiting is = " + waitngForNon);
}
      
    break;
    
  //preemtive

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
