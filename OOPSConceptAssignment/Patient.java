package OOPSConceptAssignment;

import java.util.Scanner;

public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name; // this to initialize
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID; // final variable
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Object is not an instance of Patient");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name for patient 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter age for patient 1: ");
        int age1 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter ailment for patient 1: ");
        String ailment1 = sc.nextLine();
        System.out.print("Enter patient ID for patient 1: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter name for patient 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter age for patient 2: ");
        int age2 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter ailment for patient 2: ");
        String ailment2 = sc.nextLine();
        System.out.print("Enter patient ID for patient 2: ");
        int id2 = sc.nextInt();

        Patient p1 = new Patient(name1, age1, ailment1, id1);
        Patient p2 = new Patient(name2, age2, ailment2, id2);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
        System.out.println();
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

        sc.close();
    }
}
