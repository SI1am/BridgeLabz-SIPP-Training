import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height (in cm) of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        int youngestIdx = 0;
        double tallestHeight = heights[0];
        int tallestIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIdx]) youngestIdx = i;
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestIdx = i;
            }
        }
        System.out.println("Youngest: " + names[youngestIdx]);
        System.out.println("Tallest: " + names[tallestIdx]);
    }
}
