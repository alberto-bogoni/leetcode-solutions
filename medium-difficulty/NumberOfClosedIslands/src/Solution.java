/*
    Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s
    and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

    Return the number of closed islands.
*/

public class Solution {
    public int closedIsland(int[][] grid) {
        int numberOfClosedIslands = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    if (isClosedIsland(grid, i, j)) {
                        numberOfClosedIslands++;
                    }
                }
            }
        }

        return numberOfClosedIslands;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1 || grid[i][j] == -1) {
            return true;
        }

        grid[i][j] = -1;

        boolean isClosed = true;

        isClosed &= isClosedIsland(grid,i + 1, j);
        isClosed &= isClosedIsland(grid,i - 1, j);
        isClosed &= isClosedIsland(grid, i, j + 1);
        isClosed &= isClosedIsland(grid, i, j - 1);

        return isClosed;
    }
}
