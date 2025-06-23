import java.util.Scanner;

public class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    public void displayResult() {
        System.out.println(text + (isPalindrome() ? " is a palindrome." : " is not a palindrome."));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        PalindromeChecker pc = new PalindromeChecker(text);
        pc.displayResult();
    }
}
