import java.util.ArrayList;
import java.util.Scanner;

// Course class
class Course {
    private String courseName;
    private Professor professor;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " assigned to course " + courseName);
    }

    public Professor getProfessor() {
        return professor;
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
            System.out.println("Student " + name + " enrolled in course " + course.getCourseName());
        }
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println(c.getCourseName() + " (Professor: " + (c.getProfessor() != null ? c.getProfessor().getName() : "None") + ")");
        }
    }
}

// Professor class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of courses:");
        int courseCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Course> courses = new ArrayList<>();
        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter name of course " + (i + 1) + ":");
            String courseName = sc.nextLine();
            courses.add(new Course(courseName));
        }

        System.out.println("Enter number of professors:");
        int profCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Professor> professors = new ArrayList<>();
        for (int i = 0; i < profCount; i++) {
            System.out.println("Enter name of professor " + (i + 1) + ":");
            String profName = sc.nextLine();
            professors.add(new Professor(profName));
        }

        // Assign professors to courses
        for (Course course : courses) {
            System.out.println("Assign professor to course " + course.getCourseName() + ":");
            for (int i = 0; i < professors.size(); i++) {
                System.out.println((i + 1) + ". " + professors.get(i).getName());
            }
            int profIndex = sc.nextInt();
            sc.nextLine();
            if (profIndex >= 1 && profIndex <= professors.size()) {
                course.assignProfessor(professors.get(profIndex - 1));
            } else {
                System.out.println("Invalid professor index.");
            }
        }

        System.out.println("Enter number of students:");
        int studentCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            String studentName = sc.nextLine();
            Student student = new Student(studentName);
            students.add(student);

            System.out.println("Enter number of courses to enroll:");
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

        // Show courses for each student
        for (Student student : students) {
            student.showCourses();
        }

        sc.close();
    }
}
