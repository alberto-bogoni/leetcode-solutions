public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            if (max < currentSum) {
                max = currentSum;
            }
        }

        return max;
    }

}
