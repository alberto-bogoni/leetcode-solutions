public class Solution {
    public int findChampion(int n, int[][] edges) {
        if (edges.length == 0 && n > 1) return -1;

        int[] indegree = new int[n];
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            indegree[u]++;
            count--;
        }

        if (count > 1) return -1;

        count = 0;
        int result = -1;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                count++;
                result = i;
            }
        }

        return count == 1 ? result : -1;
    }
}