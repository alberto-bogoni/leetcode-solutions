import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        if (numCourses == 0) return new int[0];
        else if (prereq.length == 0) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        int[] result = new int[numCourses];
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<Integer>();
        for (int i = 0; i < prereq.length; i++) {
            int v = prereq[i][0];
            int u = prereq[i][1];

            adjList[v].add(u);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) continue;
            if (dfs(adjList, i, visited, path, stack)) return new int[0];
        }

        if (stack.size() != numCourses) return new int[1];
        while (!stack.isEmpty()) {
            result[stack.size() - 1] = stack.pop();
        }

        return result;
    }

    public boolean dfs(ArrayList<Integer>[] adjList, int node, boolean[] visited, boolean[] path,Stack<Integer> order) {
        if (visited[node]) return false;
        if (path[node]) return true;

        path[node] = true;

        for (int i = 0; i < adjList[node].size(); i++) {
            if (dfs(adjList, adjList[node].get(i), visited, path, order)) return true;
        }

        visited[node] = true;
        path[node] = false;
        order.push(node);

        return false;
    }
}