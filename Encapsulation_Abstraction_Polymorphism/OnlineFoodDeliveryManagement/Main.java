package Encapsulation_Abstraction_Polymorphism.OnlineFoodDeliveryManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<FoodItem> orderList = new ArrayList<>();

        while (true) {
            System.out.println("\n---- Online Food Delivery ----");
            System.out.println("1. Add Veg Item");
            System.out.println("2. Add Non-Veg Item");
            System.out.println("3. View Order Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price per unit: ₹");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    FoodItem item;
                    if (choice == 1) {
                        item = new VegItem(name, price, qty);
                    } else {
                        item = new NonVegItem(name, price, qty);
                    }

                    System.out.print("Apply discount? (yes/no): ");
                    sc.nextLine(); // consume newline
                    String apply = sc.nextLine().trim().toLowerCase();

                    if (apply.equals("yes") && item instanceof Discountable) {
                        System.out.print("Enter discount percentage: ");
                        double discount = sc.nextDouble();
                        ((Discountable) item).applyDiscount(discount);
                        sc.nextLine(); // consume newline
                    }

                    orderList.add(item);
                    System.out.println("Item added successfully!");
                    break;

                case 3:
                    System.out.println("\n====== Order Summary ======");
                    for (FoodItem fi : orderList) {
                        System.out.println(fi.getItemDetails());

                        if (fi instanceof Discountable) {
                            System.out.println(((Discountable) fi).getDiscountDetails());
                        }

                        System.out.println("Total Price after discount: ₹" + fi.calculateTotalPrice());
                        System.out.println("-----------------------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for ordering. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
