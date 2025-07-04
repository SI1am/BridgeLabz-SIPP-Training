package Encapsulation_Abstraction_Polymorphism.LibraryManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryItem[] items = new LibraryItem[3];

        for (int i = 0; i < items.length; i++) {
            System.out.println("\nEnter details for item #" + (i + 1));
            System.out.print("Choose item type (Book / Magazine / DVD): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Item ID: ");
            String id = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author/Publisher: ");
            String author = sc.nextLine();

            switch (type) {
                case "book":
                    items[i] = new Book(id, title, author);
                    break;
                case "magazine":
                    items[i] = new Magazine(id, title, author);
                    break;
                case "dvd":
                    items[i] = new DVD(id, title, author);
                    break;
                default:
                    System.out.println("Invalid type. Try again.");
                    i--; // repeat this iteration
            }
        }

        System.out.println("\n------ Library Items Overview ------");
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                System.out.print("Do you want to reserve this item? (yes/no): ");
                String input = sc.nextLine().trim().toLowerCase();

                if (input.equals("yes")) {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    boolean reserved = ((Reservable) item).reserveItem(name);
                    System.out.println("Reserved: " + (reserved ? "Yes" : "No"));
                }

                System.out.println("Available: " + (((Reservable) item).checkAvailability() ? "Yes" : "No"));
                System.out.println("Borrowed By: " + item.getBorrower());
            }

            System.out.println("-------------------------");
        }

        sc.close();
    }
}
