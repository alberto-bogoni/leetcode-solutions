public class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;

        int position = start + (end - start) / 2;
        if (nums[position] == target)
            return position;
        else if (nums[position] > target)
            return binarySearch(nums, start, position-1, target);
        else
            return binarySearch(nums, position+1, end, target);
    }
}