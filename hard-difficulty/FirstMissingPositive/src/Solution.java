public class Solution {

    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else
                i++;
        }

        for (int c = 0; c < nums.length; c++) {
            if (nums[c] != c + 1)
                return c + 1;
        }

        return nums.length + 1;
    }

}