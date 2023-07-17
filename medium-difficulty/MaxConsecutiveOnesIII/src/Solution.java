public class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = Integer.MIN_VALUE;
        int maxRepeatingOnes = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 1)
                maxRepeatingOnes++;

            while (windowEnd - windowStart + 1 - maxRepeatingOnes > k) {
                if (nums[windowStart] == 1)
                    maxRepeatingOnes--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
