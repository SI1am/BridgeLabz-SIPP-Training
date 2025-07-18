package ScenarioBased;
import java.util.*;

class Dish {
    String name;
    String type;
    List<String> tags;

    Dish(String name, String type, List<String> tags) {
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - " + tags;
    }
}

public class RestaurantMenu {
    ArrayList<Dish> menu = new ArrayList<>();
    HashSet<String> dishNames = new HashSet<>();

    public void addDish(Dish dish) {
        if (dishNames.contains(dish.name.toLowerCase())) {
            System.out.println("Duplicate dish. Not added.");
            return;
        }
        menu.add(dish);
        dishNames.add(dish.name.toLowerCase());
    }

    public void searchDish(String keyword) {
        for (Dish dish : menu) {
            if (dish.name.toLowerCase().contains(keyword.toLowerCase()) ||
                dish.tags.stream().anyMatch(tag -> tag.toLowerCase().contains(keyword.toLowerCase()))) {
                System.out.println(dish);
            }
        }
    }

    public static void main(String[] args) {
        RestaurantMenu rm = new RestaurantMenu();
        rm.addDish(new Dish("Paneer Tikka", "Starter", Arrays.asList("spicy", "paneer")));
        rm.addDish(new Dish("Veg Biryani", "Main Course", Arrays.asList("rice", "spicy")));
        rm.searchDish("spicy");
    }
}