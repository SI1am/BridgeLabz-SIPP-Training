import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        if (number < 1) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        int i = 1;
        System.out.print("Factors: ");
        while (i < number) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();
    }
}
