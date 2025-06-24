import java.util.Scanner;
import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

public class ShoppingCart {
    private ArrayList<CartItem> cart = new ArrayList<>();

    public void addItem(String name, double price, int quantity) {
        cart.add(new CartItem(name, price, quantity));
    }

    public void removeItem(String name) {
        cart.removeIf(item -> item.itemName.equals(name));
    }

    public double getTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.price * item.quantity;
        }
        return total;
    }

    public void displayCart() {
        for (CartItem item : cart) {
            System.out.println(item.itemName + " x" + item.quantity + " @ " + item.price + " each");
        }
        System.out.println("Total Cost: " + getTotalCost());
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Item\n2. Remove Item\n3. Display Cart\n4. Exit");
            System.out.print("Choose option: ");
            int opt = sc.nextInt();
            sc.nextLine();
            if (opt == 1) {
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                cart.addItem(name, price, qty);
            } else if (opt == 2) {
                System.out.print("Enter item name to remove: ");
                String name = sc.nextLine();
                cart.removeItem(name);
            } else if (opt == 3) {
                cart.displayCart();
            } else break;
        }
        sc.close();
    }
}
