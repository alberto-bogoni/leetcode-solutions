import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] parent;
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            union(u, v);
        }

        Map<Integer, Integer> componentSizes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            componentSizes.put(root, componentSizes.getOrDefault(root, 0) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        long sameComponentPairs = 0;
        for (int size : componentSizes.values()) {
            sameComponentPairs += (long) size * (size - 1) / 2;
        }

        return totalPairs - sameComponentPairs;
    }

    public void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) return;
        else {
            parent[p1] = p2;
        }
    }

    public int find(int node) {
        if (parent[node] == node) return node;

        int result = find(parent[node]);
        parent[node] = result;
        return result;
    }
}