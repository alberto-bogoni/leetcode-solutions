import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs(node, adjList, visited, component);
                if (isComponentComplete(component, adjList)) {
                    completeCount++;
                }
            }
        }
        return completeCount;
    }

    private void dfs(int node, List<Integer>[] adjList, boolean[] visited, List<Integer> component) {
        if (visited[node]) return;
        visited[node] = true;
        component.add(node);
        for (int neighbor : adjList[node]) {
            dfs(neighbor, adjList, visited, component);
        }
    }

    private boolean isComponentComplete(List<Integer> component, List<Integer>[] adjList) {
        int expectedDegree = component.size() - 1;
        for (int node : component) {
            if (adjList[node].size() != expectedDegree) {
                return false;
            }
        }
        return true;
    }
}