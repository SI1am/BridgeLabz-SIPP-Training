import java.util.Scanner;

public class VowelConsonantTypeTable {
    // Check if character is vowel, consonant, or not a letter
    public static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32); // to lowercase
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    // Return 2D array of char and type
    public static String[][] charTypeTable(String s) {
        int len = 0;
        try {
            while (true) { s.charAt(len); len++; }
        } catch (IndexOutOfBoundsException e) {}
        String[][] table = new String[len][2];
        for (int i = 0; i < len; i++) {
            table[i][0] = String.valueOf(s.charAt(i));
            table[i][1] = charType(s.charAt(i));
        }
        return table;
    }

    // Display 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("Char\tType");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String[][] table = charTypeTable(text);
        displayTable(table);
    }
}
