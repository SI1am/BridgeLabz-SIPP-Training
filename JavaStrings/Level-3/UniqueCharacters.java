import java.util.Scanner;

public class UniqueCharacters {
    // Find string length without using length()
    public static int getStringLength(String s) {
        int count = 0;
        try { while (true) { s.charAt(count); count++; } } catch (Exception e) {}
        return count;
    }

    // Find unique characters using charAt()
    public static char[] uniqueCharacters(String s) {
        int len = getStringLength(s);
        char[] unique = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) { isUnique = false; break; }
            }
            if (isUnique) unique[uniqueCount++] = c;
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) result[i] = unique[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        char[] unique = uniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char c : unique) System.out.print(c + " ");
        System.out.println();
    }
}
