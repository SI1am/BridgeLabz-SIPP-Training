package ScenarioBased;
import java.time.LocalDate;
import java.util.*;

public class MoodTracker {
    HashMap<LocalDate, List<String>> moodMap = new HashMap<>();

    public void logMood(LocalDate date, String mood) {
        moodMap.putIfAbsent(date, new ArrayList<>());
        moodMap.get(date).add(mood.toLowerCase());
    }

    public void searchMood(String mood) {
        int count = 0;
        List<LocalDate> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 30; i++) {
            LocalDate date = today.minusDays(i);
            List<String> moods = moodMap.getOrDefault(date, new ArrayList<>());
            for (String m : moods) {
                if (m.equalsIgnoreCase(mood)) {
                    count++;
                    dates.add(date);
                }
            }
        }
        System.out.println("Mood '" + mood + "' occurred " + count + " times.");
        System.out.println("Dates: " + dates);
    }

    public static void main(String[] args) {
        MoodTracker mt = new MoodTracker();
        mt.logMood(LocalDate.now().minusDays(1), "happy");
        mt.logMood(LocalDate.now().minusDays(2), "sad");
        mt.logMood(LocalDate.now().minusDays(3), "happy");
        mt.searchMood("happy");
    }
}