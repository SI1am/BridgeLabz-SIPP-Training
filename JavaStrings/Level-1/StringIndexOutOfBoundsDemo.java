import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {


    public static void generateException(String text) {
        // Accessing index beyond length
        System.out.println(text.charAt(text.length()));
    }

    
    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        // generateException(text);
        handleException(text);
    }
}
