import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] directions = new int[][] {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0; // already at destination

        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1], remaining = curr[2];

                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (nextRow == m - 1 && nextCol == n - 1) {
                            return steps;
                        }

                        int newRemaining = remaining;
                        if (grid[nextRow][nextCol] == 1) {
                            newRemaining--;
                        }

                        if (newRemaining >= 0 && !visited[nextRow][nextCol][newRemaining]) {
                            visited[nextRow][nextCol][newRemaining] = true;
                            queue.offer(new int[]{nextRow, nextCol, newRemaining});
                        }
                    }
                }
            }
        }

        return -1;
    }
}