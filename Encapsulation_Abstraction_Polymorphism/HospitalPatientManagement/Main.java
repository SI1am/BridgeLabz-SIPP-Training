package Encapsulation_Abstraction_Polymorphism.HospitalPatientManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient[] patients = new Patient[2];

        for (int i = 0; i < patients.length; i++) {
            System.out.println("\nEnter details for Patient #" + (i + 1));
            System.out.print("Choose Patient Type (InPatient / OutPatient): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Patient ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());

            if (type.equals("inpatient")) {
                System.out.print("Number of days admitted: ");
                int days = Integer.parseInt(sc.nextLine());

                System.out.print("Daily room rate: ");
                double rate = Double.parseDouble(sc.nextLine());

                InPatient inPatient = new InPatient(id, name, age, days, rate);
                System.out.print("Diagnosis: ");
                String diagnosis = sc.nextLine();
                System.out.print("Medical history: ");
                String history = sc.nextLine();

                inPatient.addRecord(diagnosis, history);
                patients[i] = inPatient;

            } else if (type.equals("outpatient")) {
                System.out.print("Consultation fee: ");
                double fee = Double.parseDouble(sc.nextLine());

                OutPatient outPatient = new OutPatient(id, name, age, fee);
                System.out.print("Diagnosis: ");
                String diagnosis = sc.nextLine();
                System.out.print("Medical history: ");
                String history = sc.nextLine();

                outPatient.addRecord(diagnosis, history);
                patients[i] = outPatient;

            } else {
                System.out.println("Invalid type. Try again.");
                i--; // redo this iteration
            }
        }

        // Display all patient info
        System.out.println("\n========= Patient Summary =========");
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());

            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }

            System.out.println("Total Bill: ₹" + p.calculateBill());
            System.out.println("------------------------------------");
        }

        sc.close();
    }
}
