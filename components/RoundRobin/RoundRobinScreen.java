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

  private static boolean readBool(String msg) {
    System.out.println(msg);
    Scanner scanner = new Scanner(System.in);

    return scanner.nextBoolean();
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
    RoundRobin robin = new RoundRobin(
    readInt("\nEnter the quantum: "), 
    true
    );

    for (Integer userBurstTime : roundRobinReader()) {
      robin.createProcess(userBurstTime);
    }
    printRoundRobin(robin.execute());

    System.out.println(robin.getAvg());
    System.out.println("#Context Switches: " + robin.getContextSwitches());
    }
  }

