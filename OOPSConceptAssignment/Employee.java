package OOPSConceptAssignment;

import java.util.Scanner;

public class Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name; // this to initialize
        this.id = id; // final variable
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Object is not an instance of Employee");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name for employee 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter ID for employee 1: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter designation for employee 1: ");
        String desig1 = sc.nextLine();

        System.out.print("Enter name for employee 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter ID for employee 2: ");
        int id2 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter designation for employee 2: ");
        String desig2 = sc.nextLine();

        Employee emp1 = new Employee(name1, id1, desig1);
        Employee emp2 = new Employee(name2, id2, desig2);

        emp1.displayDetails();
        System.out.println();
        emp2.displayDetails();
        System.out.println();
        Employee.displayTotalEmployees();

        sc.close();
    }
}
