package OOPSConceptAssignment;

import java.util.Scanner;

public class Vehicle {
    private static double registrationFee = 100.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName; // this to initialize
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber; // final variable
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Object is not an instance of Vehicle");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter owner name for vehicle 1: ");
        String owner1 = sc.nextLine();
        System.out.print("Enter vehicle type for vehicle 1: ");
        String type1 = sc.nextLine();
        System.out.print("Enter registration number for vehicle 1: ");
        String reg1 = sc.nextLine();

        System.out.print("Enter owner name for vehicle 2: ");
        String owner2 = sc.nextLine();
        System.out.print("Enter vehicle type for vehicle 2: ");
        String type2 = sc.nextLine();
        System.out.print("Enter registration number for vehicle 2: ");
        String reg2 = sc.nextLine();

        Vehicle v1 = new Vehicle(owner1, type1, reg1);
        Vehicle v2 = new Vehicle(owner2, type2, reg2);

        v1.displayDetails();
        System.out.println();
        v2.displayDetails();

        System.out.println("\nUpdating registration fee to $150");
        Vehicle.updateRegistrationFee(150.0);

        System.out.println();
        v1.displayDetails();
        System.out.println();
        v2.displayDetails();

        sc.close();
    }
}
