import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] origin = new int[]{0,0};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
                (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        List<int[]> result = new LinkedList<>();

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }

        int count = 0;
        while (count < k) {
            result.add(queue.poll());
            count++;
        }
        return result.toArray(new int[result.size()][]);
    }
}