public class RecursiveDFSSolution {
    char visitedMark = 'v';

    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
               if (grid[i][j] == '1') {
                   totalIslands++;
                   visitIsland(grid, i, j);
               }
            }
        }
        return totalIslands;
    }

    private void visitIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
           return;
        }
        if (grid[i][j] == '0' || grid[i][j] == visitedMark) {
            return;
        }

        grid[i][j] = visitedMark;
        visitIsland(grid, i + 1, j);
        visitIsland(grid, i - 1, j);
        visitIsland(grid, i, j + 1);
        visitIsland(grid, i, j - 1);
    }

}
