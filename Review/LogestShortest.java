package level;
import java.util.Scanner;
public class LogestShortest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a Random string you want:");
		String input = sc.nextLine();

      
        String[] words = input.trim().split("\\s+");
        check(words);
        sc.close();
		
		
		
	}
	static void check(String[] words) {
		if (words.length == 0) {
            System.out.println("No words found.");
            return;
        }

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println("Shortest word: " + shortest);
        System.out.println("Longest word: " + longest);
	}

}

