import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer n : stones)
            maxHeap.add(n);

        while (maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();

            if (s1 != s2) {
                maxHeap.add(s1-s2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}