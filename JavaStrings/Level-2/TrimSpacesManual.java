import java.util.Scanner;

public class TrimSpacesManual {
    // Trim leading and trailing spaces using charAt()
    public static int[] trimIndices(String s) {
        int start = 0, end = 0;
        int len = 0;
        try { while (true) { s.charAt(len); len++; } } catch (IndexOutOfBoundsException e) {}
        // Find first non-space
        while (start < len && s.charAt(start) == ' ') start++;
        // Find last non-space
        end = len - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        return new int[]{start, end + 1};
    }

    // Create substring using charAt()
    public static String substringCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end && i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int len1 = 0, len2 = 0;
        try { while (true) { s1.charAt(len1); len1++; } } catch (IndexOutOfBoundsException e) {}
        try { while (true) { s2.charAt(len2); len2++; } } catch (IndexOutOfBoundsException e) {}
        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String text = sc.nextLine();
        int[] indices = trimIndices(text);
        String trimmedManual = substringCharAt(text, indices[0], indices[1]);
        String trimmedBuiltIn = text.trim();
        boolean same = compareStringsCharAt(trimmedManual, trimmedBuiltIn);
        System.out.println("Manual trim: '" + trimmedManual + "'");
        System.out.println("Built-in trim: '" + trimmedBuiltIn + "'");
        System.out.println("Are both trims equal? " + same);
    }
}
