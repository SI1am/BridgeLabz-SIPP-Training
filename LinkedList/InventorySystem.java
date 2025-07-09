package LinkedList;

import java.util.Scanner;

class Item {
    String itemName;
    String itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addAtBeginning(String name, String id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at beginning.");
    }

    public void addAtEnd(String name, String id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
        System.out.println("Item added at end.");
    }

    public void addAtPosition(String name, String id, int quantity, double price, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
        System.out.println("Item added at position " + pos);
    }

    public void removeById(String id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId.equals(id)) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && !temp.next.itemId.equals(id)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    public void updateQuantity(String id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId.equals(id)) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchById(String id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId.equals(id)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No item with that name found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    public void displayItem(Item item) {
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Item ID: " + item.itemId);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: ₹" + item.price);
        System.out.println("Total Value: ₹" + (item.price * item.quantity));
        System.out.println("-------------------------");
    }

    public void calculateTotalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void sortBy(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted by " + criteria + " (" + (ascending ? "asc" : "desc") + ")");
    }

    private Item mergeSort(Item head, String criteria, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;

        middle.next = null;

        Item left = mergeSort(head, criteria, asc);
        Item right = mergeSort(nextOfMiddle, criteria, asc);

        return sortedMerge(left, right, criteria, asc);
    }

    private Item sortedMerge(Item a, Item b, String criteria, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;

        boolean compare;
        if (criteria.equals("name")) {
            compare = asc ? a.itemName.compareToIgnoreCase(b.itemName) < 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            compare = asc ? a.price < b.price : a.price > b.price;
        }

        if (compare) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, asc);
        }

        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;

        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Item (Beginning)");
            System.out.println("2. Add Item (End)");
            System.out.println("3. Add Item (Position)");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity by ID");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Item ID: ");
                    String id = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    if (choice == 1) inventory.addAtBeginning(name, id, qty, price);
                    else if (choice == 2) inventory.addAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(name, id, qty, price, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Item ID: ");
                    String id = sc.nextLine();
                    inventory.removeById(id);
                }
                case 5 -> {
                    System.out.print("Enter Item ID: ");
                    String id = sc.nextLine();
                    System.out.print("New Quantity: ");
                    int qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                }
                case 6 -> {
                    System.out.print("Enter Item ID: ");
                    String id = sc.nextLine();
                    inventory.searchById(id);
                }
                case 7 -> {
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    inventory.searchByName(name);
                }
                case 8 -> inventory.displayAll();
                case 9 -> inventory.calculateTotalInventoryValue();
                case 10 -> {
                    System.out.print("Sort Ascending (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortBy("name", asc);
                }
                case 11 -> {
                    System.out.print("Sort Ascending (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortBy("price", asc);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
