import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) adj[i] = new HashSet<>();
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> adjU = adj[i];
                Set<Integer> adjV = adj[j];

                int total = adjU.size() + adjV.size();
                if (adjU.contains(j) || adjV.contains(i)) total -= 1;

                max = Math.max(total, max);
            }
        }

        return max;
    }
}