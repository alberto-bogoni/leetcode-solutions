import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int[][] directions = new int[][] {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[] {0,0, grid[0][0]});

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int row = curr[0];
            int col = curr[1];
            int el = grid[row][col];
            int maxEl = curr[2];

            if (row == grid.length - 1 && col == grid[0].length - 1)
                return Math.max(maxEl, el);
            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir : directions) {
                int nextRow = dir[0] + row;
                int nextCol = dir[1] + col;

                if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                int newMaxEl = Math.max(grid[nextRow][nextCol], maxEl);
                minHeap.add(new int[] {nextRow, nextCol, newMaxEl});
            }
        }

        return -1;
    }
}