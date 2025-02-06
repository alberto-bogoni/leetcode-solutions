import java.util.Stack;

public class Solution {

    public static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();  // Initialize a stack to store character-count pairs.

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }

            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            result.append(String.valueOf((char) top[0]).repeat(top[1]));
        }

        return result.reverse().toString();
    }
}