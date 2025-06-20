package BuiltInFunction;

import java.util.Scanner;

public class MaxOfThreeNumbers {
    public static int getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = getInput(sc, "Enter first number: ");
        int b = getInput(sc, "Enter second number: ");
        int c = getInput(sc, "Enter third number: ");
        int max = maxOfThree(a, b, c);
        System.out.println("Maximum: " + max);
    }
}
