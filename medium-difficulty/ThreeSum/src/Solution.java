import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and
    j != k, and nums[i] + nums[j] + nums[k] == 0.
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            searchPair(nums, -nums[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(
            int[] nums,
            int targetSum,
            int left,
            List<List<Integer>> triplets
    ) {
        int right = nums.length - 1;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            if (targetSum == pairSum) {
                triplets.add(List.of(-targetSum, nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1])
                    left++;
                while (left < right && nums[right] == nums[right + 1])
                    right--;
                continue;
            }
            if (targetSum > pairSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}
