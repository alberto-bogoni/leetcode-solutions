import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] directions = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                int value = mat[row][col];

                for (int[] dir : directions) {
                    int nextRow = dir[0] + row;
                    int nextCol = dir[1] + col;

                    if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol < mat[0].length) {
                        if (visited[nextRow][nextCol]) continue;

                        result[nextRow][nextCol] = result[row][col] + 1;
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[] {nextRow, nextCol});
                    }
                }
            }
        }

        return result;
    }
}