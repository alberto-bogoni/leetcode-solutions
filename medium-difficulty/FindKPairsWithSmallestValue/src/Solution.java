import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] indices = heap.poll();
            int i = indices[0], j = indices[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                heap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}