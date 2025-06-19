import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    
    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]);
    }

    
    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            arr[i] = sc.next();
        }
        // Uncomment to see the exception
        // generateException(arr);
        handleException(arr);
    }
}
