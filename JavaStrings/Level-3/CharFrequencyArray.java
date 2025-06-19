import java.util.Scanner;

public class CharFrequencyArray {
    // Find frequency of characters using charAt()
    public static String[][] charFrequency(String s) {
        int[] freq = new int[256];
        int len = 0;
        try { while (true) { s.charAt(len); len++; } } catch (Exception e) {}
        for (int i = 0; i < len; i++) freq[s.charAt(i)]++;
        boolean[] counted = new boolean[256];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) if (!counted[s.charAt(i)]) { counted[s.charAt(i)] = true; uniqueCount++; }
        String[][] result = new String[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (freq[c] > 0) {
                result[idx][0] = String.valueOf(c);
                result[idx][1] = String.valueOf(freq[c]);
                freq[c] = 0;
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String[][] freqArr = charFrequency(text);
        System.out.println("Char\tFreq");
        for (String[] row : freqArr) System.out.println(row[0] + "\t" + row[1]);
    }
}
