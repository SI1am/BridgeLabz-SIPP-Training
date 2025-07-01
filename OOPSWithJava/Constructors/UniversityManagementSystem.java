package OOPSWithJava.Constructors;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int roll, String name, double cgpa) {
        this.rollNumber = roll;
        this.name = name;
        this.CGPA = cgpa;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double cgpa) {
        this.CGPA = cgpa;
    }
}

class PostgraduateStudent extends Student {
    PostgraduateStudent(int roll, String name, double cgpa) {
        super(roll, name, cgpa);
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Roll: " + rollNumber);
    }
}

class StudentTest {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Priya", 8.5);
        pg.displayInfo();
        System.out.println("CGPA: " + pg.getCGPA());
    }
}