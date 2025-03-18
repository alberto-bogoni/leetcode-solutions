public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public boolean search(int[] nums, int start, int end, int target) {
        if (start > end) return false;

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > nums[end]) {
            if (target < nums[mid] && target >= nums[start]) {
                return search(nums, start, mid - 1,target);
            } else {
                return search(nums, mid + 1, end,target);
            }
        } else if (nums[mid] < nums[end]) {
            if (target > nums[mid] && target <= nums[end]) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, start, mid - 1, target);
            }
        } else {
            return search(nums, start, end-1, target);
        }
    }
}