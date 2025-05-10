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

    public int findCircleNumDSU(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        int[] rank = new int[isConnected.length];

        int result = isConnected.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int provinces = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    if (union(i, j, parent, rank)) provinces--;
                }
            }
        }

        return provinces;
    }

    public int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }

        int result = find(parent[i], parent);
        parent[i] = result;
        return result;
    }

    public boolean union(int i, int j, int[] parent, int[] rank) {
        int pi = find(i, parent);
        int pj = find(j, parent);

        if (pi == pj) return false;

        if (rank[pi] < rank[pj]) {
            parent[pi] = pj;
        } else if (rank[pj] < rank[pi]) {
            parent[pj] = pi;
        } else {
            parent[pj] = pi;
            rank[pi]++;
        }

        return true;
    }
}