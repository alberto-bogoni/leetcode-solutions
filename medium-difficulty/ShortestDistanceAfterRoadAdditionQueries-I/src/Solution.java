import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            adj[i].add(i + 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj[u].add(v);

            int shortest = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            boolean[] visited = new boolean[n];
            visited[0] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    int city = queue.poll();

                    if (city == n - 1) {
                        result[i] = shortest;
                        break;
                    }

                    for (Integer e : adj[city]) {
                        if (visited[e]) continue;
                        visited[e] = true;
                        queue.add(e);
                    }
                }
                shortest++;
            }
        }

        return result;
    }
}