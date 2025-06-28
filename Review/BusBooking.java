package level;

import java.util.Scanner;

public class BusBooking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Bus Hub");

        int availableBusSeats = 20;
        boolean exit = false;

        if (availableBusSeats <= 0) {
            System.out.println("No available bus seats.");
            return;
        }

        while (!exit && availableBusSeats > 0) {
            System.out.println("\n Select Your Option:");
            System.out.println("1: Enquire Available Destinations");
            System.out.println("2: Check Ticket Prices");
            System.out.println("3: Book Tickets");
            System.out.println("4: Exit");
            System.out.print(" Enter choice (1-4): ");
            
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("\n Available Destinations:");
                    System.out.println("- Agra");
                    System.out.println("- Delhi");
                    System.out.println("- Noida");
                    break;

                case 2:
                    System.out.println("\n Ticket Prices:");
                    System.out.println("Agra  - ₹100");
                    System.out.println("Delhi - ₹200");
                    System.out.println("Noida - ₹300");
                    break;

                case 3:
                    System.out.println("\n📍 Select Destination:");
                    System.out.println("1: Delhi");
                    System.out.println("2: Agra");
                    System.out.println("3: Noida");
                    System.out.print("👉 Enter choice (1-3): ");
                    int destination = sc.nextInt();

                    availableBusSeats = booking(destination, availableBusSeats, sc);
                    System.out.println("Available Seats: "+availableBusSeats3);
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Please enter a valid option (1-4).");
            }
        }

        System.out.println("\n Thank you for choosing Bus Hub!");
        sc.close();
    }

    static int booking(int num, int seats, Scanner sc) {
        System.out.println("Available Seats: " + seats);
        System.out.print("Enter the number of tickets you need: ");
        int tick = sc.nextInt();

        if (tick <= 0) {
            System.out.println("Please enter a valid number of tickets.");
            return seats;
        }

        if (tick > seats) {
            System.out.println(" Only " + seats + " seats are available. Booking failed.");
            return seats;
        }

        int cost = 0;
        String destination = "";

        switch (num) {
            case 1:
                cost = 200;
                destination = "Delhi";
                break;
            case 2:
                cost = 100;
                destination = "Agra";
                break;
            case 3:
                cost = 300;
                destination = "Noida";
                break;
            default:
                System.out.println(" Invalid destination selected.");
                return seats;
        }

        System.out.println("Booking Successful!");
        System.out.println("Destination: " + destination);
        System.out.println("Tickets: " + tick);
        System.out.println("Total Fare: ₹" + (tick * cost));
        

        return seats - tick;
    }
}
