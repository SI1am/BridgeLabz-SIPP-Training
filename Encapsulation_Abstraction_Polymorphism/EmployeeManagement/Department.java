package Encapsulation_Abstraction_Polymorphism.EmployeeManagement;
// Department Interface
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract Employee Class
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulated Getters & Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract Method
    public abstract double calculateSalary();

    // Concrete Method
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Department: " + department + ", Salary: " + calculateSalary());
    }

    // Department Interface Methods
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}
