package core;

public class Process {
  private int processID;
  private int burstTime;
  private int arrivalTime;
  private int waitingTime;
  private int turnAroundTime;
  private int responseTime;

  public void setProcessID(int processID) {
    this.processID = processID;
  }

  public int getProcessID() {
    return processID;
  }

  public void setBurstTime(int burstTime) {
    this.burstTime = burstTime;
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
}