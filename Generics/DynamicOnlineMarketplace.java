package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        // Preload some products
        Product<BookCategory> book1 = new Product<>("Java Programming", 50.0, new BookCategory() {});
        Product<ClothingCategory> cloth1 = new Product<>("T-Shirt", 20.0, new ClothingCategory() {});
        Product<GadgetCategory> gadget1 = new Product<>("Smartwatch", 150.0, new GadgetCategory() {});

        catalog.addProduct(book1);
        catalog.addProduct(cloth1);
        catalog.addProduct(gadget1);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nDynamic Online Marketplace");
            System.out.println("1. Display Products");
            System.out.println("2. Apply Discount to a Product");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Products in Catalog:");
                    for (Product<?> product : catalog.getProducts()) {
                        System.out.println(product.getName() + " - Price: $" + product.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product name to apply discount: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter discount percentage: ");
                    double discount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    boolean found = false;
                    for (Product<?> product : catalog.getProducts()) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                            DiscountUtil.applyDiscount(product, discount);
                            System.out.println("Discount applied. New price: $" + product.getPrice());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
