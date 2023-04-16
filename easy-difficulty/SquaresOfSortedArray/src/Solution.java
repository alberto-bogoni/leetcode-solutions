import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        for(int start = 0, end = nums.length - 1, position = end; start <= end;) {
            int firstSquare = square(nums[start]);
            int secondSquare = square(nums[end]);
            if (firstSquare < secondSquare) {
                result[position--] = secondSquare;
                end--;
            } else {
                result[position--] = firstSquare;
                start++;
            }
        }

        return result;
    }

    private int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3,2, 3, 11})));
    }
}
