import java.util.LinkedList;
import java.util.Scanner;

abstract class Task {
    String title;
    String description;

    Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    abstract void execute();

    boolean matches(String keyword) {
        return title.contains(keyword) || description.contains(keyword);
    }

    public String toString() {
        return title + ": " + description;
    }
}

class Meeting extends Task {
    String time;

    Meeting(String title, String description, String time) {
        super(title, description);
        this.time = time;
    }

    void execute() {
        System.out.println("Meeting at " + time + ": " + title + " - " + description);
    }
}

class Workout extends Task {
    String duration;

    Workout(String title, String description, String duration) {
        super(title, description);
        this.duration = duration;
    }

    void execute() {
        System.out.println("Workout for " + duration + ": " + title + " - " + description);
    }
}

class CodingSession extends Task {
    String language;

    CodingSession(String title, String description, String language) {
        super(title, description);
        this.language = language;
    }

    void execute() {
        System.out.println("Coding in " + language + ": " + title + " - " + description);
    }
}

class TaskManager {
    LinkedList<Task> tasks = new LinkedList<>();

    void addTask(Task task) {
        tasks.add(task);
    }

    void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    void executeAll() {
        for (Task task : tasks) {
            task.execute();
        }
    }

    void search(String keyword) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.matches(keyword)) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found for keyword: " + keyword);
        }
    }

    void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}

public class DailyTaskPlanner {
    static Scanner sc = new Scanner(System.in);
    static TaskManager manager = new TaskManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose portal: 1. User 2. Admin 3. Exit");
            int portal = Integer.parseInt(sc.nextLine());
            if (portal == 1) {
                userPortal();
            } else if (portal == 2) {
                adminPortal();
            } else {
                break;
            }
        }
    }

    static void userPortal() {
        while (true) {
            System.out.println("User Portal: 1. View Tasks 2. Search Task 3. Execute All 4. Back");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                manager.listTasks();
            } else if (choice == 2) {
                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();
                manager.search(keyword);
            } else if (choice == 3) {
                manager.executeAll();
            } else {
                break;
            }
        }
    }

    static void adminPortal() {
        while (true) {
            System.out.println("Admin Portal: 1. Add Task 2. Remove Task 3. View Tasks 4. Back");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                addTaskFlow();
            } else if (choice == 2) {
                manager.listTasks();
                System.out.print("Enter index to remove: ");
                int idx = Integer.parseInt(sc.nextLine());
                manager.removeTask(idx);
            } else if (choice == 3) {
                manager.listTasks();
            } else {
                break;
            }
        }
    }

    static void addTaskFlow() {
        System.out.println("Select Task Type: 1. Meeting 2. Workout 3. CodingSession");
        int type = Integer.parseInt(sc.nextLine());
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        if (type == 1) {
            System.out.print("Time: ");
            String time = sc.nextLine();
            manager.addTask(new Meeting(title, desc, time));
        } else if (type == 2) {
            System.out.print("Duration: ");
            String duration = sc.nextLine();
            manager.addTask(new Workout(title, desc, duration));
        } else if (type == 3) {
            System.out.print("Language: ");
            String lang = sc.nextLine();
            manager.addTask(new CodingSession(title, desc, lang));
        }
    }
}
