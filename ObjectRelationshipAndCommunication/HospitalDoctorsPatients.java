import java.util.ArrayList;
import java.util.Scanner;

// Patient class
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Doctor class
class Doctor {
    String name;
    ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Patients of Doctor " + name + ":");
        for (Patient p : patients) {
            System.out.println(p.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showDoctors() {
        System.out.println("Doctors in hospital " + name + ":");
        for (Doctor d : doctors) {
            System.out.println(d.name);
        }
    }

    public void showPatients() {
        System.out.println("Patients in hospital " + name + ":");
        for (Patient p : patients) {
            System.out.println(p.getName());
        }
    }
}

public class HospitalDoctorsPatients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter hospital name:");
        String hospitalName = sc.nextLine();
        Hospital hospital = new Hospital(hospitalName);

        System.out.println("Enter number of doctors:");
        int doctorCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Doctor> doctors = new ArrayList<>();
        for (int i = 0; i < doctorCount; i++) {
            System.out.println("Enter name of doctor " + (i + 1) + ":");
            String doctorName = sc.nextLine();
            Doctor doctor = new Doctor(doctorName);
            doctors.add(doctor);
            hospital.addDoctor(doctor);
        }

        System.out.println("Enter number of patients:");
        int patientCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Patient> patients = new ArrayList<>();
        for (int i = 0; i < patientCount; i++) {
            System.out.println("Enter name of patient " + (i + 1) + ":");
            String patientName = sc.nextLine();
            Patient patient = new Patient(patientName);
            patients.add(patient);
            hospital.addPatient(patient);
        }

        // Assign patients to doctors and simulate consultations
        for (Doctor doctor : doctors) {
            System.out.println("Enter number of patients for doctor " + doctor.name + ":");
            int numPatients = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < numPatients; j++) {
                System.out.println("Enter patient index (1 to " + patientCount + ") for consultation:");
                int patientIndex = sc.nextInt();
                sc.nextLine();
                if (patientIndex >= 1 && patientIndex <= patientCount) {
                    Patient patient = patients.get(patientIndex - 1);
                    doctor.addPatient(patient);
                    doctor.consult(patient);
                } else {
                    System.out.println("Invalid patient index.");
                }
            }
        }

        // Show patients for each doctor
        for (Doctor doctor : doctors) {
            doctor.showPatients();
        }

        sc.close();
    }
}
