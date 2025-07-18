package ScenarioBased;
public class IceCreamRush {
    public static void main(String[] args) {
        String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Mango", "Butterscotch", "Lemon", "Pineapple", "Blueberry"};
        int[] sales = {50, 70, 40, 60, 30, 20, 55, 65};

        for (int i = 0; i < sales.length - 1; i++) {
            for (int j = 0; j < sales.length - i - 1; j++) {
                if (sales[j] < sales[j + 1]) {
                    int temp = sales[j];
                    sales[j] = sales[j + 1];
                    sales[j + 1] = temp;

                    String tempFlavor = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = tempFlavor;
                }
            }
        }

        System.out.println("Popular Flavors:");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println(flavors[i] + ": " + sales[i] + " scoops");
        }
    }
}