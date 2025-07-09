package LinkedList;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "TicketID: " + ticketId + ", Customer: " + customerName + ", Movie: " + movieName +
               ", Seat: " + seatNumber + ", Time: " + bookingTime;
    }
}

class TicketReservationSystem {
    private Ticket head = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked successfully!");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomerOrMovie(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for: " + keyword);
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket curr = head, prev = null;

        // if the ticket to remove is the head
        if (head.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
            } else {
                Ticket temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            System.out.println("Ticket with ID " + ticketId + " removed.");
            return;
        }

        do {
            prev = curr;
            curr = curr.next;
            if (curr.ticketId == ticketId) {
                prev.next = curr.next;
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
        } while (curr != head);

        System.out.println("Ticket ID not found.");
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total booked tickets: " + count);
    }
}

public class ReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n=== Online Ticket Reservation System ===");
            System.out.println("1. Add New Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name or Movie Name");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, customer, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchByCustomerOrMovie(keyword);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
