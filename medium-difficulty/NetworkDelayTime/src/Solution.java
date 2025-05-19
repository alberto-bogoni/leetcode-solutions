import java.util.*;

public class Solution {
    public int networkDelayTimeBellmanFord(int[][] times, int n, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0] - 1;
                int v = times[j][1] - 1;
                int w = times[j][2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }

        return max;
    }

    public int networkDelayTimeDijkstra(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0],
                    key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(k, 0);
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[0];

            if (curr[1] > distance.getOrDefault(u, Integer.MAX_VALUE)) continue;
            if (visited.contains(u)) continue;
            visited.add(u);

            for (int[] edge : edges.getOrDefault(u, new ArrayList<int[]>())) {
                int v = edge[0];
                int w = edge[1];

                if (distance.getOrDefault(u, Integer.MAX_VALUE) + w < distance.getOrDefault(v, Integer.MAX_VALUE)) {
                    distance.put(v, distance.getOrDefault(u, Integer.MAX_VALUE) + w);
                    minHeap.add(new int[] {v, distance.get(v)});
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (distance.getOrDefault(i + 1, Integer.MAX_VALUE) == Integer.MAX_VALUE) return -1;
            max = Math.max(distance.get(i + 1), max);
        }
        return max;
    }
}