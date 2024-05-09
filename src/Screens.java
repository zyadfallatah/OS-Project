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

  public static void mainScreen() {
    System.out.println("============\nCPU Scheduler\n============");
    System.out.println("Please Choose your algorithm: ");

    System.out.println("1.First Come First Serve");
    System.out.println("2.Shortest Job First");
    System.out.println("3.Priority");
    System.out.println("4.Round Robin");
  }
}
