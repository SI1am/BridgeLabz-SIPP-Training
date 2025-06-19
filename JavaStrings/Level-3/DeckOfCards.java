import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    // Initialize deck
    public static String[] initializeDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int idx = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[idx++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle deck
    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + rand.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute cards
    public static String[][] distributeCards(String[] deck, int n, int x) {
        if (n > deck.length || n % x != 0) return null;
        String[][] players = new String[x][n / x];
        int idx = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n / x; j++) {
                players[i][j] = deck[idx++];
            }
        }
        return players;
    }

    // Print players and their cards
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i+1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j] + (j < players[i].length-1 ? ", " : ""));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        String[][] players = distributeCards(deck, n, x);
        if (players == null) System.out.println("Cannot distribute cards evenly to players.");
        else printPlayers(players);
    }
}
