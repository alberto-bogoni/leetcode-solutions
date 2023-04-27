import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BFSSolution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int totalIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    totalIslands++;
                    visitIslandBFS(grid, i, j);
                }
            }
        }

        return totalIslands;
    }

    private static void visitIslandBFS(char[][] matrix, int x, int y) {
        Queue<int[]> neighbors = new LinkedList<>();
        neighbors.add(new int[] { x, y });
        while (!neighbors.isEmpty()) {
            int row = neighbors.peek()[0];
            int col = neighbors.peek()[1];
            neighbors.remove();

            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
                continue;
            if (matrix[row][col] == 0)
                continue;

            matrix[row][col] = 0;

            neighbors.add(new int[] { row + 1, col }); // lower cell
            neighbors.add(new int[] { row - 1, col }); // upper cell
            neighbors.add(new int[] { row, col + 1 }); // right cell
            neighbors.add(new int[] { row, col - 1 }); // left cell
        }
    }
}
