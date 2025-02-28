public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[pivot] == target) return pivot;

        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }

    private int findPivot(int[] nums, int start, int end) {
        if (start > end) return -1;
        if (start == end) return start;

        int mid = start + (end - start) / 2;

        if (mid < end && nums[mid] > nums[mid + 1])
            return mid;

        if (mid > start && nums[mid - 1] > nums[mid])
            return mid - 1;

        if (nums[start] >= nums[mid]) {
            return findPivot(nums, start, mid - 1);
        } else {
            return findPivot(nums, mid + 1, end);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
    }
}