import java.util.PriorityQueue;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[] {0, 0, 0});
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] directions = new int[][] {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[0];
            int j = curr[1];
            int val = heights[i][j];
            int max = curr[2];

            if (i == heights.length - 1 && j == heights[0].length - 1) {
                return max;
            }

            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (int[] dir : directions) {
                int nextRow = i + dir[0];
                int nextCol = j + dir[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= heights.length || nextCol >= heights[0].length) continue;
                int newMax = Math.max(max, Math.abs(heights[nextRow][nextCol] - heights[i][j]));
                minHeap.add(new int[] {nextRow, nextCol, newMax});
            }
        }

        return -1;
    }
}