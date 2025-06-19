import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsStats {
    static String[] choices = {"rock", "paper", "scissors"};

    // Get computer choice
    public static String getComputerChoice() {
        Random rand = new Random();
        return choices[rand.nextInt(3)];
    }

    // Find winner: 0 = tie, 1 = player, 2 = computer
    public static int findWinner(String player, String computer) {
        if (player.equals(computer)) return 0;
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) return 1;
        return 2;
    }

    // Calculate stats
    public static String[][] calculateStats(int playerWins, int computerWins, int games) {
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[1][0] = "Computer";
        stats[0][1] = String.valueOf(playerWins);
        stats[1][1] = String.valueOf(computerWins);
        stats[0][2] = String.format("%.2f", (playerWins * 100.0 / games)) + "%";
        stats[1][2] = String.format("%.2f", (computerWins * 100.0 / games)) + "%";
        return stats;
    }

    // Display results
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("Game\tPlayer\tComputer\tWinner");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i+1) + "\t" + gameResults[i][0] + "\t" + gameResults[i][1] + "\t" + gameResults[i][2]);
        }
        System.out.println("\nStats:");
        System.out.println("Name\tWins\tWin %");
        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();
        String[][] gameResults = new String[games][3];
        int playerWins = 0, computerWins = 0;
        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String player = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            int winner = findWinner(player, computer);
            String winnerStr = (winner == 0) ? "Tie" : (winner == 1 ? "Player" : "Computer");
            if (winner == 1) playerWins++;
            else if (winner == 2) computerWins++;
            gameResults[i][0] = player;
            gameResults[i][1] = computer;
            gameResults[i][2] = winnerStr;
        }
        String[][] stats = calculateStats(playerWins, computerWins, games);
        displayResults(gameResults, stats);
    }
}
