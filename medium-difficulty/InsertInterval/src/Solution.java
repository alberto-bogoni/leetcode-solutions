import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> mergedIntervals = new LinkedList<>();

        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            mergedIntervals.add(intervals[i++]);
        }

        int[] currentInterval = newInterval;
        for (int c = i; c < intervals.length; c++) {
            int[] nextInterval = intervals[c];

            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[0] = Math.min(currentInterval[0], nextInterval[0]);
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
