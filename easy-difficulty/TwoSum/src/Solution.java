/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
    target.
*/

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] { map.get(target - nums[i]), i };
            else
                map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
