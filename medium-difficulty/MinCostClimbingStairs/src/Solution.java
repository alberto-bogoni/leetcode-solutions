public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[dp.length-1], dp[dp.length-2]);
    }

    public int min(int i, int[] cost) {
        if (i == 0 || i == 1) return cost[i];

        return cost[i] + Math.min(min(i-2,cost), min(i-1,cost));
    }
}