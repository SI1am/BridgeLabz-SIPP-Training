package Generics;

import java.util.Scanner;

// MealPlan interface
interface MealPlan {
    String getMealType();
}

// Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Utility class with generic method to validate and generate meal plans
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        // Validation logic can be added here
        System.out.println("Generating " + mealPlan.getMealType());
        return new Meal<>(mealPlan);
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPersonalized Meal Plan Generator");
            System.out.println("1. Generate Vegetarian Meal Plan");
            System.out.println("2. Generate Vegan Meal Plan");
            System.out.println("3. Generate Keto Meal Plan");
            System.out.println("4. Generate High-Protein Meal Plan");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
                    System.out.println("Generated: " + vegMeal.getMealPlan().getMealType());
                    break;
                case 2:
                    Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
                    System.out.println("Generated: " + veganMeal.getMealPlan().getMealType());
                    break;
                case 3:
                    Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
                    System.out.println("Generated: " + ketoMeal.getMealPlan().getMealType());
                    break;
                case 4:
                    Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
                    System.out.println("Generated: " + highProteinMeal.getMealPlan().getMealType());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
