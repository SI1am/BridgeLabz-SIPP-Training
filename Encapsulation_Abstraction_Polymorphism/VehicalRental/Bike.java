package Encapsulation_Abstraction_Polymorphism.VehicalRental;

public class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1500.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}
