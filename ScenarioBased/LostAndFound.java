package ScenarioBased;
import java.util.*;

public class LostAndFound {
    HashMap<String, LinkedList<String>> items = new HashMap<>();
    HashSet<String> itemSet = new HashSet<>();

    public void addItem(String type, String description) {
        if (itemSet.contains(description)) {
            System.out.println("Duplicate item. Not added.");
            return;
        }
        items.putIfAbsent(type, new LinkedList<>());
        items.get(type).add(description);
        itemSet.add(description);
    }

    public void searchItem(String type, String keyword) {
        LinkedList<String> list = items.get(type);
        if (list == null) {
            System.out.println("No items of type: " + type);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Item found at position: " + i + " -> " + list.get(i));
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public static void main(String[] args) {
        LostAndFound lf = new LostAndFound();
        lf.addItem("bag", "Red Nike Backpack");
        lf.addItem("mobile", "Black Samsung Galaxy");
        lf.addItem("book", "Java Programming Guide");
        lf.searchItem("bag", "nike");
    }
}