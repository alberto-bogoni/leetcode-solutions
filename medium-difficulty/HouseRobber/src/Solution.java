public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev = nums[0];

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int robCur = nums[i] + prev2;
            int noRobCur = prev;

            max = Math.max(robCur, noRobCur);

            prev2 = prev;
            prev = max;
        }

        return prev;
    }
}