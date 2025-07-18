import java.util.*;

interface EventManager {
    void addEvent(Event event);
    void modifyEvent(int eventId, String name, String location, String date);
    void removeEvent(int eventId);
    List<Event> getEvents();
}

class Event {
    private static int counter = 1;
    private int eventId;
    private String name;
    private String location;
    private String date;

    public Event(String name, String location, String date) {
        this.eventId = counter++;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public int getEventId() { return eventId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getDate() { return date; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setDate(String date) { this.date = date; }
}

class Ticket {
    private static int ticketCounter = 1;
    private int ticketId;
    private User user;
    private Event event;

    public Ticket(User user, Event event) {
        this.ticketId = ticketCounter++;
        this.user = user;
        this.event = event;
    }

    public int getTicketId() { return ticketId; }
    public User getUser() { return user; }
    public Event getEvent() { return event; }
}

class User {
    private String name;
    private String email;
    private List<Ticket> tickets = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Ticket register(Event event) {
        Ticket ticket = new Ticket(this, event);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() { return tickets; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Admin implements EventManager {
    private List<Event> events;

    public Admin(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void modifyEvent(int eventId, String name, String location, String date) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                event.setName(name);
                event.setLocation(location);
                event.setDate(date);
                break;
            }
        }
    }

    public void removeEvent(int eventId) {
        events.removeIf(event -> event.getEventId() == eventId);
    }

    public List<Event> getEvents() {
        return events;
    }
}

public class EventHive {
    private static List<Event> events = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin(events);

        while (true) {
            System.out.println("1. User Portal");
            System.out.println("2. Admin Portal");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter name:");
                String name = sc.nextLine();
                System.out.println("Enter email:");
                String email = sc.nextLine();
                User user = new User(name, email);
                users.add(user);

                if (events.isEmpty()) {
                    System.out.println("No events available.");
                    continue;
                }

                System.out.println("Available Events:");
                for (Event event : events) {
                    System.out.println(event.getEventId() + ". " + event.getName() + " at " + event.getLocation() + " on " + event.getDate());
                }
                System.out.println("Enter Event ID to register:");
                int eventId = sc.nextInt();
                sc.nextLine();
                Event selectedEvent = null;
                for (Event event : events) {
                    if (event.getEventId() == eventId) {
                        selectedEvent = event;
                        break;
                    }
                }
                if (selectedEvent != null) {
                    Ticket ticket = user.register(selectedEvent);
                    System.out.println("Registered! Ticket ID: " + ticket.getTicketId());
                } else {
                    System.out.println("Invalid Event ID.");
                }
            } else if (choice == 2) {
                System.out.println("1. Add Event");
                System.out.println("2. Modify Event");
                System.out.println("3. Remove Event");
                System.out.println("4. View Events");
                int adminChoice = sc.nextInt();
                sc.nextLine();

                if (adminChoice == 1) {
                    System.out.println("Enter event name:");
                    String name = sc.nextLine();
                    System.out.println("Enter location:");
                    String location = sc.nextLine();
                    System.out.println("Enter date:");
                    String date = sc.nextLine();
                    Event event = new Event(name, location, date);
                    admin.addEvent(event);
                    System.out.println("Event added.");
                } else if (adminChoice == 2) {
                    System.out.println("Enter Event ID to modify:");
                    int eventId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name:");
                    String name = sc.nextLine();
                    System.out.println("Enter new location:");
                    String location = sc.nextLine();
                    System.out.println("Enter new date:");
                    String date = sc.nextLine();
                    admin.modifyEvent(eventId, name, location, date);
                    System.out.println("Event modified.");
                } else if (adminChoice == 3) {
                    System.out.println("Enter Event ID to remove:");
                    int eventId = sc.nextInt();
                    sc.nextLine();
                    admin.removeEvent(eventId);
                    System.out.println("Event removed.");
                } else if (adminChoice == 4) {
                    List<Event> eventList = admin.getEvents();
                    if (eventList.isEmpty()) {
                        System.out.println("No events available.");
                    } else {
                        for (Event event : eventList) {
                            System.out.println(event.getEventId() + ". " + event.getName() + " at " + event.getLocation() + " on " + event.getDate());
                        }
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }
}
