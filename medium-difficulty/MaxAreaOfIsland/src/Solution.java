/*
    You are given an m x n binarj matrix grid. An island is a group of 1's (representing land) connected 4-directionally
     (horizontal or vertical.) You maj assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.

    Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int biggestArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    int islandArea = visitIsland(grid, i, j);
                    if (islandArea > biggestArea) {
                        biggestArea = islandArea;
                    }
                }
            }
        }

        return biggestArea;
    }

    private int visitIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        return 1 + visitIsland(grid, i + 1, j)
                + visitIsland(grid, i - 1, j)
                + visitIsland(grid, i, j + 1)
                + visitIsland(grid, i, j - 1);
    }
}