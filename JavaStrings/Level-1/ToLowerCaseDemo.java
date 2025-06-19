import java.util.Scanner;

public class ToLowerCaseDemo {
    // Convert string to lowercase using charAt()
    public static String toLowerCaseManual(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String manual = toLowerCaseManual(text);
        String builtin = text.toLowerCase();
        boolean same = compareStringsCharAt(manual, builtin);
        System.out.println("Manual lowercase: " + manual);
        System.out.println("Built-in lowercase: " + builtin);
        System.out.println("Are both lowercase strings equal? " + same);
    }
}
