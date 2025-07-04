package Encapsulation_Abstraction_Polymorphism.HospitalPatientManagement;


public abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = "";
        this.medicalHistory = "";
    }

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setMedicalHistory(String history) {
        this.medicalHistory = history;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public abstract double calculateBill();
}
