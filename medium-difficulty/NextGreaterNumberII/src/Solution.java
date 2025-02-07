import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int j = 0; j < 2; j++) {
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    result[i] = nums[stack.peek()];
                }
                stack.push(i);
            }
        }

        return result;
    }
}