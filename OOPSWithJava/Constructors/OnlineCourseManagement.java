package OOPSWithJava.Constructors;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "GLA University";

    Course(String name, int duration, double fee) {
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }
}

class CourseTest {
    public static void main(String[] args) {
        Course c1 = new Course("AI", 6, 15000);
        Course c2 = new Course("Web Dev", 4, 10000);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        Course.updateInstituteName("New Tech University");
        c1.displayCourseDetails();
    }
}