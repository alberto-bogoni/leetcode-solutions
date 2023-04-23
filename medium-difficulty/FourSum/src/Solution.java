import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // skip same element to avoid duplicate quadruplets
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (isOverflowing(nums[i], nums[j], nums[left], nums[right])) {
                        left++;
                        right--;
                    } else if (sum == target) {
                        quadruplets.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return quadruplets;
    }

    private boolean isOverflowing(int first, int second, int third, int fourth) {
        long sum = (long) first + second + third + fourth;
        return sum > Integer.MAX_VALUE;
    }
}
