package components.Sjf;
import java.util.Scanner;


public class Sjf {
    static Scanner scnr = new Scanner(System.in);
    public static void call() {

        System.out.println("how many proccess");
        int ProNum = scnr.nextInt();
        procces[] schedul = new procces[ProNum];
        
        for(int i = 0; i < schedul.length;i++){
            schedul[i] = new procces();
        }

        print(schedul);
        sort(schedul);
        printSorted(schedul);
        clacStartFinish(schedul);
        System.out.println( "" );
        calcTrnAround(schedul,ProNum);
        System.out.println( "" );
        calcwaiting(schedul,ProNum);

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void print(procces[]array) {
        System.out.println("id  arrival time  burst time");
        for(int i = 0; i < array.length;i++){
        System.out.println(array[i].getPId() + "          " + array[i].getArrival() + "         " + array[i].getBurstTime());
        }
    }
    
    public static void printSorted(procces[]array) {
        System.out.println("gentt chart");
        for(int i = 0; i < array.length;i++){
        System.out.print( "" );
        System.out.print("["+array[i].getBurstTime()+"]");
        }
        System.out.println( "" );
    }


    public static void calcwaiting(procces[]array,int proNum) {
        float avgWaiting = 0;
        for(int i = 0; i < array.length;i++){
            array[i].setWaitingTime(array[i].getTurnAround()-array[i].getBurstTime());
            System.out.println("waiting time for " + array[i].getPId() + " is : " + array[i].getWaitingTime());
        }
        for(int i = 0; i < array.length;i++){
            avgWaiting = avgWaiting + array[i].getWaitingTime();
        }
        avgWaiting = avgWaiting/proNum;
        System.out.println("avrage turn waiting time is " + avgWaiting);
    }

    public static void calcTrnAround(procces[]array,int proNum){
        for(int i = 0; i < array.length;i++){
            array[i].setTurnAround(array[i].getPFinish()-array[i].getArrival());
            System.out.println("turn around time for " + array[i].getPId() + " is : " + array[i].getTurnAround());
        }
        float avgTAT = 0;
        for(int i = 0; i < array.length;i++){
            avgTAT = avgTAT + array[i].getTurnAround();
        }
        avgTAT = avgTAT/proNum;
        System.out.println("avrage turn around time is " + avgTAT);
    }

    public static void clacStartFinish(procces[]array) {
      for(int i=0;i<array.length;i++){
          if(i==0){
            array[i].setPStart(0);
            array[i].setPFinish(array[i].getBurstTime());
          }else{
            array[i].setPStart(array[i-1].getPFinish());
            array[i].setPFinish(array[i].getPStart()+array[i].getBurstTime());
          }
      }
    }

    public static void sort(procces[]array){
      for(int i = 0; i < array.length; i++){
        if(i+1 == array.length){
        }
        else if (array[i].getBurstTime() > array[i+1].getBurstTime()){
            procces temp = array[i];
            array[i] = array[i+1];
            array[i+1] = temp;
        }
      }
      for(int i = array.length - 1; i >= 0; i--){
        if(i-1 == -1){
          }else if (array[i].getBurstTime() < array[i-1].getBurstTime()){
            procces temp = array[i-1];
            array[i-1] = array[i];
            array[i] = temp;
        }
        
      }
  }
}
