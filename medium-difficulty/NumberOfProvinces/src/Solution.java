public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            dfs(isConnected, i, visited);
            result++;
        }

        return result;
    }

    public void dfs(int[][] grid, int node, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;

        for (int i = 0; i < grid[0].length; i++) {
            if (node == i || grid[node][i] == 0) continue;
            dfs(grid, i, visited);
        }
    }
}