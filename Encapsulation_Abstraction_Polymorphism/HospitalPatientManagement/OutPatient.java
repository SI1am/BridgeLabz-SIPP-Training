package Encapsulation_Abstraction_Polymorphism.HospitalPatientManagement;

public class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
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
