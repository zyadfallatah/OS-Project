package components.RoundRobin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.text.DecimalFormat;
/*
  @Author: Ziyad mohammed fallatah
  Last updated: 5/16/2024  MM/DD/YYYY

  @java.text.DecimalFormat Resource:
    - Phind AI: https://www.phind.com | How to use it
    - oracle doucment: https://docs.oracle.com/javase/8/docs/api/java/text/DecimalFormat.html | full documention
 */

public class RoundRobin {
  private int timeline;
  private int quantum;
  private int idNum;
  private int contextSwitch;
  private boolean isArrivalSame; // it's disabled

  private ArrayList<RoundRobinProcess> processList = new ArrayList<>();
  private Queue<RoundRobinProcess> finishedProcess = new LinkedList<>();
  private RoundRobinProcess totalProcessTimes;

  public RoundRobin(int quantum, boolean isArrivalSame) {
    this.quantum = quantum;
    this.timeline = 0;
    this.idNum = 0;
    this.contextSwitch = -1;
    this.isArrivalSame = isArrivalSame; // It's set to true for now 
    totalProcessTimes = new RoundRobinProcess("Total: ", -1); // Summation of all processes
  }

  private void setTotalProcessTime(RoundRobinProcess currentProcess) {
    totalProcessTimes.setWaitingTime(totalProcessTimes.getWaitingTime() + currentProcess.getWaitingTime());
    totalProcessTimes.setResponseTime(totalProcessTimes.getResponseTime() + currentProcess.getResponseTime());
    totalProcessTimes.setTurnAroundTime(totalProcessTimes.getTurnAroundTime() + currentProcess.getTurnAroundTime());
  }

  //handleReamin() is needed to know what's the turnaround time
  private int handleRemain(RoundRobinProcess process) {
    int remain = process.getBurstTime() - quantum;

    return remain >= 0 ? 0 : Math.abs(remain);
  }

  private void removeItem(RoundRobinProcess process) {
    if (!process.isProcessFinished()) return;
    
    processList.remove(process);
  }

  private void addProcess(RoundRobinProcess process) {
    // Arrival Time Disabled + It's set to true
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

  public ArrayList<RoundRobinProcess> getInsertedProcesses() {
    return processList;
  }

  // Processes are returned by which process was faster to finish
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
    DecimalFormat numFormat = new DecimalFormat("#.###");
    String finalString = "";
    finalString += totalProcessTimes.getProcessID();
    finalString += "\nResponse Time: " + numFormat.format(((double) totalProcessTimes.getResponseTime() / idNum));
    finalString += "\nWaiting Time: " + numFormat.format((double) totalProcessTimes.getWaitingTime() / idNum);
    finalString +="\nTurnaround Time: " + numFormat.format((double) totalProcessTimes.getTurnAroundTime() / idNum) + "\n";
    return finalString;
  }

  private void assignTimes(boolean assignResponseTime) {
    int remain;
    /* 
      When you delete an item from arraylist, shift everything to left
      The variable removed tracks if something was deleted to get the new shifted index
    */
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
      
      contextSwitch++;

      if (process.getBurstTime() == 0)
        process.changeFinishState(); // isProcessFinished ?

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
