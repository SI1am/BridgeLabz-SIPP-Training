import java.util.*;

class Customer {
    private String name;
    private Map<String, Integer> cart; // itemName -> quantity

    public Customer(String name) {
        this.name = name;
        this.cart = new LinkedHashMap<>();
    }

    public String getName() { return name; }

    public void addItemToCart(String itemName, int quantity) {
        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
    }

    public Map<String, Integer> getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", Cart: " + cart;
    }
}