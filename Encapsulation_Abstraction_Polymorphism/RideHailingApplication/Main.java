package Encapsulation_Abstraction_Polymorphism.RideHailingApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rides do you want to book? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Vehicle[] rides = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Ride #" + (i + 1));
            System.out.print("Vehicle Type (Car/Bike/Auto): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Vehicle ID: ");
            String id = sc.nextLine();

            System.out.print("Driver Name: ");
            String driver = sc.nextLine();

            System.out.print("Rate per km: ₹");
            double rate = sc.nextDouble();
            sc.nextLine(); // consume newline

            if (type.equals("car")) {
                rides[i] = new Car(id, driver, rate);
            } else if (type.equals("bike")) {
                rides[i] = new Bike(id, driver, rate);
            } else if (type.equals("auto")) {
                rides[i] = new Auto(id, driver, rate);
            } else {
                System.out.println("Invalid vehicle type! Skipping this entry.");
                i--; // retry this index
            }
        }

        System.out.print("\nEnter distance of each ride in km: ");
        double distance = sc.nextDouble();

        System.out.println("\n====== Ride Summary ======");
        for (Vehicle v : rides) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: ₹" + v.calculateFare(distance));

            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                gps.updateLocation("Sector 21, New Delhi");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }

            System.out.println("====================================");
        }

        sc.close();
    }
}
