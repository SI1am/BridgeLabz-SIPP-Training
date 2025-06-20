package BuiltInFunction;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getUserFeedback(Scanner sc, int guess) {
        System.out.print("Is your number " + guess + "? (high/low/correct): ");
        return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        System.out.println("Think of a number between 1 and 100. I will try to guess it!");
        while (low <= high) {
            int guess = generateGuess(low, high);
            String feedback = getUserFeedback(sc, guess);
            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number: " + guess);
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else {
                System.out.println("Please enter 'high', 'low', or 'correct'.");
            }
        }
    }
}
