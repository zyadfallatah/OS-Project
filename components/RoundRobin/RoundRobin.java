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

  public RoundRobin(int quantum, boolean isArrivalSame) {
    this.quantum = quantum;
    this.timeline = 0;
    this.lastProcess = null;
    this.idNum = 0;
    this.contextSwitch = -1;
    this.isArrivalSame = isArrivalSame;
  }

  private int handleRemain(RoundRobinProcess process) {
    int remain = process.getBurstTime() - quantum;

    return remain >= 0 ? 0 : Math.abs(remain);
  }

  private void removeItem(RoundRobinProcess process) {
    if (!process.isProcessFinished()) return;
    
    processList.remove(process);
  }

  private boolean repeatingWaitingTime(RoundRobinProcess process) {
    if (process.getWaitingTime() == 0) return true;

    if (lastProcess == null) return false;
    
    if (lastProcess == process) return false;

    return true;
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

  private void assignTimes(boolean assignResponseTime) {
    int remain;
    int removed = 0;
    int size = processList.size();

    for (int i = 0; i < size; i++) {
      RoundRobinProcess process = processList.get(i - removed);
      remain = handleRemain(process);

      if (assignResponseTime)
        process.setResponseTime(timeline);

      if (repeatingWaitingTime(process))
        process.setWaitingTime(timeline - process.getLastWaitingTime() - process.getArrivalTime());

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
        process.setTurnAroundTime(timeline);
      }
    }
  }

  public int getContextSwitches() {
    return contextSwitch;
  }
}
