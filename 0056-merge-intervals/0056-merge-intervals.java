import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Handle empty or single interval edge cases
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals by their start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        
        // Initialize our tracking interval with the first element
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            // 2. Check for overlapping intervals
            if (nextStart <= currentEnd) {
                // Merge intervals by updating the end of the tracking interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // 3. Move tracker to the non-overlapping interval and add it to the list
                currentInterval = nextInterval;
                mergedList.add(currentInterval);
            }
        }

        // 4. Convert the list back to a 2D primitive array
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
