import java.util.Arrays;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int longest = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) count++;
            else if (nums[i] == nums[i-1]) continue;
            else count = 1;

            longest = Math.max(longest, count);
        }

        return Math.max(longest, count);
    }
}