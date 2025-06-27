import java.util.ArrayList;
import java.util.Scanner;

// Course class
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println(s.getName());
        }
    }
}

// Student class
class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }
}

// School class (Aggregation of Students)
class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Students in school " + name + ":");
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}

public class SchoolStudentsCourses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter school name:");
        String schoolName = sc.nextLine();
        School school = new School(schoolName);

        System.out.println("Enter number of students:");
        int studentCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            String studentName = sc.nextLine();
            Student student = new Student(studentName);
            students.add(student);
            school.addStudent(student);
        }

        System.out.println("Enter number of courses:");
        int courseCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Course> courses = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter name of course " + (i + 1) + ":");
            String courseName = sc.nextLine();
            courses.add(new Course(courseName));
        }

        // Enroll students in courses
        for (Student student : students) {
            System.out.println("Enter number of courses for student " + student.getName() + ":");
            int enrollCount = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < enrollCount; j++) {
                System.out.println("Enter course index (1 to " + courseCount + ") to enroll:");
                int courseIndex = sc.nextInt();
                sc.nextLine();
                if (courseIndex >= 1 && courseIndex <= courseCount) {
                    student.enrollCourse(courses.get(courseIndex - 1));
                } else {
                    System.out.println("Invalid course index.");
                }
            }
        }

        // Show enrolled courses for each student
        for (Student student : students) {
            student.showCourses();
        }

        // Show enrolled students for each course
        for (Course course : courses) {
            course.showEnrolledStudents();
        }

        sc.close();
    }
}
