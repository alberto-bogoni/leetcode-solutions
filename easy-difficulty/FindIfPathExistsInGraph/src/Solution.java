import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        if (edges == null || edges.length == 0)
            return false;
        LinkedList<Integer>[] adjacencyList = new LinkedList[n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (adjacencyList[u] == null)
                adjacencyList[u] = new LinkedList<>();
            if (adjacencyList[v] == null)
                adjacencyList[v] = new LinkedList<>();

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        boolean[] visited = new boolean[n];
        return dfsRecursive(visited, adjacencyList, source, destination);
        // return dfs(adjacencyList, source, destination);
    }

    private boolean dfsRecursive(boolean[] visited, LinkedList<Integer>[] adjacencyList, int source, int destination) {
        if (source == destination)
            return true;
        visited[source] = true;

        for (Integer i : adjacencyList[source]) {
            if (!visited[i] && dfsRecursive(visited, adjacencyList, i, destination))
                return true;
        }

        return false;
    }

    private boolean dfs(LinkedList<Integer>[] adjacencyList, int source, int destination) {
        boolean[] visited = new boolean[adjacencyList.length];
        Stack<Integer> stack = new Stack<>();

        stack.add(source);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            visited[v] = true;

            if (v == destination)
                return true;

            for (Integer i : adjacencyList[v]) {
                if (!visited[i])
                    stack.add(i);
            }
        }

        return false;
    }
}