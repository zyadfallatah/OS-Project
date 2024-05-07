package src;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import components.RoundRobin.RoundRobin;
import components.RoundRobin.RoundRobinProcess;
import core.ProcessData;

class ListItem {
  private int generator = 1;

  public static ListItem createMenu() {
    return new ListItem();
  }

  public void addItem(String itemStr) {
    System.out.println(generator + "."+ itemStr);
    generator++;
  }
}


public class Screens {
  private static void printProcess(ProcessData process) {
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
    RoundRobin test = new RoundRobin(4);
    test.createProcess(24);
    test.createProcess(3);
    test.createProcess(3);
    
    Queue<RoundRobinProcess> finishedProcess = test.execute();

    printRoundRobin(finishedProcess);
  }
  
  private static ArrayList<Integer> roundRobinReader() {
    ArrayList<Integer> burstTimeList = new ArrayList<>();
    char read = ' ';
    Scanner scanner = new Scanner(System.in);
    int userBurstTime = -1;

    clearScreen();
    do {
      System.out.println("Enter Your Process BurstTime: ");
      userBurstTime = scanner.nextInt();

      burstTimeList.add(userBurstTime);

      System.out.println("Want to add more? (y/n): ");
      read = scanner.next().toLowerCase().charAt(0);
    } while (read != 'n');

    return burstTimeList;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }

  public static void preemptiveScreen(String source) {
    System.out.println("============\n"+ source +"\n============");
    System.out.println("Choose how to execute " + source + ": ");

    ListItem list = ListItem.createMenu();
    list.addItem("Preemptive");
    list.addItem("non-Preemptive");
  }

  public static void roundRobinScreen() {
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
        RoundRobin robin = new RoundRobin(2);
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

  public static void mainScreen() {
    System.out.println("============\nCPU Scheduler\n============");
    System.out.println("Please Choose your algorithm: ");

    System.out.println("1.First Come First Serve");
    System.out.println("2.Shortest Job First");
    System.out.println("3.Priority");
    System.out.println("4.Round Robin");
  }
}
