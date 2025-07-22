package Generics;

import java.util.ArrayList;
import java.util.List;

// Category marker interfaces
interface BookCategory {}
interface ClothingCategory {}
interface GadgetCategory {}

// Product class with bounded type parameter
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Generic method to apply discount
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

// Catalog class to hold multiple product categories
class Catalog {
    private List<Product<?>> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public List<Product<?>> getProducts() {
        return products;
    }
}
