package Encapsulation_Abstraction_Polymorphism.OnlineFoodDeliveryManagement;


public class VegItem extends FoodItem implements Discountable {
    private double discountApplied;

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
        this.discountApplied = 0.0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) * (1 - discountApplied / 100);
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discountApplied = percentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: " + discountApplied + "%";
    }
}
