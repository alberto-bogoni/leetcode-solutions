public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }

        double maxAverage = Double.MIN_VALUE;
        double currentSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentSum += nums[windowEnd];

            if (windowEnd >= k - 1) {
                maxAverage = Math.max(maxAverage, currentSum / k);
                currentSum -= nums[windowStart++];
            }
        }

        return maxAverage;
    }
}
