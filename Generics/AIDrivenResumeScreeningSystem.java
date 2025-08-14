package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract JobRole class
abstract class JobRole {
    public abstract String getRoleName();
}

// Subclasses of JobRole
class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }
}

// Utility class with wildcard method to handle multiple job roles
class ResumeScreening {
    public static void screenResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Screening resumes for: " + role.getRoleName());
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(new Resume<>("Alice", new SoftwareEngineer()));
        resumes.add(new Resume<>("Bob", new DataScientist()));
        resumes.add(new Resume<>("Charlie", new ProductManager()));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAI-Driven Resume Screening System");
            System.out.println("1. Display Job Roles");
            System.out.println("2. Screen Resumes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Job Roles:");
                    for (JobRole role : jobRoles) {
                        System.out.println(role.getRoleName());
                    }
                    break;
                case 2:
                    System.out.println("Screening Resumes:");
                    ResumeScreening.screenResumes(jobRoles);
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
