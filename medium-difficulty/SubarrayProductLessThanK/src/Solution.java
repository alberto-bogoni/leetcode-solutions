import java.util.Arrays;

/*
    Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of
    all the elements in the subarray is strictly less than k.
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int subArraysCount = 0;
        int prod = 1;

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            prod *= nums[right];

            while (prod >= k) {
                prod /= nums[left++];
            }
            subArraysCount += right - left + 1;

            right++;
        }

        return subArraysCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numSubarrayProductLessThanK(new int[] {1,2,3}, 0));
    }
}
