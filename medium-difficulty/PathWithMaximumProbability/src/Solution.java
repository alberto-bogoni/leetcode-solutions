import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Build adjacency list
        Map<Integer, List<double[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new double[]{v, prob});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new double[]{u, prob});
        }

        double[] probs = new double[n];
        probs[start] = 1.0;

        // Max-heap based on probability (descending order)
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double prob = curr[1];

            // Early exit if the end node is reached with the highest possible probability
            if (node == end) {
                return prob;
            }

            // Skip processing if a higher probability path to this node has already been found
            if (prob < probs[node]) {
                continue;
            }

            // Explore all neighbors
            for (double[] neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                int nextNode = (int) neighbor[0];
                double nextProb = prob * neighbor[1];

                // Update and enqueue only if a higher probability path is found
                if (nextProb > probs[nextNode]) {
                    probs[nextNode] = nextProb;
                    pq.offer(new double[]{nextNode, nextProb});
                }
            }
        }

        // If end node is unreachable, return 0.0
        return probs[end];
    }
}