package components.RoundRobin;

import core.ProcessData;

public class RoundRobinProcess extends ProcessData {
  private boolean finishState;
  private int lastWaitingTime;

  public RoundRobinProcess(String id, int burst) {
    super(id, burst);
    this.setWaitingTime(0);
    this.setResponseTime(0);
    this.setTurnAroundTime(0);
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
