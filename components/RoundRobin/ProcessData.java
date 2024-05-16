package components.RoundRobin;

import java.util.ArrayList;

/* 
  @Put all required variables into one Class
 */

public class ProcessData {
  private String processID;
  private int burstTime;
  private int arrivalTime;
  private int waitingTime;
  private int turnAroundTime;
  private int responseTime;
  
  public ProcessData(String id, int burst) {
    this.processID = id;
    this.burstTime = burst;
  }

  public String getProcessID() {
    return processID;
  }

  public void setBurstTime(int burstTime) {
    this.burstTime = burstTime;
    
    if (this.burstTime < 0) {
      this.burstTime = 0;
    }
  }

  public int getBurstTime() {
    return burstTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }
  
  public int getArrivalTime() {
    return arrivalTime;
  }
  
  public void setWaitingTime(int waitingTime) {
    this.waitingTime = waitingTime;
  }

  public int getWaitingTime() {
    return waitingTime;
  }

  public void setTurnAroundTime(int turnAroundTime) {
    this.turnAroundTime = turnAroundTime;
  }

  public int getTurnAroundTime() {
    return turnAroundTime;
  }

  public void setResponseTime(int responseTime) {
    this.responseTime = responseTime;
  }

  public int getResponseTime() {
    return responseTime;
  }

  public static ArrayList<ProcessData> sampleData() {
    ArrayList<ProcessData> processList = new ArrayList<>();
    ProcessData process1 = new ProcessData("P0", 10); 
    ProcessData process2 = new ProcessData("P1", 5); 
    ProcessData process3 = new ProcessData("P2", 30); 
    ProcessData process4 = new ProcessData("P3", 15); 

    processList.add(process1);
    processList.add(process2);
    processList.add(process3);
    processList.add(process4);

    return processList;
  }
}