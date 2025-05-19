import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        for (Integer r : restricted) visited[r] = true;
        if (visited[0]) return 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                if (visited[node]) continue;
                visited[node] = true;
                count++;

                for (Integer e : adj[node]) {
                    if (visited[e]) continue;
                    queue.add(e);
                }
            }
        }

        return count;
    }
}