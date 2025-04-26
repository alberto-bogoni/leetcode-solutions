import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree on n nodes must have exactly n-1 edges
        if (edges.length != n - 1) return false;

        // build undirected adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // visited array to check both cycle and connectivity
        boolean[] visited = new boolean[n];

        // if there's a cycle, it's not a tree
        if (hasCycle(adj, 0, visited, -1)) return false;

        // check connectivity: every node must be visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] adj,
                             int node,
                             boolean[] visited,
                             int parent) {
        visited[node] = true;
        for (int nei : adj[node]) {
            if (!visited[nei]) {
                if (hasCycle(adj, nei, visited, node)) return true;
            } else if (nei != parent) {
                // visited neighbor that's *not* the parent → cycle
                return true;
            }
        }
        return false;
    }}