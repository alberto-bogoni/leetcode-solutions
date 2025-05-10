import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] directions = new int[][] {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] result = new int[isWater.length][isWater[0].length];
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int nr = dir[0] + row;
                    int nc = dir[1] + col;

                    if (nr < 0 || nc < 0 || nr >= isWater.length || nc >= isWater[0].length) continue;
                    if (visited[nr][nc]) continue;

                    result[nr][nc] = result[row][col] + 1;
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }

        return result;
    }
}