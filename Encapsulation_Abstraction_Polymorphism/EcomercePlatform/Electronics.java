package Encapsulation_Abstraction_Polymorphism.EcomercePlatform;

public class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}
