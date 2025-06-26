import java.util.*;

public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> distances1 = new HashMap<>();
        Map<Integer, Integer> distances2 = new HashMap<>();

        bfs(node1, edges, distances1);
        bfs(node2, edges, distances2);

        int minDistance = Integer.MAX_VALUE;
        int result = -1;

        for (int node : distances1.keySet()) {
            if (distances2.containsKey(node)) {
                int maxDist = Math.max(distances1.get(node), distances2.get(node));
                if (maxDist < minDistance || (maxDist == minDistance && node < result)) {
                    minDistance = maxDist;
                    result = node;
                }
            }
        }

        return result;
    }

    public void bfs(int startNode, int[] edges, Map<Integer, Integer> distances) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        distances.put(startNode, 0);
        visited.add(startNode);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                if (edges[node] != -1 && !visited.contains(edges[node])) {
                    int nextNode = edges[node];
                    queue.add(nextNode);
                    distances.put(nextNode, distance + 1);
                    visited.add(nextNode);
                }
            }
            distance++;
        }
    }
}