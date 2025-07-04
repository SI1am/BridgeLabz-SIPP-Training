package Encapsulation_Abstraction_Polymorphism.HospitalPatientManagement;

public class InPatient extends Patient implements MedicalRecord {
    private int numberOfDays;
    private double roomChargePerDay;

    public InPatient(String id, String name, int age, int days, double rate) {
        super(id, name, age);
        this.numberOfDays = days;
        this.roomChargePerDay = rate;
    }

    @Override
    public double calculateBill() {
        return numberOfDays * roomChargePerDay + 1500; // Base treatment charge
    }

    @Override
    public void addRecord(String diagnosis, String history) {
        setDiagnosis(diagnosis);
        setMedicalHistory(history);
    }

    @Override
    public void viewRecords() {
        System.out.println("Diagnosis: " + getDiagnosis());
        System.out.println("History: " + getMedicalHistory());
    }
}
