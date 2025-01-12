import java.util.Arrays;

public class Solution {

    public void moveZeroes(int[] nums) {
        int nextNonZero = 0;

        Arrays.sort(nums);

        if (nums[0] != 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[nextNonZero++] = temp;
            }
        }
    }
}
