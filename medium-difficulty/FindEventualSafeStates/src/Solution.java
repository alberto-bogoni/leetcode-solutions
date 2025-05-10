import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, state)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1;

        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, state)) {
                return false;
            }
        }

        state[node] = 2;
        return true;
    }
}