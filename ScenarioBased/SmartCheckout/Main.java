import java.util.*;

public class Main {
    private static Map<String, Item> itemDatabase = new HashMap<>();
    private static Queue<Customer> checkoutQueue = new LinkedList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initStoreItems();
        showMenu();
    }

    private static void initStoreItems() {
        itemDatabase.put("apple", new Item("apple", 20.0, 50));
        itemDatabase.put("bread", new Item("bread", 30.0, 40));
        itemDatabase.put("milk", new Item("milk", 25.0, 60));
        itemDatabase.put("eggs", new Item("eggs", 5.0, 100));
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n📋 SmartCheckout Menu:");
            System.out.println("1. Add Customer to Queue");
            System.out.println("2. Remove Customer from Queue");
            System.out.println("3. Process Next Customer");
            System.out.println("4. View Item Database");
            System.out.println("5. View Checkout Queue");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = getIntInput();
            switch (choice) {
                case 1 -> addCustomerToQueue();
                case 2 -> removeCustomerFromQueue();
                case 3 -> processNextCustomer();
                case 4 -> viewItems();
                case 5 -> viewQueue();
                case 6 -> {
                    System.out.println("👋 Thank you for using SmartCheckout!");
                    return;
                }
                default -> System.out.println("❗ Invalid choice.");
            }
        }
    }

    private static void addCustomerToQueue() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        Customer customer = new Customer(name);

        while (true) {
            System.out.print("Enter item to add (or 'done' to finish): ");
            String itemName = sc.nextLine().toLowerCase();
            if (itemName.equals("done")) break;

            if (!itemDatabase.containsKey(itemName)) {
                System.out.println("❌ Item not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = getIntInput();

            customer.addItemToCart(itemName, qty);
        }

        checkoutQueue.offer(customer);
        System.out.println("✅ Customer added to queue.");
    }

    private static void removeCustomerFromQueue() {
        if (checkoutQueue.isEmpty()) {
            System.out.println("🚫 Queue is empty.");
        } else {
            Customer removed = checkoutQueue.poll();
            System.out.println("🧍 Removed customer: " + removed.getName());
        }
    }

    private static void processNextCustomer() {
        if (checkoutQueue.isEmpty()) {
            System.out.println("🚫 No customers in queue.");
            return;
        }

        Customer customer = checkoutQueue.poll();
        System.out.println("🛒 Processing customer: " + customer.getName());
        double total = 0;

        for (Map.Entry<String, Integer> entry : customer.getCart().entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();

            Item item = itemDatabase.get(itemName);
            if (item == null) {
                System.out.println("❌ Item '" + itemName + "' not found.");
                continue;
            }

            if (!item.isAvailable(quantity)) {
                System.out.println("⚠️ Not enough stock for " + itemName + ". Requested: " + quantity + ", Available: " + item.getStock());
                continue;
            }

            double price = item.getPrice() * quantity;
            total += price;
            item.reduceStock(quantity);

            System.out.println("✔️ " + quantity + " x " + itemName + " = ₹" + price);
        }

        System.out.println("💵 Total Bill for " + customer.getName() + ": ₹" + total);
    }

    private static void viewItems() {
        System.out.println("📦 Item Database:");
        itemDatabase.forEach((k, v) -> System.out.println("- " + v));
    }

    private static void viewQueue() {
        if (checkoutQueue.isEmpty()) {
            System.out.println("🪑 Queue is empty.");
        } else {
            System.out.println("👥 Current Queue:");
            checkoutQueue.forEach(c -> System.out.println("- " + c.getName()));
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("❗ Enter a valid number: ");
            }
        }
    }
}
