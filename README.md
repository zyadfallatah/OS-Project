## **=== Requirements ===**

### -- Goal: Demonstrate a CPU scheduler that outputs (Waiting + Turnaround + Response).
- Use any method from the following (FCFS - SJF - Priority - Round Robin).
- Programming Language: Java
- Document your code thoroughly, including clear explanations (if needed) of functions, classes, and modules.

- Use meaningful variable and function names to enhance code readability.
- Use Comments only if necessary (Don't comment everything)

## === Design ===

### Improtant Variables to be included
- processID: string
- burstTime: int
- arrivalTime: int
- waitingTime: int
- turnAroundTime: int
- responseTime: int (if needed)

***Note: Each Process should have it's own variables of above***

### - class Scheduler
- Handle All processes
- can have multiple options -algorithms- to work

## === Work Enviroment ===
- App.java is only to run the program and it should not be modifable
- All our work will be splited inside both (src | components)
- `Scheduler.java` is responsible for which algorithm to call
- Try to document your work + include any source you rely on