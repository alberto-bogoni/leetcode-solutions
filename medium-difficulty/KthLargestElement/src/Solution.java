import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int count = 0;
        int result = 0;
        while (count < k) {
            count++;
            result = queue.poll();
        }
        return result;
    }
}