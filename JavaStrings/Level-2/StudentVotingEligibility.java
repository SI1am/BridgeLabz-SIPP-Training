import java.util.Random;

public class StudentVotingEligibility {
    // Generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90); // 2-digit age
        }
        return ages;
    }

    // Return 2D array of age and voting eligibility
    public static String[][] votingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) result[i][1] = "false";
            else result[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return result;
    }

    // Display 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] ages = generateAges(n);
        String[][] table = votingEligibility(ages);
        displayTable(table);
    }
}
