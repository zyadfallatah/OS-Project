## **=== Requirements ===**

### -- Goal: Demonstrate a CPU scheduler that outputs (Waiting + Turnaround + Response).
- Use any method from the following (FCFS - SJF - Priority - Round Robin).
- Language use : (Java | Team).
- Document your code thoroughly, including clear explanations of functions, classes, and modules.
- Consider including examples or sample inputs/outputs to illustrate how your code should be used.

- Apply OOP Concepts (exclude abstraction) (Inheritince is optional)
- Use meaningful variable and function names to enhance code readability.
- Use Comments only if necessary (Don't comment everything)

## === Design ===

### Improtant Variables to be included
- processID: int
- burstTime: int
- arrivalTime: int
- waitingTime: int
- turnAroundTime: int
- responseTime: int

***Note: Each Process should have it's own variables of above***
***Program as whole can is responsibe for the total time***

### - class Process
- Handle each process alone
- Process should not generate arrival

### - class Scheduler
- Handle All processes
- Program is the generator of arrival
- Program can reset Arrival if onther operation is done
- can have multiple options -algorithms- to work (optional)

## === Implementaion ===

***-- This is a group discuss --***

Some point to be discussed: 
1. How a certain algorithm should be implemented.
2. What variable standared to allow communication between classes
3. What Data Structures are we going to use.
4. How to make the system dynamic.

### Opnions:
- FCFS: is obvious to work with and its algorithm is straighforward.
- SJF & Priority: Both should be implemented with the same function(method) to reduce redundancy.
- Round Robin: To demonstrate that we should not allow **In Design** to work as calculator

## === Work Enviroment ===
- App.java is only to run the program and it should not be modifable
- All our work will be inside Package src
- Use `import src.*` to use what inside the package src
- If you are working inside src you might not need use `import src.*`
- There's a Test Example `Test.java` that demonstrate how to write your own class
- During production we need both `Process.java` and `Scheduler.java` each have its own functions
- Try to document your work *There's example in Test.java inside src*