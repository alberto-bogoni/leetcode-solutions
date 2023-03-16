import java.util.*;

/*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
    always exists in the array.
*/
public class Solution {
    public int majorityElement(int[] nums) {
        int maxFrequencyFound = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Integer x : map.keySet()) {
            int currentFrequency = map.get(x);

            if (currentFrequency > maxFrequencyFound) {
                maxFrequencyFound = currentFrequency;
                result = x;
            }
        }

        return result;
    }
}
