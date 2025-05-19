import java.util.ArrayList;

class Solution {
    int min = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0] - 1;
            int v = roads[i][1] - 1;
            int dist = roads[i][2];

            adj[u].add(new int[] {v,dist});
            adj[v].add(new int[] {u,dist});
        }

        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0);
        return min;
    }

    public void dfs(ArrayList<int[]>[] adj, boolean[] visited, int city) {
        if (visited[city]) return;

        visited[city] = true;

        for (int[] e : adj[city]) {
            min = Math.min(min, e[1]);
            dfs(adj, visited, e[0]);
        }
    }
}