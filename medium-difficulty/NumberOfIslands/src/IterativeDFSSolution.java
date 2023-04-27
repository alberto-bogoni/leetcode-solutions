import java.util.Stack;

/*
    Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of
    islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
    all four edges of the grid are all surrounded by water.
*/

public class IterativeDFSSolution {
    private char visitedMark = 'v';

    public int numIslands(char[][] grid) {
       int rows = grid.length;
       int columns = grid[0].length;

       int totalIslands = 0;

       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < columns; j++) {
              if (grid[i][j] == '1') {
                  totalIslands++;
                  Stack<int []> visitedNodes = new Stack<>();
                  visitedNodes.push(new int[]{ i, j });
                  visitIsland(visitedNodes, grid);
              }
           }
       }

        return totalIslands;
    }

    private void visitIsland(Stack<int []> visitedNodes, char[][] grid) {
        while (!visitedNodes.isEmpty()) {
            int [] nodeCoordinate = visitedNodes.pop();
            int row = nodeCoordinate[0];
            int column = nodeCoordinate[1];
            grid[row][column] = visitedMark;

            if (row < grid.length - 1 && (grid[row + 1][column] == '1')) {
                visitedNodes.push(new int[] {row + 1, column});
            }
            if (row > 0 && grid[row - 1][column] == '1') {
                visitedNodes.push(new int[] {row - 1, column});
            }
            if (column < grid[0].length - 1 && grid[row][column + 1] == '1') {
                visitedNodes.push(new int[] {row, column + 1});
            }
            if (column > 0 && grid[row][column - 1] == '1') {
                visitedNodes.push(new int[] {row, column - 1});
            }
        }
    }

}
