import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums, return the number of good pairs.

    A pair (i, j) is called good if nums[i] == nums[j] and i < j.
*/
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            pairCount += map.get(n) - 1;
        }
        return pairCount;
    }
}
