import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = nums.length - 1; i > 0; i -= 2) {
            int n = nums[i];
            int c = nums[i - 1];

            sum += Math.min(n, c);
        }

        return sum;
    }
}