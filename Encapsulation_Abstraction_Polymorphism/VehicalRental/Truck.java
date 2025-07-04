package Encapsulation_Abstraction_Polymorphism.VehicalRental;

public class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; // trucks have a loading surcharge
    }

    @Override
    public double calculateInsurance() {
        return 8000.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}
