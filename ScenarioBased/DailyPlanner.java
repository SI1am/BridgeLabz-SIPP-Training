package ScenarioBased;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Task.java (Abstract Class)
abstract class Task {
    private String description;
    private String time; // e.g., "10:00 AM", "3:30 PM"
    private String date; // e.g., "2025-07-18"

    public Task(String description, String time, String date) {
        this.description = description;
        this.time = time;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    // Abstract method: Each concrete task must implement how it's executed
    public abstract void execute();

    @Override
    public String toString() {
        return "Description: " + description + ", Time: " + time + ", Date: " + date;
    }
}

// Meeting.java (Subclass of Task)
class Meeting extends Task {
    private String location;
    private String attendees;

    public Meeting(String description, String time, String date, String location, String attendees) {
        super(description, time, date);
        this.location = location;
        this.attendees = attendees;
    }

    public String getLocation() {
        return location;
    }

    public String getAttendees() {
        return attendees;
    }

    @Override
    public void execute() {
        System.out.println("Executing Meeting: " + getDescription() +
                           " at " + getTime() + " on " + getDate() +
                           " in " + location + " with " + attendees);
        // Add specific meeting logic here, e.g., send reminder, open video call link
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Meeting, Location: " + location + ", Attendees: " + attendees;
    }
}

// Workout.java (Subclass of Task)
class Workout extends Task {
    private String workoutType; // e.g., "Cardio", "Strength", "Yoga"
    private int durationMinutes;

    public Workout(String description, String time, String date, String workoutType, int durationMinutes) {
        super(description, time, date);
        this.workoutType = workoutType;
        this.durationMinutes = durationMinutes;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public void execute() {
        System.out.println("Executing Workout: " + getDescription() +
                           " (" + workoutType + ") at " + getTime() + " on " + getDate() +
                           " for " + durationMinutes + " minutes.");
        // Add specific workout logic here, e.g., start timer, log progress
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Workout, Workout Type: " + workoutType + ", Duration: " + durationMinutes + " min";
    }
}

// CodingSession.java (Subclass of Task)
class CodingSession extends Task {
    private String project;
    private String language;

    public CodingSession(String description, String time, String date, String project, String language) {
        super(description, time, date);
        this.project = project;
        this.language = language;
    }

    public String getProject() {
        return project;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public void execute() {
        System.out.println("Executing Coding Session: " + getDescription() +
                           " for project '" + project + "' using " + language +
                           " at " + getTime() + " on " + getDate() + ".");
        // Add specific coding session logic here, e.g., open IDE, push to Git
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Coding Session, Project: " + project + ", Language: " + language;
    }
}

// DailyPlanner.java (Main Class)
public class DailyPlanner {
    private LinkedList<Task> tasks; // Using LinkedList as per requirement

    public DailyPlanner() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for today.");
            return;
        }
        System.out.println("\n--- Your Daily Tasks ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("------------------------\n");
    }

    // Linear Search by Keyword
    public List<Task> searchTasks(String keyword) {
        List<Task> foundTasks = new LinkedList<>(); // Store found tasks
        String lowerCaseKeyword = keyword.toLowerCase();

        for (Task task : tasks) {
            // Search in description, and potentially in other relevant fields
            if (task.getDescription().toLowerCase().contains(lowerCaseKeyword) ||
                task.getTime().toLowerCase().contains(lowerCaseKeyword) ||
                task.getDate().toLowerCase().contains(lowerCaseKeyword)) {
                foundTasks.add(task);
            }
            // Add specific checks for subclasses if needed
            if (task instanceof Meeting) {
                Meeting meeting = (Meeting) task;
                if (meeting.getLocation().toLowerCase().contains(lowerCaseKeyword) ||
                    meeting.getAttendees().toLowerCase().contains(lowerCaseKeyword)) {
                    foundTasks.add(meeting);
                }
            } else if (task instanceof Workout) {
                Workout workout = (Workout) task;
                if (workout.getWorkoutType().toLowerCase().contains(lowerCaseKeyword)) {
                    foundTasks.add(workout);
                }
            } else if (task instanceof CodingSession) {
                CodingSession codingSession = (CodingSession) task;
                if (codingSession.getProject().toLowerCase().contains(lowerCaseKeyword) ||
                    codingSession.getLanguage().toLowerCase().contains(lowerCaseKeyword)) {
                    foundTasks.add(codingSession);
                }
            }
        }
        return foundTasks;
    }

