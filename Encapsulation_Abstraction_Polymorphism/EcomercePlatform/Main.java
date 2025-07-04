package Encapsulation_Abstraction_Polymorphism.EcomercePlatform;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products to add: ");
        int n = Integer.parseInt(sc.nextLine());

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Product #" + (i + 1) + " ---");
            System.out.print("Enter Product Type (Electronics / Clothing / Groceries): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ₹");
            double price = Double.parseDouble(sc.nextLine());

            switch (type) {
                case "electronics":
                    products[i] = new Electronics(id, name, price);
                    break;
                case "clothing":
                    products[i] = new Clothing(id, name, price);
                    break;
                case "groceries":
                    products[i] = new Groceries(id, name, price);
                    break;
                default:
                    System.out.println("Invalid type. Try again.");
                    i--; // redo this iteration
            }
        }

        // Display summary
        System.out.println("\n========= Product Summary =========");
        for (Product p : products) {
            printFinalPrice(p);
        }

        sc.close();
    }

    public static void printFinalPrice(Product p) {
        double basePrice = p.getPrice();
        double discount = p.calculateDiscount();
        double tax = 0;

        if (p instanceof Taxable) {
            Taxable t = (Taxable) p;
            tax = t.calculateTax();
            System.out.println(t.getTaxDetails());
        } else {
            System.out.println("No tax applicable.");
        }

        double finalPrice = basePrice + tax - discount;

        System.out.println("Product: " + p.getName());
        System.out.println("Base Price: ₹" + basePrice);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Tax: ₹" + tax);
        System.out.println("Final Price: ₹" + finalPrice);
        System.out.println("-----------------------------------");
    }
}
