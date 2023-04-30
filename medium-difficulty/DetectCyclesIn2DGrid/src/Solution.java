import java.util.LinkedList;

public class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 'v') {
                    if (visit(grid, i, j, new int[]{i, j}, grid[i][j], 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean visit(char[][] grid, int i, int j, int[] originCharPosition, char originChar, int pathCount) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (pathCount >= 4 && (i == originCharPosition[0] && j == originCharPosition[1])) {
            return true;
        }
        if (grid[i][j] != originChar) {
            return false;
        }

        grid[i][j] = 'v';
        pathCount++;

        return visit(grid, i + 1, j, originCharPosition, originChar, pathCount)
                || visit(grid, i - 1, j, originCharPosition, originChar, pathCount)
                || visit(grid, i, j + 1, originCharPosition, originChar, pathCount)
                || visit(grid, i, j - 1, originCharPosition, originChar, pathCount);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().containsCycle(
//                new char[][]{
//                        {'a', 'a', 'a', 'a'},
//                        {'a', 'b', 'c', 'a'},
//                        {'a', 'b', 'c', 'a'},
//                        {'a', 'a', 'a', 'a'}
//                }));

//        System.out.println(new Solution().containsCycle(
//                new char[][]{
//                        {'c', 'c', 'c', 'a'},
//                        {'c', 'd', 'c', 'c'},
//                        {'c', 'c', 'e', 'c'},
//                        {'f', 'c', 'c', 'c'}
//                }));

        System.out.println(new Solution().containsCycle(
                new char[][]{
                        {'a', 'b', 'b'},
                        {'b', 'z', 'b'},
                        {'b', 'b', 'a'},
                }));
    }
}
