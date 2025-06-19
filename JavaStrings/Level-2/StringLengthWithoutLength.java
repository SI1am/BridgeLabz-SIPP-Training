import java.util.Scanner;

public class StringLengthWithoutLength {
    // Find string length without using length()
    public static int getStringLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        int manualLength = getStringLength(text);
        int builtinLength = text.length();
        System.out.println("Manual length: " + manualLength);
        System.out.println("Built-in length: " + builtinLength);
    }
}
