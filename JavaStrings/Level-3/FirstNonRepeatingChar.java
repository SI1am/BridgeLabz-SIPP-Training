import java.util.Scanner;

public class FirstNonRepeatingChar {
    // Find first non-repeating character using charAt()
    public static char firstNonRepeating(String s) {
        int[] freq = new int[256];
        int len = 0;
        try { while (true) { s.charAt(len); len++; } } catch (Exception e) {}
        for (int i = 0; i < len; i++) freq[s.charAt(i)]++;
        for (int i = 0; i < len; i++) if (freq[s.charAt(i)] == 1) return s.charAt(i);
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        char result = firstNonRepeating(text);
        if (result == '\0') System.out.println("No non-repeating character found.");
        else System.out.println("First non-repeating character: " + result);
    }
}
