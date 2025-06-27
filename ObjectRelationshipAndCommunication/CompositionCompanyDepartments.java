import java.util.ArrayList;
import java.util.Scanner;

// Employee class
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String toString() {
        return "Employee{name='" + name + "', position='" + position + "'}";
    }
}

class Department {
    String name;
    ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void showEmployees() {
        System.out.println("Employees in Department " + name + ":");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

class Company {
    String name;
    ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showDepartments() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            System.out.println("Department: " + dept.name);
            dept.showEmployees();
        }
    }

    public void deleteCompany() {
        for (Department dept : departments) {
            dept.employees.clear();
        }
        departments.clear();
        System.out.println("Company " + name + " and all its departments and employees have been deleted.");
    }
}

public class CompositionCompanyDepartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter company name:");
        String companyName = sc.nextLine();
        Company company = new Company(companyName);

        System.out.println("Enter number of departments:");
        int deptCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < deptCount; i++) {
            System.out.println("Enter name of department " + (i + 1) + ":");
            String deptName = sc.nextLine();
            Department dept = new Department(deptName);
            company.addDepartment(dept);

            System.out.println("Enter number of employees in " + deptName + ":");
            int empCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < empCount; j++) {
                System.out.println("Enter name of employee " + (j + 1) + ":");
                String empName = sc.nextLine();
                System.out.println("Enter position of employee " + (j + 1) + ":");
                String empPosition = sc.nextLine();
                Employee emp = new Employee(empName, empPosition);
                dept.addEmployee(emp);
            }
        }

        company.showDepartments();

        System.out.println("Do you want to delete the company? (yes/no)");
        String deleteChoice = sc.nextLine();
        if (deleteChoice.equalsIgnoreCase("yes")) {
            company.deleteCompany();
        } else {
            System.out.println("Company not deleted.");
        }

        sc.close();
    }
}
