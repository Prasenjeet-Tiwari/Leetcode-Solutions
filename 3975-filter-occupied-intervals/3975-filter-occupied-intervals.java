import java.util.*;

class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {

        List<List<Integer>> result = new ArrayList<>();

        if (occupiedIntervals == null || occupiedIntervals.length == 0) {
            return result;
        }

        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        int currentStart = occupiedIntervals[0][0];
        int currentEnd = occupiedIntervals[0][1];

        for (int i = 1; i < occupiedIntervals.length; i++) {

            int nextStart = occupiedIntervals[i][0];
            int nextEnd = occupiedIntervals[i][1];

            // Merge overlapping OR touching intervals
            if ((long) nextStart <= (long) currentEnd + 1) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                processAndAddInterval(currentStart, currentEnd, freeStart, freeEnd, result);
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        processAndAddInterval(currentStart, currentEnd, freeStart, freeEnd, result);

        return result;
    }

    private void processAndAddInterval(int start, int end, int freeStart, int freeEnd,
                                       List<List<Integer>> result) {

        // Completely removed
        if (start >= freeStart && end <= freeEnd) {
            return;
        }

        // Free interval lies inside occupied interval
        if (start < freeStart && end > freeEnd) {
            result.add(Arrays.asList(start, freeStart - 1));
            result.add(Arrays.asList(freeEnd + 1, end));
        }
        // Overlaps left boundary of free interval
        else if (start < freeStart && end >= freeStart) {
            result.add(Arrays.asList(start, freeStart - 1));
        }
        // Overlaps right boundary of free interval
        else if (start <= freeEnd && end > freeEnd) {
            result.add(Arrays.asList(freeEnd + 1, end));
        }
        // No overlap
        else {
            result.add(Arrays.asList(start, end));
        }
    }
}