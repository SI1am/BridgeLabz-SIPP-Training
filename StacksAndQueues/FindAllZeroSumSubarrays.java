package StacksAndQueues;

import java.util.*;

public class FindAllZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }
}
