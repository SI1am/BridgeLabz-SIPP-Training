package ScenarioBased;
import java.util.*;

//Attendee class with constructor overloading
class Attendee {
 private String name;
 private int age;
 private String email;

 // Constructor without email
 public Attendee(String name, int age) {
     this.name = name;
     this.age = age;
     this.email = "Not Provided";
 }

 // Constructor with email
 public Attendee(String name, int age, String email) {
     this.name = name;
     this.age = age;
     this.email = email;
 }

 public String getName() {
     return name;
 }

 public String toString() {
     return name + " (Age: " + age + ", Email: " + email + ")";
 }
}

//Ticketing system class
public class EventTicket {
 private HashMap<String, Queue<Attendee>> eventQueues;

 public EventTicket() {
     eventQueues = new HashMap<>();
 }

 // Add attendee to event queue
 public void bookTicket(String eventName, Attendee attendee) {
     eventQueues.putIfAbsent(eventName, new LinkedList<>());
     eventQueues.get(eventName).add(attendee);
     System.out.println("Booked: " + attendee.getName() + " for event '" + eventName + "'");
 }

 // Show queue for an event
 public void showQueue(String eventName) {
     Queue<Attendee> queue = eventQueues.get(eventName);
     if (queue == null || queue.isEmpty()) {
         System.out.println("No attendees for event: " + eventName);
         return;
     }

     System.out.println("\nQueue for '" + eventName + "':");
     for (Attendee attendee : queue) {
         System.out.println(attendee);
     }
 }

 // Get position of attendee in queue (linear search)
 public void getPosition(String eventName, String attendeeName) {
     Queue<Attendee> queue = eventQueues.get(eventName);
     if (queue == null) {
         System.out.println("Event not found.");
         return;
     }

     int position = 1;
     for (Attendee attendee : queue) {
         if (attendee.getName().equalsIgnoreCase(attendeeName)) {
             System.out.println(attendeeName + " is at position " + position + " in '" + eventName + "' queue.");
             return;
         }
         position++;
     }
     System.out.println(attendeeName + " not found in '" + eventName + "' queue.");
 }

 // Demo
 public static void main(String[] args) {
     EventTicket system = new EventTicket();

     Attendee a1 = new Attendee("Riya", 25);
     Attendee a2 = new Attendee("Kabir", 30, "kabir@example.com");
     Attendee a3 = new Attendee("Meera", 22);
     Attendee a4 = new Attendee("Kabir", 30); // Same name, different instance

     system.bookTicket("Rock Concert", a1);
     system.bookTicket("Rock Concert", a2);
     system.bookTicket("Rock Concert", a3);
     system.bookTicket("Rock Concert", a4);

     system.showQueue("Rock Concert");

     system.getPosition("Rock Concert", "Kabir");
     system.getPosition("Rock Concert", "Aarav");
 }
}