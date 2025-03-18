public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;
        if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        } else if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid] < nums[mid + 1]) {
            return search(nums, mid + 1, end);
        } else {
            return search(nums, start, end - 1);
        }
    }

    public int searchSecond(int[] nums, int start, int end) {
        if (start >= end) return start;

        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[mid + 1]) {
            return search(nums, mid + 1, end);
        } else {
            return search(nums, start, end - 1);
        }
    }
}