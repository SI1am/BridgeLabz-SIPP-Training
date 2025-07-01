package OOPSWithJava.Constructors;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int id, String dept, double salary) {
        this.employeeID = id;
        this.department = dept;
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
    Manager(int id, String dept, double salary) {
        super(id, dept, salary);
    }

    void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

class EmployeeTest {
    public static void main(String[] args) {
        Manager mgr = new Manager(2001, "HR", 60000);
        mgr.displayManagerDetails();
        System.out.println("Salary: " + mgr.getSalary());
    }
}
