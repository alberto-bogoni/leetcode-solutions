public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)// base case
            return 0;

        int perimeter = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    perimeter += calculatePerimeter(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    private int calculatePerimeter(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
           return 0;
        }

        grid[i][j] = -1;

        int perimeter = 0;
        perimeter += calculatePerimeter(grid, i + 1, j);
        perimeter += calculatePerimeter(grid, i - 1, j);
        perimeter += calculatePerimeter(grid, i, j + 1);
        perimeter += calculatePerimeter(grid, i, j - 1);

        return perimeter;
    }
}
