import java.util.Scanner;

public class MostFrequentCharacter {
    public static char mostFrequent(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        int max = 0;
        char res = '\0';
        for (char c : s.toCharArray()) {
            if (freq[c] > max) {
                max = freq[c];
                res = c;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("Most Frequent Character: '" + mostFrequent(s) + "'");
    }
}
