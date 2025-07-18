package ScenarioBased;
import java.util.*;

public class SeatChecker {
    ArrayList<ArrayList<Integer>> halls = new ArrayList<>();

    public void addHall(List<Integer> seats) {
        Collections.sort(seats);
        halls.add(new ArrayList<>(seats));
    }

    public void findSeat(int seatNumber) {
        for (int i = 0; i < halls.size(); i++) {
            List<Integer> hall = halls.get(i);
            int index = Collections.binarySearch(hall, seatNumber);
            if (index >= 0) {
                System.out.println("Seat found in Hall " + i + " at position " + index);
                return;
            } else {
                int insertPos = -index - 1;
                int suggestion = (insertPos < hall.size()) ? hall.get(insertPos) : hall.get(hall.size() - 1);
                System.out.println("Seat not found. Nearest in Hall " + i + ": " + suggestion);
            }
        }
    }

    public static void main(String[] args) {
        SeatChecker sc = new SeatChecker();
        sc.addHall(Arrays.asList(101, 102, 103, 104));
        sc.addHall(Arrays.asList(201, 202, 203, 204));
        sc.findSeat(103);
        sc.findSeat(105);
    }
}