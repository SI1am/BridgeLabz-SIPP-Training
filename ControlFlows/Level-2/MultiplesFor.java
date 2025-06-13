import java.util.Scanner;

public class MultiplesFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();
        if (number < 1 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
            return;
        }
        System.out.print("Multiples: ");
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
