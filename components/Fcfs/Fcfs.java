package components.Fcfs;

import java.util.Scanner;

public class Fcfs {
  public static int NumOfprocess(){ 
    Scanner input = new Scanner(System.in);//Create an object to get  input from the user
    System.out.print("Enter the number of processes: ");
    return input.nextInt();
  }

// to get Burst Times 
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
  private static double AvgTurnaroundT(int[] turnaroundTime, int number) {
    float sumtat = 0;///assign the veriable to count total Turnaround Time
    for(int i = 0; i < number; i++) {
        sumtat += turnaroundTime[i];//
    }
    return sumtat / number;
  }
/// to get the average waiting time
  private static double AvgWaitingT(int[] wait, int number){
    float sumwt = 0; ///assign the veriable to count total Waiting Time
    //Use a loop to calculate Turnaround Time
    for(int i = 0; i < number; i++) {
        sumwt += wait[i];
      }
    return sumwt / number;//to get the average waiting time
    }
//To print the final results
  public static void print(int[] burst, int[] waiit, int number){
    System.out.println("Process\t\tBurst Time\tWaiting Time\tTurnaround Time");
    int turnaroundTime[] = new int[number];
    for(int i = 0; i < number; i++) {
        turnaroundTime[i] = waiit[i] + burst[i];//To calculate turnaround Time
        System.out.println("P" + (i+1) + "\t\t" + burst[i] + "\t\t" + waiit[i] + "\t\t" + turnaroundTime[i]);
      }
    System.out.println("Average TurnaroundTime time is:\t\t\t" + AvgTurnaroundT(turnaroundTime, number));
    System.out.println("Average Waiting time is:\t\t\t" + AvgWaitingT(waiit, number));
  }  
}
