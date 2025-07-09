package LinkedList;

import java.util.Scanner;

// Node representing a task
class Task {
    int id;
    String name;
    String priority;
    String dueDate;
    Task next;

    Task(int id, String name, String priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List class
class TaskScheduler {
    Task head = null;
    Task tail = null;
    Task current = null;

    // Add at beginning
    void addAtBeginning(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
        System.out.println("Task added at beginning.");
    }

    // Add at end
    void addAtEnd(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
        System.out.println("Task added at end.");
    }

    // Add at specific position
    void addAtPosition(int id, String name, String priority, String dueDate, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int i = 1;

        while (i < position - 1 && temp.next != head) {
            temp = temp.next;
            i++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
        System.out.println("Task added at position " + position);
    }

    // Remove by ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Task temp = head, prev = tail;
        boolean found = false;

        do {
            if (temp.id == id) {
                found = true;
                if (temp == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (found)
            System.out.println("Task with ID " + id + " removed.");
        else
            System.out.println("Task not found.");
    }

    // View current task and move to next
    void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    // Display a single task
    void displayTask(Task task) {
        System.out.println("ID: " + task.id);
        System.out.println("Name: " + task.name);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
    }

    // Display all tasks
    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("--- All Tasks ---");
        do {
            displayTask(temp);
            System.out.println("-----------------");
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;

        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                displayTask(temp);
                System.out.println("-----------------");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}

// Main class
public class CircularTaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Priority: ");
                    String priority = sc.nextLine();
                    System.out.print("Due Date: ");
                    String date = sc.nextLine();
                    if (choice == 1)
                        scheduler.addAtBeginning(id, name, priority, date);
                    else if (choice == 2)
                        scheduler.addAtEnd(id, name, priority, date);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(id, name, priority, date, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Task ID to remove: ");
                    int id = sc.nextInt();
                    scheduler.removeById(id);
                }
                case 5 -> scheduler.viewCurrentTask();
                case 6 -> scheduler.displayAllTasks();
                case 7 -> {
                    System.out.print("Enter Priority to Search: ");
                    String p = sc.nextLine();
                    scheduler.searchByPriority(p);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