    // Method to execute all tasks (demonstrates polymorphism)
    public void executeAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to execute.");
            return;
        }
        System.out.println("\n--- Executing All Tasks ---");
        for (Task task : tasks) {
            task.execute(); // Polymorphic call: calls the specific execute() for each task type
        }
        System.out.println("---------------------------\n");
    }

    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample tasks
        planner.addTask(new Meeting("Project Sync-up", "10:00 AM", "2025-07-18", "Zoom", "Team Alpha"));
        planner.addTask(new Workout("Morning Run", "06:30 AM", "2025-07-18", "Cardio", 45));
        planner.addTask(new CodingSession("Implement Login Feature", "01:00 PM", "2025-07-18", "E-commerce App", "Java"));
        planner.addTask(new Meeting("Client Demo", "03:00 PM", "2025-07-18", "Client Office", "Client X, John Doe"));
        planner.addTask(new Workout("Evening Yoga", "07:00 PM", "2025-07-18", "Yoga", 30));

        int choice;
        do {
            System.out.println("\nDaily Task Planner Menu:");
            System.out.println("1. Add a new task");
            System.out.println("2. List all tasks");
            System.out.println("3. Search for tasks by keyword");
            System.out.println("4. Execute all tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nSelect Task Type:");
                    System.out.println("  1. Meeting");
                    System.out.println("  2. Workout");
                    System.out.println("  3. Coding Session");
                    System.out.print("Enter task type: ");
                    int taskTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter time (e.g., 10:00 AM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter date (e.g., 2025-07-18): ");
                    String date = scanner.nextLine();

                    Task newTask = null;
                    switch (taskTypeChoice) {
                        case 1:
                            System.out.print("Enter location: ");
                            String location = scanner.nextLine();
                            System.out.print("Enter attendees: ");
                            String attendees = scanner.nextLine();
                            newTask = new Meeting(desc, time, date, location, attendees);
                            break;
                        case 2:
                            System.out.print("Enter workout type (e.g., Cardio, Strength, Yoga): ");
                            String workoutType = scanner.nextLine();
                            System.out.print("Enter duration in minutes: ");
                            int duration = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            newTask = new Workout(desc, time, date, workoutType, duration);
                            break;
                        case 3:
                            System.out.print("Enter project name: ");
                            String project = scanner.nextLine();
                            System.out.print("Enter programming language: ");
                            String language = scanner.nextLine();
                            newTask = new CodingSession(desc, time, date, project, language);
                            break;
                        default:
                            System.out.println("Invalid task type.");
                            break;
                    }
                    if (newTask != null) {
                        planner.addTask(newTask);
                    }
                    break;
                case 2:
                    planner.listAllTasks();
                    break;
                case 3:
                    System.out.print("Enter keyword to search: ");
                    String searchKeyword = scanner.nextLine();
                    List<Task> results = planner.searchTasks(searchKeyword);
                    if (results.isEmpty()) {
                        System.out.println("No tasks found matching '" + searchKeyword + "'.");
                    } else {
                        System.out.println("\n--- Search Results for '" + searchKeyword + "' ---");
                        for (Task task : results) {
                            System.out.println(task);
                        }
                        System.out.println("-----------------------------------------\n");
                    }
                    break;
                case 4:
                    planner.executeAllTasks();
                    break;
                case 5:
                    System.out.println("Exiting Daily Task Planner. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}