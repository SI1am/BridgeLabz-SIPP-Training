package Generics;

import java.util.ArrayList;
import java.util.List;

// Abstract class WarehouseItem
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}

// Electronics subclass
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public String getDescription() {
        return "Electronics: " + getName() + ", Brand: " + brand;
    }
}

// Groceries subclass
class Groceries extends WarehouseItem {
    private String expirationDate;

    public Groceries(String name, String expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getDescription() {
        return "Groceries: " + getName() + ", Expiration Date: " + expirationDate;
    }
}

// Furniture subclass
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public String getDescription() {
        return "Furniture: " + getName() + ", Material: " + material;
    }
}

// Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getItems() {
        return items;
    }

    // Wildcard method to display all items regardless of type
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getDescription());
        }
    }
}
