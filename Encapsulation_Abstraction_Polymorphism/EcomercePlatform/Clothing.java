package Encapsulation_Abstraction_Polymorphism.EcomercePlatform;
public class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    public String getTaxDetails() {
        return "5% GST on Clothing";
    }
}
