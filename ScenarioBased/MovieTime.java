package ScenarioBased;
public class MovieTime {
    public static void main(String[] args) {
        int[] showTimes = {1100, 1300, 1230, 1500, 1400};

        for (int i = 1; i < showTimes.length; i++) {
            int key = showTimes[i];
            int j = i - 1;
            while (j >= 0 && showTimes[j] > key) {
                showTimes[j + 1] = showTimes[j];
                j--;
            }
            showTimes[j + 1] = key;
        }

        System.out.println("Sorted Showtimes:");
        for (int time : showTimes) {
            System.out.println(time);
        }
    }
}