package Generics;

import java.util.List;

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
