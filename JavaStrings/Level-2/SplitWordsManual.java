import java.util.Scanner;

public class SplitWordsManual {
    // Find string length without using length()
    public static int getStringLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    // Split string into words using charAt()
    public static String[] splitWords(String s) {
        int len = getStringLength(s);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') wordCount++;
        }
        String[] words = new String[wordCount];
        int start = 0, w = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || s.charAt(i) == ' ') {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) sb.append(s.charAt(j));
                words[w++] = sb.toString();
                start = i + 1;
            }
        }
        return words;
    }

    // Compare two string arrays
    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[] manual = splitWords(text);
        String[] builtin = text.split(" ");
        boolean same = compareStringArrays(manual, builtin);
        System.out.print("Manual split: ");
        for (String w : manual) System.out.print(w + ", ");
        System.out.println();
        System.out.print("Built-in split: ");
        for (String w : builtin) System.out.print(w + ", ");
        System.out.println();
        System.out.println("Arrays are the same: " + same);
    }
}
