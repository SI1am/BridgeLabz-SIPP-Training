import java.util.Scanner;

public class VowelConsonantCount {
    // Check if character is vowel, consonant, or not a letter
    public static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32); // to lowercase
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    // Count vowels and consonants
    public static int[] countVowelsConsonants(String s) {
        int vowels = 0, consonants = 0;
        for (int i = 0; ; i++) {
            try {
                char c = s.charAt(i);
                String type = charType(c);
                if (type.equals("Vowel")) vowels++;
                else if (type.equals("Consonant")) consonants++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        int[] counts = countVowelsConsonants(text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}
