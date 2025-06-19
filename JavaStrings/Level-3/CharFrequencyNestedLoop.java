import java.util.Scanner;

public class CharFrequencyNestedLoop {
    // Find frequency of characters using nested loops
    public static String[][] charFrequency(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] freq = new int[len];
        for (int i = 0; i < len; i++) {
            freq[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    freq[i] = 0;
                    break;
                }
            }
            if (freq[i] != 0) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] == arr[j]) {
                        freq[i]++;
                        arr[j] = '0';
                    }
                }
            }
        }
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) if (arr[i] != '0') uniqueCount++;
        String[][] result = new String[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] != '0') {
                result[idx][0] = String.valueOf(arr[i]);
                result[idx][1] = String.valueOf(freq[i]);
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
