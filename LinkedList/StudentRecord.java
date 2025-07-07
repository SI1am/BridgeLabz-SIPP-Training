package LinkedList;

import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head = null;
    Scanner sc = new Scanner(System.in);

    public void addAtBeginning() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;

        System.out.println("Student added at the beginning.");
    }

    public void addAtEnd() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }

        System.out.println("Student added at the end.");
    }

    public void deleteByRollNumber() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }

        Student prev = null;
        Student curr = head;
        while (curr != null && curr.rollNumber != roll) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Student not found.");
        } else {
            prev.next = curr.next;
            System.out.println("Record deleted.");
        }
    }

    public void searchByRollNumber() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade() {
        System.out.print("Enter Roll Number to update grade: ");
        int roll = sc.nextInt();
        System.out.print("Enter new Grade: ");
        char grade = sc.next().charAt(0);

        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = grade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }

        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Delete Student by Roll Number");
            System.out.println("4. Search Student by Roll Number");
            System.out.println("5. Update Student Grade");
            System.out.println("6. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: list.addAtBeginning(); break;
                case 2: list.addAtEnd(); break;
                case 3: list.deleteByRollNumber(); break;
                case 4: list.searchByRollNumber(); break;
                case 5: list.updateGrade(); break;
                case 6: list.displayAll(); break;
                case 0: System.out.println("Exiting program."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
