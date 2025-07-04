package Encapsulation_Abstraction_Polymorphism.EmployeeManagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees to add: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Employee #" + i + " ---");
            System.out.print("Enter Employee Type (fulltime/parttime): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Employee ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Name: ");
            String name = sc.nextLine();

            if (type.equals("fulltime")) {
                System.out.print("Base Salary: ");
                double baseSalary = Double.parseDouble(sc.nextLine());

                System.out.print("Bonus: ");
                double bonus = Double.parseDouble(sc.nextLine());

                FullTimeEmployee ft = new FullTimeEmployee(id, name, baseSalary, bonus);

                System.out.print("Assign Department: ");
                String dept = sc.nextLine();
                ft.assignDepartment(dept);

                employees.add(ft);

            } else if (type.equals("parttime")) {
                System.out.print("Hourly Rate: ");
                double rate = Double.parseDouble(sc.nextLine());

                System.out.print("Hours Worked: ");
                int hours = Integer.parseInt(sc.nextLine());

                PartTimeEmployee pt = new PartTimeEmployee(id, name, rate, hours);

                System.out.print("Assign Department: ");
                String dept = sc.nextLine();
                pt.assignDepartment(dept);

                employees.add(pt);
            } else {
                System.out.println("Invalid employee type. Please try again.");
                i--; // repeat this iteration
            }
        }

        // Display employee details using polymorphism
        System.out.println("\n========= Employee Summary =========");
        for (Employee e : employees) {
            e.displayDetails();
        }

        sc.close();
    }
}
