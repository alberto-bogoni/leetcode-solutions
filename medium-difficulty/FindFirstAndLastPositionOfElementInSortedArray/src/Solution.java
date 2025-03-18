public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public int[] search(int[] nums, int start, int end, int target) {
        if (start > end) return new int[] {-1,-1};

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            int temp = mid;
            while (temp >= 0 && nums[temp] == nums[mid]) {
                temp -= 1;
            }
            int left = temp + 1;
            temp = mid;
            while (temp < nums.length && nums[temp] == nums[mid]) {
                temp += 1;
            }
            int right = temp - 1;

            return new int[] {left, right};
        } else if (nums[mid] > target) {
            return search(nums, start, mid - 1, target);
        } else {
            return search(nums, mid + 1, end, target);
        }
    }

    public int[] searchRangeSecond(int[] nums, int target) {
        return searchSecond(nums, 0, nums.length-1, target);
    }

    public int[] searchSecond(int[] nums, int start, int end, int target) {
        if (start > end)
            return new int[]{-1,-1};

        int middle = start + (end - start) / 2;

        if (nums[middle] > target)
            return search(nums, start, middle - 1, target);
        else if (nums[middle] < target)
            return search(nums, middle + 1, end, target);
        else {
            int[] result = new int[]{middle, middle};

            int[] leftResult = search(nums, start, middle - 1, target);
            if (leftResult[0] != -1) {
                result[0] = leftResult[0];
            }

            int[] rightResult = search(nums, middle + 1, end, target);
            if (rightResult[1] != -1) {
                result[1] = rightResult[1];
            }

            return result;
        }
    }
}