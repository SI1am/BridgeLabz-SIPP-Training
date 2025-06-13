import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();
        if (number < 1 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
            return;
        }
        int counter = 100;
        System.out.print("Multiples: ");
        while (counter >= 1) {
            if (counter % number == 0) {
                System.out.print(counter + " ");
            }
            counter--;
        }
        System.out.println();
    }
}
