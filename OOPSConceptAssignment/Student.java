package OOPSConceptAssignment;

import java.util.Scanner;

public class Student {
    private static String universityName = "State University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name; // this to initialize
        this.rollNumber = rollNumber; // final variable
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Object is not an instance of Student");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name for student 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter roll number for student 1: ");
        int roll1 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter grade for student 1: ");
        char grade1 = sc.nextLine().charAt(0);

        System.out.print("Enter name for student 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter roll number for student 2: ");
        int roll2 = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter grade for student 2: ");
        char grade2 = sc.nextLine().charAt(0);

        Student stud1 = new Student(name1, roll1, grade1);
        Student stud2 = new Student(name2, roll2, grade2);

        stud1.displayDetails();
        System.out.println();
        stud2.displayDetails();
        System.out.println();
        Student.displayTotalStudents();

        sc.close();
    }
}
