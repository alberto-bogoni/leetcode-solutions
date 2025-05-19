import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[] {j, distance});
                adj.get(j).add(new int[] {i, distance});
            }
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] {0,0});
        int cost = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int pIndex = curr[0];
            int[] point = points[pIndex];
            int dist = curr[1];

            if (visited[pIndex]) continue;
            visited[pIndex] = true;
            cost += dist;

            for (int[] e : adj.get(pIndex)) {
                if (visited[e[0]]) continue;
                minHeap.add(new int[] {e[0], e[1]});
            }
        }

        return cost;
    }
}