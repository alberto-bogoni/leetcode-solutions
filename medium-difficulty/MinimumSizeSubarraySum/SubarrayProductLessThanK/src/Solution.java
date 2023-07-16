public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int windowStart = 0;
        int product = 1;
        int subarrays = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
           product *= nums[windowEnd];

           while (product >= k)
               product /= nums[windowStart++];

           subarrays += 1 + (windowEnd - windowStart);
        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));

        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
    }
}
