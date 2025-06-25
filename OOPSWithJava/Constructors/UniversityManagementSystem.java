package OOPSWithJava.Constructors;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void showName() {
        System.out.println("Name (protected): " + name);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s = new Student(101, "Alice", 8.5);
        System.out.println("Roll Number: " + s.rollNumber);
        PostgraduateStudent pg = new PostgraduateStudent(102, "Bob", 9.0);
        pg.showName();
        s.setCGPA(9.2);
        System.out.println("CGPA: " + s.getCGPA());
    }
}
