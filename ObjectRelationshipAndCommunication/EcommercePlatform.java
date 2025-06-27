import java.util.ArrayList;
import java.util.Scanner;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

// Order class containing multiple Products (Aggregation)
class Order {
    private String orderId;
    private ArrayList<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in order:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

// Customer class placing Orders
class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of products:");
        int productCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            System.out.println("Enter name of product " + (i + 1) + ":");
            String productName = sc.nextLine();
            System.out.println("Enter price of product " + (i + 1) + ":");
            double price = sc.nextDouble();
            sc.nextLine();
            products.add(new Product(productName, price));
        }

        System.out.println("Enter number of customers:");
        int customerCount = sc.nextInt();
        sc.nextLine();

        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < customerCount; i++) {
            System.out.println("Enter name of customer " + (i + 1) + ":");
            String customerName = sc.nextLine();
            Customer customer = new Customer(customerName);
            customers.add(customer);

            System.out.println("Enter number of orders for " + customerName + ":");
            int orderCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < orderCount; j++) {
                System.out.println("Enter order ID for order " + (j + 1) + ":");
                String orderId = sc.nextLine();
                Order order = new Order(orderId);

                System.out.println("Enter number of products in this order:");
                int productsInOrder = sc.nextInt();
                sc.nextLine();

                for (int k = 0; k < productsInOrder; k++) {
                    System.out.println("Enter product index (1 to " + productCount + ") to add to order:");
                    int productIndex = sc.nextInt();
                    sc.nextLine();
                    if (productIndex >= 1 && productIndex <= productCount) {
                        order.addProduct(products.get(productIndex - 1));
                    } else {
                        System.out.println("Invalid product index.");
                    }
                }
                customer.placeOrder(order);
            }
        }

        // Show orders for each customer
        for (Customer customer : customers) {
            customer.showOrders();
        }

        sc.close();
    }
}
