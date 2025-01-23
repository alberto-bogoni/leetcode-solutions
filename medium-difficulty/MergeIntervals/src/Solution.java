import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentInterval = intervals[0];
        List<int[]> mergedIntervals = new LinkedList<>();
        int position = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (nextInterval[0] <= currentInterval[currentInterval.length-1]) {
                currentInterval[currentInterval.length-1] = Math.max(
                        nextInterval[nextInterval.length-1],
                        currentInterval[currentInterval.length-1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
