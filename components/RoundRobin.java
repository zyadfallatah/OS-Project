package components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import core.ProcessData;

/*
  @Author: Ziyad mohammed fallatah
  Last updated: 5/7/2024  MM/DD/YYYY
 */

class RoundRobinProcess extends ProcessData {
  private boolean finishState;
  private int lastWaitingTime;

  public RoundRobinProcess(String id, int burst) {
    super(id, burst);
    this.setWaitingTime(0);
    this.finishState = false;
    this.lastWaitingTime = 0;
  }

  public void changeFinishState() {
    finishState = true;
  }

  public boolean isProcessFinished() {
    return finishState;
  }

  public void setLastWaitingTime(int lastWaitingTime) {
    this.lastWaitingTime = lastWaitingTime;
  }

  public int getLastWaitingTime() {
    return lastWaitingTime;
  }
}

public class RoundRobin {
  private int timeline;
  private int quantum;

  private ArrayList<RoundRobinProcess> processList = new ArrayList<>();
  private Queue<RoundRobinProcess> finishedProcess = new LinkedList<>();
  private RoundRobinProcess lastProcess;

  public RoundRobin(int quantum) {
    this.quantum = quantum;
    this.timeline = 0;
    this.lastProcess = null;
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
        process.setWaitingTime(timeline - process.getLastWaitingTime());

      process.setBurstTime(process.getBurstTime() - quantum);

      timeline += quantum - remain; // If quantum execeed burst time

      process.setLastWaitingTime(timeline);

      lastProcess = process;
      
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

  public void addProcess(RoundRobinProcess process) {
    process.setArrivalTime(0);

    processList.add(process);
  }

  public void addProcess(ArrayList<RoundRobinProcess> processList) {
    for (RoundRobinProcess process : processList) {
      this.addProcess(process);
    }
  }
  
  public void execute() {
    if (processList.isEmpty()) throw new Error("No input to round robin");

    this.assignTimes(true);
    
    while (!processList.isEmpty()) {
      this.assignTimes(false);
    }

    // while (!finishedProcess.isEmpty()) {
    //   RoundRobinProcess element = finishedProcess.poll();
    //   System.out.print("Process ID: " + element.getProcessID() + " | ");
    //   System.out.print("Respoonse Time: " + element.getResponseTime() + " | ");
    //   System.out.print("Turnaround Time: " + element.getTurnAroundTime() + " | ");
    //   System.out.println("Waiting Time: " + element.getWaitingTime());
    // }
  }

  /*
  
  */ 
  private static void test() {
    RoundRobinProcess process1 = new RoundRobinProcess("P1", 24); // 20  16
    RoundRobinProcess process2 = new RoundRobinProcess("P2", 49); // 6  2
    RoundRobinProcess process3 = new RoundRobinProcess("P3", 8); // done
    RoundRobinProcess process4 = new RoundRobinProcess("P4", 2); // done
    
    double start = System.currentTimeMillis();
    RoundRobin test = new RoundRobin(4);

    for (int i = 0; i < 10000000; i++) {
      test.addProcess(process1);
      test.addProcess(process2);
      test.addProcess(process3);
      test.addProcess(process4);
      test.execute();
    }
    double end = System.currentTimeMillis();

    
    double time = (end - start) / 1000;
    System.out.println("Total time: " + (time) + "s");
  }
}
