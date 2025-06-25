package OOPSWithJava.Constructors;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    public void showManagerInfo() {
        System.out.println("Employee ID (public): " + employeeID);
        System.out.println("Department (protected): " + department);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee emp = new Employee(1, "HR", 50000);
        emp.setSalary(60000);
        System.out.println("Salary: " + emp.getSalary());
        Manager mgr = new Manager(2, "IT", 80000);
        mgr.showManagerInfo();
    }
}
