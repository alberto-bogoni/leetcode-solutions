public class Solution {
    public boolean canAttendAllAppointments(int[][] intervals) {
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            if (overlap(currentInterval, nextInterval)) {
                return false;
            } else {
                currentInterval = nextInterval;
            }
        }

        return true;
    }

    private boolean overlap(int[] firstInterval, int[] secondInterval) {
        int start = Math.max(firstInterval[0], secondInterval[0]);
        int end = Math.min(firstInterval[1], secondInterval[1])

        return (end - start) >= 0;
    }
}
