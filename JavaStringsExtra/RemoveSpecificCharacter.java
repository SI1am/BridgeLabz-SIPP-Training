import java.util.Scanner;

public class RemoveSpecificCharacter {
    public static String removeChar(String s, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char ch = sc.nextLine().charAt(0);
        System.out.println("Modified String: " + removeChar(s, ch));
    }
}
