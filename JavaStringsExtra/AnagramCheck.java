import java.util.Scanner;
import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String s1, String s2) {
        char[] a1 = s1.replaceAll("\\s", "").toCharArray();
        char[] a2 = s2.replaceAll("\\s", "").toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();
        System.out.println(isAnagram(s1, s2) ? "Anagrams" : "Not Anagrams");
    }
}
