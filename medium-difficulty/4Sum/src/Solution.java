import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> quadruplets = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int c = i + 1; c < nums.length - 2; c++) {
                if (c > i + 1 && nums[c] == nums[c - 1])
                    continue;

                int left = c + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long currentSum = (long) nums[i] + nums[c] + nums[left] + nums[right];

                    if (currentSum == target) {
                        quadruplets.add(List.of(nums[i],nums[c],nums[left],nums[right]));

                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }
}
