public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int pairSum = numbers[left] + numbers[right];
            if (pairSum == target) {
                return new int[] {left + 1, right + 1};
            }
            if (pairSum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {-1, -1};
    }
}
