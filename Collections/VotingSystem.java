package Collections;
import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }

    public void displayResultsSorted() {
        TreeMap<String, Integer> sorted = new TreeMap<>(voteMap);
        System.out.println("Results (sorted):");
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayVoteOrder() {
        System.out.println("Vote order:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.vote("Alice");
        vs.vote("Bob");
        vs.vote("Alice");
        vs.vote("Charlie");
        vs.vote("Bob");
        vs.vote("Alice");
        vs.displayResultsSorted();
        vs.displayVoteOrder();
    }
}
