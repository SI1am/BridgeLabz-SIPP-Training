import java.util.ArrayList;
import java.util.Scanner;

// Faculty class (Aggregation - can exist independently)
class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String toString() {
        return "Faculty{name='" + name + "', specialization='" + specialization + "'}";
    }
}

// Department class (Composition - owned by University)
class Department {
    String name;
    ArrayList<Faculty> faculties;

    public Department(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showFaculties() {
        System.out.println("Faculties in Department " + name + ":");
        for (Faculty f : faculties) {
            System.out.println(f);
        }
    }
}

// University class (Composition - owns Departments)
class University {
    String name;
    ArrayList<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showDepartments() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            System.out.println("Department: " + dept.name);
            dept.showFaculties();
        }
    }

    public void deleteUniversity() {
        for (Department dept : departments) {
            dept.faculties.clear();
        }
        departments.clear();
        System.out.println("University " + name + " and all its departments have been deleted.");
    }
}

public class UniversityFacultiesDepartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter university name:");
        String universityName = sc.nextLine();
        University university = new University(universityName);

        System.out.println("Enter number of departments:");
        int deptCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < deptCount; i++) {
            System.out.println("Enter name of department " + (i + 1) + ":");
            String deptName = sc.nextLine();
            Department dept = new Department(deptName);
            university.addDepartment(dept);

            System.out.println("Enter number of faculties in " + deptName + ":");
            int facCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < facCount; j++) {
                System.out.println("Enter name of faculty " + (j + 1) + ":");
                String facName = sc.nextLine();
                System.out.println("Enter specialization of faculty " + (j + 1) + ":");
                String facSpec = sc.nextLine();
                Faculty faculty = new Faculty(facName, facSpec);
                dept.addFaculty(faculty);
            }
        }

        university.showDepartments();

        System.out.println("Do you want to delete the university? (yes/no)");
        String deleteChoice = sc.nextLine();
        if (deleteChoice.equalsIgnoreCase("yes")) {
            university.deleteUniversity();
        } else {
            System.out.println("University not deleted.");
        }

        sc.close();
    }
}
