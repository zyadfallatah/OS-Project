package components.RoundRobin;

/*
  - More Specific and only data that round robin needs
  - Each process shall modify and control it self from within + have data that cannot be changed
 */

public class RoundRobinProcess extends ProcessData {
  private boolean finishState;
  private int lastWaitingTime;
  private int intialBurstTime;

  public RoundRobinProcess(String id, int burst) {
    super(id, burst);
    this.setWaitingTime(0);
    this.setResponseTime(0);
    this.setTurnAroundTime(0);
    this.finishState = false;
    this.lastWaitingTime = 0;
    this.intialBurstTime = burst;
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

  public int getIntialBurstTime() {
    return intialBurstTime;
  }
}
