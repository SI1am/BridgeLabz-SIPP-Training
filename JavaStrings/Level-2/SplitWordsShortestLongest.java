import java.util.Scanner;

public class SplitWordsShortestLongest {
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

    // Create 2D array of word and its length
    public static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }

    // Find shortest and longest word
    public static int[] findShortestLongest(String[][] wordLen) {
        int minIdx = 0, maxIdx = 0;
        int min = Integer.parseInt(wordLen[0][1]);
        int max = Integer.parseInt(wordLen[0][1]);
        for (int i = 1; i < wordLen.length; i++) {
            int len = Integer.parseInt(wordLen[i][1]);
            if (len < min) {
                min = len;
                minIdx = i;
            }
            if (len > max) {
                max = len;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] wordLen = wordsWithLength(words);
        int[] idx = findShortestLongest(wordLen);
        System.out.println("Word\tLength");
        for (String[] row : wordLen) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
        System.out.println("Shortest word: " + wordLen[idx[0]][0]);
        System.out.println("Longest word: " + wordLen[idx[1]][0]);
    }
}
