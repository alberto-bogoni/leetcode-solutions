import java.util.*;

public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{i, 0});

            boolean[] visited = new boolean[n];

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int u = curr[0], d = curr[1];
                if (visited[u]) continue;
                visited[u] = true;
                if (d > distanceThreshold) break;

                for (int[] edge : adj[u]) {
                    int v = edge[0], w = edge[1];
                    if (dist[v] > d + w) {
                        dist[v] = d + w;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) {
                    count++;
                }
            }
            counts[i] = count;
        }

        int minCount = Integer.MAX_VALUE, result = -1;
        for (int i = 0; i < n; i++) {
            if (counts[i] < minCount || (counts[i] == minCount && i > result)) {
                minCount = counts[i];
                result = i;
            }
        }
        return result;
    }
}