import java.util.stream.IntStream;

public class Solution {

    public int missingNumberFirstApproach(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int missing = 0;

        int rangeSum = IntStream.rangeClosed(0, nums.length).sum();
        int numSum = IntStream.of(nums).sum();

        return rangeSum-numSum;
    }

    public int missingNumberSecondApproach(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public int missingNumberThirdApproach(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}