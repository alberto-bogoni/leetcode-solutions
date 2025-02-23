import java.util.PriorityQueue;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap =
                new PriorityQueue<>(n, (i1, i2) -> intervals[i2][0] - intervals[i1][0]);
        // heap for finding the minimum end
        PriorityQueue<Integer> maxEndHeap =
                new PriorityQueue<>(n, (i1, i2) -> intervals[i2][1] - intervals[i1][1]);
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            // let's find the next interval of the interval which has the highest 'end'
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
                int topStart = maxStartHeap.poll();
                // find the the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty()
                        && intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                // put the interval back as it could be the next interval of other intervals
                maxStartHeap.add(topStart);
            }
        }
        return result;
    }
}