public class Solution {
    public int findMin(int[] nums) {
        return search(nums,0,nums.length-1);
    }

    public int search(int[] nums, int start, int end) {
        if (start >= end) return nums[start];

        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[end]) {
            return search(nums, mid + 1, end);
        } else if (nums[mid] < nums[end]) {
            return search(nums, start, mid);
        } else {
            return search(nums, start, end-1);
        }
    }
}