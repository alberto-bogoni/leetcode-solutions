import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        int count = 1;
        while (count < nums.length) {
            if (nums[count] != nums[count - 1]) {
                if (count == nums.length - 1)
                    return nums[count];

                return (nums[count] == nums[count + 1]) ? nums[count - 1] : nums[count];
            }

            count += (count == nums.length - 2) ? 1 : 2;
        }

        return 0;
    }
}
