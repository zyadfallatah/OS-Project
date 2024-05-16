package components.RoundRobin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
  @Author: Ziyad mohammed fallatah
  Last updated: 5/7/2024  MM/DD/YYYY
 */

public class RoundRobin {
  private int timeline;
  private int quantum;
  private int idNum;
  private int contextSwitch;
  private boolean isArrivalSame;

  private ArrayList<RoundRobinProcess> processList = new ArrayList<>();
  private Queue<RoundRobinProcess> finishedProcess = new LinkedList<>();
  private RoundRobinProcess lastProcess;
  private RoundRobinProcess totalProcessTimes;

  public RoundRobin(int quantum, boolean isArrivalSame) {
    this.quantum = quantum;
    this.timeline = 0;
    this.lastProcess = null;
    this.idNum = 0;
    this.contextSwitch = -1;
    this.isArrivalSame = isArrivalSame;
    totalProcessTimes = new RoundRobinProcess("Total: ", -1);
  }

  private void setTotalProcessTime(RoundRobinProcess currentProcess) {
    totalProcessTimes.setWaitingTime(totalProcessTimes.getWaitingTime() + currentProcess.getWaitingTime());
    totalProcessTimes.setResponseTime(totalProcessTimes.getResponseTime() + currentProcess.getResponseTime());
    totalProcessTimes.setTurnAroundTime(totalProcessTimes.getTurnAroundTime() + currentProcess.getTurnAroundTime());
  }

  private int handleRemain(RoundRobinProcess process) {
    int remain = process.getBurstTime() - quantum;

    return remain >= 0 ? 0 : Math.abs(remain);
  }

  private void removeItem(RoundRobinProcess process) {
    if (!process.isProcessFinished()) return;
    
    processList.remove(process);
  }


  private void addProcess(RoundRobinProcess process) {
    if (isArrivalSame)
      process.setArrivalTime(0);
    else
      process.setArrivalTime(idNum);

    idNum++;
    processList.add(process);
  }

  public void createProcess(int burstTime) {
    addProcess(new RoundRobinProcess("P" + idNum, burstTime));
  }

  public ArrayList<RoundRobinProcess> getInsertedData() {
    return processList;
  }

  public Queue<RoundRobinProcess> execute() {
    if (processList.isEmpty()) throw new Error("No input to round robin");

    this.assignTimes(true);
    
    while (!processList.isEmpty()) {
      this.assignTimes(false);
    }

    return finishedProcess;
  }

  public int getContextSwitches() {
    return contextSwitch;
  }

  public String getAvg() {
    String finalString = "";
    finalString += totalProcessTimes.getProcessID();
    finalString += "\nResponse Time: " + ((double) totalProcessTimes.getResponseTime() / idNum);
    finalString += "\nWaiting Time: " + ((double) totalProcessTimes.getWaitingTime() / idNum);
    finalString +="\nTurnaround Time: " + ((double) totalProcessTimes.getTurnAroundTime() / idNum) + "\n";
    return finalString;
  }

  private void assignTimes(boolean assignResponseTime) {
    int remain;
    int removed = 0;
    int size = processList.size();

    for (int i = 0; i < size; i++) {
      RoundRobinProcess process = processList.get(i - removed);
      remain = handleRemain(process);

      if (assignResponseTime)
        process.setResponseTime(timeline);


      process.setBurstTime(process.getBurstTime() - quantum);

      timeline += quantum - remain; // If quantum execeed burst time

      process.setLastWaitingTime(timeline);

      lastProcess = process;
      
      contextSwitch++;

      if (process.getBurstTime() == 0)
        process.changeFinishState();

      if (process.isProcessFinished()) {
        finishedProcess.add(process);

        removeItem(process);
        removed++;

        process.setWaitingTime(timeline - process.getIntialBurstTime());
        process.setTurnAroundTime(timeline);

        setTotalProcessTime(process);
      }
    }
  }
}
