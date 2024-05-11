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
    @Author: 'abdulrahman '
    @Components: 'Write your component names here' 
  */
 // to get the numbr of proces 
  public static int NumOfprocess(){ 
    Scanner input = new Scanner(System.in);//Create an object to get  input from the user
    System.out.print("Enter the number of processes: ");
    return input.nextInt();
 }

// to get Burst Tims 
public static int[] BurstT(int number) {
    Scanner input = new Scanner(System.in);//Create an object to get  input from the user
    //we need to assign array to get burst time for the each process 
    int burstt[] = new int[number];
    for(int i = 0; i < number; i++){ //get burst time for  each process 
        System.out.print("Enter the burst time for p" + (i+1) + ": ");
        burstt[i] = input.nextInt();
     }
    return burstt;
   }

/// to get Waiting Times for  each process
public static int[] WaitingT(int[] burst, int number){
    //now we need to assign array to get waiting  time for the each process 
    int waiit[] = new int[number];
    // process one soulde  be 0... 
    waiit[0] = 0;// first process waiting  time 
    int waitt = 0;// assign the veriable to count waiting  time
    for(int i = 1; i < number; i++) {
        waitt += burst[i-1];
        waiit[i] = waitt;
     }
    return waiit;
   }
/// to get the average Turnaround Time 
public static double AvgTurnaroundT(int[] turnaroundTime, int number) {
    float sumtat = 0;///assign the veriable to count total Turnaround Time
    for(int i = 0; i < number; i++) {
        sumtat += turnaroundTime[i];//
     }
    return sumtat / number;
  }
/// to get the average waiting time
public static double AvgWaitingT(int[] wait, int number){
    float sumwt = 0; ///assign the veriable to count total Waiting Time
    //Use a loop to calculate Turnaround Time
    for(int i = 0; i < number; i++) {
        sumwt += wait[i];
      }
    return sumwt / number;//to get the average waiting time
     }
//To print the final results
public static void print(int[] burst, int[] waiit, int[] turnaroundTime, int number){
    System.out.println("Process\t\tBurst Time\tWaiting Time\tTurnaround Time");
    for(int i = 0; i < number; i++) {
        turnaroundTime[i] = waiit[i] + burst[i];//To calculate turnaround Time
        System.out.println("P" + (i+1) + "\t\t" + burst[i] + "\t\t" + waiit[i] + "\t\t" + turnaroundTime[i]);
      }
    System.out.println("Average TurnaroundTime time is:\t\t\t" + AvgTurnaroundT(turnaroundTime, number));
    System.out.println("Average Waiting time is:\t\t\t" + AvgWaitingT(waiit, number));
             
     }  
    System.out.println("First come First Serve under work...");
  }

  private static void shortestJob() {
  /* 
    **Don't Delete This just replace what's between ' '**
    @Author: 'hussain lohmadi'
    @Components: 'shortest job first' 
  */

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
