package BuiltInFunction;

import java.util.Scanner;

public class PalindromeChecker {
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    public static void displayResult(String s, boolean isPal) {
        System.out.println(s + (isPal ? " is a palindrome." : " is not a palindrome."));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = getInput(sc);
        boolean isPal = isPalindrome(s);
        displayResult(s, isPal);
    }
}
