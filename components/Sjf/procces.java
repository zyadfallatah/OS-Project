package components.Sjf;
import java.util.Scanner;

import src.Screen;

public class procces {
static Scanner scnr = new Scanner(System.in);

    private String PId = null;
    private int BurstTime = 0;
    private int arrival = 0;
    private int PStart = 0;
    private int PFinish = 0;
    private float turnAround = 0;
    private float waitingTime = 0;

  public procces(){
    System.out.println("please enter the id");
    PId = scnr.nextLine();
    System.out.println("please enter the burst time");
    BurstTime = scnr.nextInt();
    System.out.println("please enter the arrival time");
    arrival = scnr.nextInt();
    scnr.nextLine();
    System.out.println("\n");
  }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public void setBurstTime(int BurstTime) {
        this.BurstTime = BurstTime;
    }

    public void setPId(String pId) {
        this.PId = pId;
    }

    public void setPFinish(int PFinish) {
        this.PFinish = PFinish;
    }

    public void setPStart(int PStart) {
        this.PStart = PStart;
    }

    public void setTurnAround(float turnAround) {
        this.turnAround = turnAround;
    }

    public void setWaitingTime(float waitingTime) {
        this.waitingTime = waitingTime;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
    public String getPId(){
        return this.PId;
    }

    public int getArrival() {
        return arrival;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public int getPFinish() {
        return PFinish;
    }

    public int getPStart() {
        return PStart;
    }

    public float getTurnAround() {
        return turnAround;
    }

    public float getWaitingTime() {
        return waitingTime;
    }
    

    
}
