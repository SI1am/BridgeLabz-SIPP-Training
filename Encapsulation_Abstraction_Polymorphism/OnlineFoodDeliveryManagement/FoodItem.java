package Encapsulation_Abstraction_Polymorphism.OnlineFoodDeliveryManagement;


public abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qty) {
        if (qty > 0)
            this.quantity = qty;
    }

    public abstract double calculateTotalPrice();
}
