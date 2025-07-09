package LinkedList;

import java.util.Scanner;

class Process {
    String processId;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    Process(String processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class Scheduler {
    private Process head = null;
    private Process tail = null;

    void addProcess(String id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        System.out.println("Process added.");
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the scheduler.");
            return;
        }

        Process temp = head;
        do {
            System.out.println("ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority + ", Remaining: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        Process current = head;
        Process prev = tail;

        System.out.println("\n--- Starting Round Robin Scheduling ---");

        while (head != null) {
            if (current.remainingTime > 0) {
                System.out.println("Processing: " + current.processId + " for " + Math.min(timeQuantum, current.remainingTime) + " units");
                int execTime = Math.min(timeQuantum, current.remainingTime);
                time += execTime;
                current.remainingTime -= execTime;

                if (current.remainingTime == 0) {
                    System.out.println("Process " + current.processId + " completed at time " + time);
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnAroundTime += turnaroundTime;
                    processCount++;

                    // Remove process
                    if (current == head && current == tail) {
                        head = tail = null;
                    } else {
                        if (current == head) head = head.next;
                        if (current == tail) tail = prev;
                        prev.next = current.next;
                    }
                    current = prev.next;
                } else {
                    prev = current;
                    current = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }

            System.out.println("Current Queue:");
            displayProcesses();
        }

        double avgWaiting = (double) totalWaitingTime / processCount;
        double avgTurnaround = (double) totalTurnAroundTime / processCount;
        System.out.println("\nAll processes completed.");
        System.out.println("Average Waiting Time: " + avgWaiting);
        System.out.println("Average Turnaround Time: " + avgTurnaround);
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        while (true) {
            System.out.println("\n==== Round Robin Scheduler Menu ====");
            System.out.println("1. Add Process");
            System.out.println("2. View Process Queue");
            System.out.println("3. Run Round Robin Scheduling");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Process ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Burst Time: ");
                    int burst = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    scheduler.addProcess(id, burst, priority);
                }
                case 2 -> scheduler.displayProcesses();
                case 3 -> {
                    System.out.print("Enter Time Quantum: ");
                    int tq = sc.nextInt();
                    scheduler.simulateRoundRobin(tq);
                }
                case 0 -> {
                    System.out.println("Exiting scheduler.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
