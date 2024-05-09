package components.RoundRobin;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import src.Screen;

public class RoundRobinScreen {
  private static int readInt(String msg) {
    System.out.println(msg);
    Scanner scanner = new Scanner(System.in);

    return scanner.nextInt();
  }

  private static char readChar(String msg) {
    System.out.println(msg);
    Scanner scanner = new Scanner(System.in);

    return scanner.nextLine().charAt(0);
  }

  private static void printProcess(RoundRobinProcess process) {
    System.out.print("Process ID: " + process.getProcessID() + " | ");
    System.out.print("Response Time: " + process.getResponseTime() + " | ");
    System.out.print("Waiting Time: " + process.getWaitingTime() + " | ");
    System.out.println("Turnaround Time: " + process.getTurnAroundTime());
  }

  private static void printRoundRobin(Queue<RoundRobinProcess> processList) {
    while (!processList.isEmpty()) {
      RoundRobinProcess element = processList.poll();
      printProcess(element);
    }
  }

  private static void roundRobinSample() {
    RoundRobin test = new RoundRobin(4, true);
    test.createProcess(24);
    test.createProcess(3);
    test.createProcess(3);
    
    Queue<RoundRobinProcess> finishedProcess = test.execute();

    printRoundRobin(finishedProcess);
  }
  
  private static ArrayList<Integer> roundRobinReader() {
    ArrayList<Integer> burstTimeList = new ArrayList<>();
    char read;
    int userData;

    Screen.clearScreen();
    do {
      userData = readInt("Enter Your Process BurstTime: ");

      burstTimeList.add(userData);

      read = readChar("Want to add more? (y/n): ");
    } while (read != 'n');

    return burstTimeList;
  }

  public static void showScreen() {
    System.out.println("============\nRound Robin\n============");
    System.out.println("1.Sample Data.");
    System.out.println("2.Enter Your Data.");

    short opCode = -1;

    Scanner scanner = new Scanner(System.in);
    opCode = scanner.nextShort();

    switch (opCode) {
      case 1:
        roundRobinSample();
        break;
      case 2:
        RoundRobin robin = new RoundRobin(readInt("Enter the quantum: "), true);
        for (Integer userBurstTime : roundRobinReader()) {
          robin.createProcess(userBurstTime);
        }
        printRoundRobin(robin.execute());     
        break;
      default:
        System.out.println("Sorry wrong opcode");
    }
    scanner.nextLine();
  }
}
