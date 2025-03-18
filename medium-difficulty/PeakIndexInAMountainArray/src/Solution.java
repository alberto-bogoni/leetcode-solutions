public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return search(arr, 0, arr.length - 1);
    }

    public int search(int[] nums, int start, int end) {
        if (start >= end) return start;

        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[mid + 1]) {
            return search(nums, mid + 1, end);
        } else {
            return search(nums, start, end - 1);
        }
    }
}