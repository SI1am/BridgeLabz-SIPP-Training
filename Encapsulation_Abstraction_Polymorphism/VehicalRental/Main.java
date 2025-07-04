package Encapsulation_Abstraction_Polymorphism.VehicalRental;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("MH12AB1234", 1500, "C1234567890"));
        vehicles.add(new Bike("UP32XY9876", 500, "B0987654321"));
        vehicles.add(new Truck("DL5CTR5678", 2500, "T5678901234"));

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle No.: " + v.getVehicleNumber());
            System.out.println("Rental Cost for 5 days: ₹" + v.calculateRentalCost(5));

            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                System.out.println(i.getInsuranceDetails());
                System.out.println("Insurance Cost: ₹" + i.calculateInsurance());
            }

            System.out.println("--------");
        }
    }
}
