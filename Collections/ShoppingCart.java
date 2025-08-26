package Collections;
import java.util.*;

class Product {
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ShoppingCart {
    private HashMap<String, Double> priceMap = new HashMap<>();
    private LinkedHashMap<String, Integer> cartOrder = new LinkedHashMap<>();

    public void addProduct(String name, double price, int quantity) {
        priceMap.put(name, price);
        cartOrder.put(name, cartOrder.getOrDefault(name, 0) + quantity);
    }

    public void displayCartOrder() {
        System.out.println("Cart (in order added):");
        for (Map.Entry<String, Integer> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue() + " ($" + priceMap.get(entry.getKey()) + ")");
        }
    }

    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for (String name : cartOrder.keySet()) {
            double price = priceMap.get(name);
            sorted.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
        }
        System.out.println("Cart (sorted by price):");
        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String name : entry.getValue()) {
                System.out.println(name + " ($" + entry.getKey() + ") x" + cartOrder.get(name));
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5, 3);
        cart.addProduct("Banana", 1.0, 2);
        cart.addProduct("Orange", 2.0, 1);
        cart.displayCartOrder();
        cart.displayCartSortedByPrice();
    }
}
