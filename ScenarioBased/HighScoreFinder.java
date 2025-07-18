package ScenarioBased;
import java.util.*;

public class HighScoreFinder {
    ArrayList<Integer> scores = new ArrayList<>();

    public void addScores(List<Integer> newScores) {
        scores.addAll(newScores);
        scores.sort(Collections.reverseOrder());
        if (scores.size() > 100) {
            scores = new ArrayList<>(scores.subList(0, 100));
        }
    }

    public void checkScore(int score) {
        int index = Collections.binarySearch(scores, score, Comparator.reverseOrder());
        if (index >= 0) {
            System.out.println("Your rank is: " + (index + 1));
        } else if (scores.size() < 100) {
            System.out.println("You're in! Rank: " + (-index));
        } else {
            int needed = scores.get(99) - score + 1;
            System.out.println("Not in top 100. Need " + needed + " more points.");
        }
    }

    public static void main(String[] args) {
        HighScoreFinder hsf = new HighScoreFinder();
        hsf.addScores(Arrays.asList(980, 970, 960, 950, 940, 930));
        hsf.checkScore(960);
        hsf.checkScore(920);
    }
}