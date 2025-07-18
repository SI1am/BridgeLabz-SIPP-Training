import java.util.*;

class Attendee {
    private String name;
    private int age;
    private String email;

    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = null;
    }

    public Attendee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}

class EventTicketingSystem {
    private Map<String, Queue<Attendee>> eventQueues;

    public EventTicketingSystem() {
        eventQueues = new HashMap<>();
    }

    public void addEvent(String eventName) {
        eventQueues.putIfAbsent(eventName, new LinkedList<>());
    }

    public void bookTicket(String eventName, Attendee attendee) {
        Queue<Attendee> queue = eventQueues.get(eventName);
        if (queue != null) {
            queue.add(attendee);
        }
    }

    public int getPosition(String eventName, String attendeeName) {
        Queue<Attendee> queue = eventQueues.get(eventName);
        if (queue == null) return -1;
        int pos = 1;
        for (Attendee a : queue) {
            if (a.getName().equals(attendeeName)) return pos;
            pos++;
        }
        return -1;
    }

    public List<String> getEvents() {
        return new ArrayList<>(eventQueues.keySet());
    }

    public List<Attendee> getAttendees(String eventName) {
        Queue<Attendee> queue = eventQueues.get(eventName);
        if (queue == null) return Collections.emptyList();
        return new ArrayList<>(queue);
    }
}

class AdminPortal {
    private EventTicketingSystem system;

    public AdminPortal(EventTicketingSystem system) {
        this.system = system;
    }

    public void addEvent(String eventName) {
        system.addEvent(eventName);
    }

    public List<String> viewEvents() {
        return system.getEvents();
    }

    public List<Attendee> viewAttendees(String eventName) {
        return system.getAttendees(eventName);
    }
}

class UserPortal {
    private EventTicketingSystem system;

    public UserPortal(EventTicketingSystem system) {
        this.system = system;
    }

    public void bookTicket(String eventName, Attendee attendee) {
        system.bookTicket(eventName, attendee);
    }

    public int getPosition(String eventName, String attendeeName) {
        return system.getPosition(eventName, attendeeName);
    }
}

public class EventTicketingSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventTicketingSystem system = new EventTicketingSystem();
        AdminPortal admin = new AdminPortal(system);
        UserPortal user = new UserPortal(system);

        System.out.println("Welcome to Event Ticketing System");
        System.out.println("Type 'admin' or 'user' to select portal, or 'exit' to quit.");

        while (true) {
            System.out.print("Portal (admin/user/exit): ");
            String portal = sc.nextLine().trim();
            if (portal.equals("admin")) {
                System.out.println("Admin Portal: Type 'add' to add event, 'view' to view events, 'attendees' to view attendees");
                System.out.print("Command: ");
                String cmd = sc.nextLine().trim();
                if (cmd.equals("add")) {
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine().trim();
                    admin.addEvent(eventName);
                    System.out.println("Event added.");
                } else if (cmd.equals("view")) {
                    List<String> events = admin.viewEvents();
                    System.out.println("Events:");
                    for (String e : events) System.out.println(e);
                } else if (cmd.equals("attendees")) {
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine().trim();
                    List<Attendee> attendees = admin.viewAttendees(eventName);
                    System.out.println("Attendees for " + eventName + ":");
                    for (Attendee a : attendees) System.out.println(a.getName());
                }
            } else if (portal.equals("user")) {
                System.out.println("User Portal: Type 'book' to book ticket, 'position' to check your position");
                System.out.print("Command: ");
                String cmd = sc.nextLine().trim();
                if (cmd.equals("book")) {
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine().trim();
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter your age: ");
                    int age = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter your email (optional, press Enter to skip): ");
                    String email = sc.nextLine().trim();
                    Attendee attendee;
                    if (email.isEmpty()) {
                        attendee = new Attendee(name, age);
                    } else {
                        attendee = new Attendee(name, age, email);
                    }
                    user.bookTicket(eventName, attendee);
                    System.out.println("Ticket booked for " + name + " in " + eventName);
                } else if (cmd.equals("position")) {
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine().trim();
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine().trim();
                    int pos = user.getPosition(eventName, name);
                    if (pos == -1) {
                        System.out.println("Not found in queue.");
                    } else {
                        System.out.println("Your position in queue: " + pos);
                    }
                }
            } else if (portal.equals("exit")) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
