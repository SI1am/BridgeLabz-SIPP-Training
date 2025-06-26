package OOPSConceptAssignment;

import java.util.Scanner;

public class Product {
    private static double discount = 10.0; // percentage

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName; // this to initialize
        this.price = price;
        this.quantity = quantity;
        this.productID = productID; // final variable
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Object is not an instance of Product");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name for product 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter price for product 1: ");
        double price1 = sc.nextDouble();
        System.out.print("Enter quantity for product 1: ");
        int qty1 = sc.nextInt();
        System.out.print("Enter product ID for product 1: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter product name for product 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter price for product 2: ");
        double price2 = sc.nextDouble();
        System.out.print("Enter quantity for product 2: ");
        int qty2 = sc.nextInt();
        System.out.print("Enter product ID for product 2: ");
        int id2 = sc.nextInt();

        Product prod1 = new Product(name1, price1, qty1, id1);
        Product prod2 = new Product(name2, price2, qty2, id2);

        prod1.displayDetails();
        System.out.println();
        prod2.displayDetails();

        System.out.println("\nUpdating discount to 15%");
        Product.updateDiscount(15.0);

        System.out.println();
        prod1.displayDetails();
        System.out.println();
        prod2.displayDetails();

        sc.close();
    }
}
