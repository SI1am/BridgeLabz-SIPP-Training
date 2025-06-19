import java.util.Scanner;

public class CharFrequencyUnique {
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

    // Find frequency of characters using unique characters
    public static String[][] charFrequencyUnique(String s) {
        char[] unique = uniqueCharacters(s);
        int[] freq = new int[unique.length];
        int len = getStringLength(s);
        for (int i = 0; i < unique.length; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == unique[i]) freq[i]++;
            }
        }
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String[][] freqArr = charFrequencyUnique(text);
        System.out.println("Char\tFreq");
        for (String[] row : freqArr) System.out.println(row[0] + "\t" + row[1]);
    }
}
