package ScenarioBased;
//Ticket class
class Ticket {
 private String eventName;
 private String userName;
 private int ticketId;
 private static int counter = 1000;

 // Parameterized constructor
 public Ticket(String eventName, String userName) {
     this.eventName = eventName;
     this.userName = userName;
     this.ticketId = counter++;
 }

 public void showTicket() {
     System.out.println("Ticket ID: " + ticketId + " | Event: " + eventName + " | User: " + userName);
 }
}

class Event {
 private String name;
 private String location;
 private boolean isActive;

 public Event(String name, String location) {
     this.name = name;
     this.location = location;
     this.isActive = true;
 }

 public String getName() {
     return name;
 }

 public boolean isActive() {
     return isActive;
 }

 public void deactivate() {
     isActive = false;
     System.out.println("Event '" + name + "' has been deactivated.");
 }

 public void updateLocation(String newLocation) {
     this.location = newLocation;
     System.out.println("Event '" + name + "' location updated to: " + location);
 }
}

//User class
class User {
 private String name;

 public User(String name) {
     this.name = name;
 }

 public Ticket register(Event event) {
     if (event.isActive()) {
         System.out.println(name + " is registering for " + event.getName());
         return new Ticket(event.getName(), name);
     } else {
         System.out.println("Registration failed. Event is inactive.");
         return null;
     }
 }
}

interface EventManager {
 void modifyEvent(Event event, String newLocation);
 void removeEvent(Event event);
}

class Admin implements EventManager {
 private String adminName;

 public Admin(String adminName) {
     this.adminName = adminName;
 }

 @Override
 public void modifyEvent(Event event, String newLocation) {
     System.out.println(adminName + " is modifying event...");
     event.updateLocation(newLocation);
 }

 @Override
 public void removeEvent(Event event) {
     System.out.println(adminName + " is removing event...");
     event.deactivate();
 }
}

//Main class to demonstrate interaction
public class EventHive {
 public static void main(String[] args) {
     Event event1 = new Event("TechTalk 2025", "Delhi");
     User user1 = new User("Aarav");
     Admin admin = new Admin("Neha");

     Ticket ticket = user1.register(event1);
     if (ticket != null) ticket.showTicket();

     admin.modifyEvent(event1, "Mumbai");
     admin.removeEvent(event1);

     // Attempt to register again after removal
     User user2 = new User("Isha");
     Ticket ticket2 = user2.register(event1);
     if (ticket2 != null) ticket2.showTicket();
 }
}