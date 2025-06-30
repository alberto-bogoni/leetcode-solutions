import java.util.Arrays;

public class Solution {
    int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        int first = dp(nums, n-1, 1, memo);
        Arrays.fill(memo, -1);
        int second = dp(nums, n-2, 0, memo);
        return Math.max(first, second);
    }

    public int dp(int[] nums, int n, int finish, int[] memo) {
        if (n < finish) return 0;
        if (n == finish) return nums[n];
        if (memo[n] != -1) return memo[n];
        memo[n] = Math.max(dp(nums, n-2, finish,memo) + nums[n], dp(nums,n-1,finish,memo));
        return memo[n];
    }
}