package Encapsulation_Abstraction_Polymorphism.OnlineFoodDeliveryManagement;


public class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_CHARGE = 20.0; // flat non-veg charge per item
    private double discountApplied;

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
        this.discountApplied = 0.0;
    }

    @Override
    public double calculateTotalPrice() {
        double baseTotal = (getPrice() + NON_VEG_CHARGE) * getQuantity();
        return baseTotal * (1 - discountApplied / 100);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discountApplied = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discountApplied + "%";
    }
}
