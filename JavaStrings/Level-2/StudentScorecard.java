import java.util.Random;

public class StudentScorecard {
    // Generate random 2-digit PCM scores for n students
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(90); // 2-digit score
            }
        }
        return scores;
    }

    // Calculate total, average, percentage
    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100.0;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return stats;
    }

    // Calculate grade based on percentage
    public static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double percent = stats[i][2];
            if (percent >= 90) grades[i] = "A+";
            else if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B+";
            else if (percent >= 60) grades[i] = "B";
            else if (percent >= 50) grades[i] = "C";
            else if (percent >= 40) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    // Display scorecard
    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\t%\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i+1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" + (int)stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayScorecard(scores, stats, grades);
    }
}
