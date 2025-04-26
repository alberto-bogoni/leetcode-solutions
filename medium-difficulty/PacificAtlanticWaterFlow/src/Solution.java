import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0) return new ArrayList<>();

        int m = heights.length, n = heights[0].length;
        boolean[][] po = new boolean[m][n];
        boolean[][] ao = new boolean[m][n];

        // DFS from Pacific border (top and left)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, po, heights[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, po, heights[0][j]);
        }

        // DFS from Atlantic border (bottom and right)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n-1, ao, heights[i][n-1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m-1, j, ao, heights[m-1][j]);
        }

        // Collect results
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (po[i][j] && ao[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] h, int i, int j, boolean[][] visited, int prevHeight) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length ||
                visited[i][j] || h[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;

        dfs(h, i+1, j, visited, h[i][j]);
        dfs(h, i-1, j, visited, h[i][j]);
        dfs(h, i, j+1, visited, h[i][j]);
        dfs(h, i, j-1, visited, h[i][j]);
    }
}