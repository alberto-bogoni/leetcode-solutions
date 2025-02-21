import java.util.LinkedList;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        LinkedList<Integer>[] adjacencyList = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        for (int[] prereq : prerequisites) {
            adjacencyList[prereq[0]].add(prereq[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] currentPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (detectCycle(adjacencyList, visited, currentPath, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean detectCycle(LinkedList<Integer>[] adjacencies, boolean[] visited,
                                boolean[] currentPath, int current) {
        if (currentPath[current]) return true;
        if (visited[current]) return false;

        visited[current] = true;
        currentPath[current] = true;

        for (Integer next : adjacencies[current]) {
            if (detectCycle(adjacencies, visited, currentPath, next)) {
                return true;
            }
        }

        currentPath[current] = false;
        return false;
    }
}