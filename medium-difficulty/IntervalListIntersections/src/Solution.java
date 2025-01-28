import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int[0][0];

        List<int[]> intersections = new LinkedList<>();

        int left = 0;
        int right = 0;
        while (left < firstList.length && right < secondList.length) {
            int[] firstInterval = firstList[left];
            int[] secondInterval = secondList[right];

            if (overlap(firstInterval, secondInterval)) {
                int[] newInterval = new int[] {
                        Math.max(firstInterval[0], secondInterval[0]),
                        Math.min(firstInterval[1], secondInterval[1])
                };
                intersections.add(newInterval);
            }

            if (firstInterval[1] < secondInterval[1])
                left++;
            else
                right++;
        }

        return intersections.toArray(new int[intersections.size()][]);
    }

    private boolean overlap(int[] firstInterval, int[] secondInterval) {
        int start = Math.max(firstInterval[0], secondInterval[0]);
        int end = Math.min(firstInterval[1], secondInterval[1]);

        return (end - start) >= 0;
    }

}
