import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, target, 0, 0);
    }

    private int dp(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = index + "," + currentSum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = dp(nums, target, index + 1, currentSum + nums[index]) +
                dp(nums, target, index + 1, currentSum - nums[index]);

        memo.put(key, ways);

        return ways;
    }
}