/*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

    Return the sum of the three integers.
*/

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int targetDiff = target - sum;
                if (sum == target)
                    return sum;
                if (Math.abs(target - closestSum) > Math.abs(targetDiff)) {
                    closestSum = sum;
                }
                if (targetDiff < 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closestSum;
    }
}
