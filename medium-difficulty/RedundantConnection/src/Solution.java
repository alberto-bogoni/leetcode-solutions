import java.util.*;

public class Solution {
    public int[] findRedundantConnectionDFSClassic(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] result = null;

        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            List<Integer> listV = adjList.getOrDefault(v, new ArrayList<Integer>());
            listV.add(u);
            adjList.put(v, listV);
            List<Integer> listU = adjList.getOrDefault(u, new ArrayList<Integer>());
            listU.add(v);
            adjList.put(u, listU);

            Set<Integer> visited = new HashSet<>();
            if (hasCycle(adjList, v, visited, -1)) {
                result = edges[i];
                break;
            }
        }

        return result;
    }

    public boolean hasCycle(Map<Integer, List<Integer>> adjList, int node, Set<Integer> visited, int parent) {
        if (visited.contains(node)) return true;

        visited.add(node);

        List<Integer> neis = adjList.get(node);
        for (Integer nei : neis) {
            if (nei != parent && hasCycle(adjList, nei, visited, node)) return true;
        }

        return false;
    }

    public int[] findRedundantConnectionDSU(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1], parent, rank)) return edges[i];
        }

        return new int[0];
    }

    public int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }

        int result = find(parent[i], parent);
        parent[i] = result;
        return result;
    }

    public boolean union(int i, int j, int[] parent, int[] rank) {
        int pi = find(i, parent);
        int pj = find(j, parent);

        if (pi == pj) return true;

        if (rank[pi] < rank[pj]) {
            // pi --> pj
            parent[pi] = pj;
        } else if (rank[pj] < rank[pi]) {
            // pj --> pi
            parent[pj] = pi;
        } else {
            parent[pj] = pi;
            rank[pi]++;
        }

        return false;
    }
}