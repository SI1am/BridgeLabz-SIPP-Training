package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract CourseType class
abstract class CourseType {
    public abstract String getCourseType();
}

// Subclasses of CourseType
class ExamCourse extends CourseType {
    @Override
    public String getCourseType() {
        return "Exam-Based Course";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    public String getCourseType() {
        return "Assignment-Based Course";
    }
}

class ResearchCourse extends CourseType {
    @Override
    public String getCourseType() {
        return "Research-Based Course";
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }
}

// Utility class with wildcard method
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseType());
        }
    }
}

public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {
        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        List<Course<? extends CourseType>> courses = new ArrayList<>();
        courses.add(new Course<>("Math 101", new ExamCourse()));
        courses.add(new Course<>("English 201", new AssignmentCourse()));
        courses.add(new Course<>("Science 301", new ResearchCourse()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUniversity Course Management System");
            System.out.println("1. Display Course Types");
            System.out.println("2. Display Courses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Course Types:");
                    for (CourseType ct : courseTypes) {
                        System.out.println(ct.getCourseType());
                    }
                    break;
                case 2:
                    System.out.println("Courses:");
                    for (Course<? extends CourseType> course : courses) {
                        System.out.println(course.getCourseName() + " - " + course.getCourseType().getCourseType());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
