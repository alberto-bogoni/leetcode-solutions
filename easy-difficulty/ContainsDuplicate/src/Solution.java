/*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
    element is distinct.
*/

import java.util.HashSet;

public class Solution {

    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int c = 0; c < nums.length; c++) {
                if (c != i) {
                    if (nums[i] == nums[c])
                        return true;
                }
            }
        }

        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> support = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!support.add(nums[i]))
                return true;
        }

        return false;
    }

}
