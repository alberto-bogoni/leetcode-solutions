import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] directions = new int[][] {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int elapsed = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            elapsed++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                    if (visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0) continue;

                    grid[nextRow][nextCol] = 2;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                    fresh--;
                }
            }
        }

        return fresh == 0 ? Math.max(0, elapsed - 1) : -1;
    }
}