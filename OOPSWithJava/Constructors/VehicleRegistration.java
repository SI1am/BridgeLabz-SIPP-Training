package OOPSWithJava.Constructors;

class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 1000;

    Vehicle(String owner, String type) {
        this.ownerName = owner;
        this.vehicleType = type;
    }

    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}

class VehicleTest {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John", "Car");
        v1.displayVehicleDetails();
        Vehicle.updateRegistrationFee(1500);
        v1.displayVehicleDetails();
    }
}