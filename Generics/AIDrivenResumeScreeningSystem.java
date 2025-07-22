package Generics;

import java.util.List;

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
