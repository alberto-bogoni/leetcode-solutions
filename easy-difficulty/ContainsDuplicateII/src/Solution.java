/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such
that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;

        int windowStart = 0;

        for (int windowEnd = 1; windowEnd < nums.length; windowEnd++) {
            if (nums[windowStart] == nums[windowEnd]) {
               return true;
            }

            if (Math.abs(windowEnd - windowStart) >= k) {
                windowStart++;
            }
        }

        return false;
    }

}
