import java.util.Scanner;

public class PalindromeCheck {
    // Logic 1: Compare start and end
    public static boolean isPalindrome1(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    // Logic 2: Recursion
    public static boolean isPalindrome2(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome2(s, start + 1, end - 1);
    }

    // Logic 3: Reverse and compare
    public static boolean isPalindrome3(String s) {
        char[] arr = s.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        for (int i = 0; i < arr.length; i++) if (arr[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        System.out.println("Logic 1: " + (isPalindrome1(text) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2: " + (isPalindrome2(text, 0, text.length() - 1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3: " + (isPalindrome3(text) ? "Palindrome" : "Not Palindrome"));
    }
}
