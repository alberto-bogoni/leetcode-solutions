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
}