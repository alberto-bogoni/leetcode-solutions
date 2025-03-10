import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 0 -> val
        // 1 -> row
        // 2 -> column
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new int[]{matrix[i][0],i,0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] current = minHeap.poll();
            int row = current[1];
            int col = current[2];

            if (col + 1 < matrix[0].length) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return minHeap.poll()[0];
    }
}